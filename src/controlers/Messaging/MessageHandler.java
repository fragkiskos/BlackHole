package controlers.Messaging;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import com.google.code.facebookapi.schema.Message;

import sun.rmi.transport.proxy.HttpReceiveSocket;
import utils.LanguageParsing;
import utils.Navigation;
import utils.dbUtils.DbTransactions;
import utils.messageUtil.Messager;

/**
 * Servlet implementation class MailSender
 */
@WebServlet("/messageHandler")
public class MessageHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User test = (User) request.getSession().getAttribute("user");
			if (test != null) {
				
				User user = (User) request.getSession().getAttribute("user");
				String action = "";
				if (request.getParameter("action") != null) {
					action = (String) request.getParameter("action");
					response.getWriter().print(action);
				}
				String all = "";
				if (request.getParameter("all") != null) {
					all = (String) request.getParameter("all");
					response.getWriter().println(all);
				}
				if (action.equals("delete")) {
					try {
						if (all.equals("")) {
							String check;
							for (int i = 0; i < 10; i++) {
								if (request.getParameter(String.valueOf(i)) != null) {
									check = (String) request
											.getParameter(String.valueOf(i));
									DbTransactions.deleteObjectById(
											model.Message.class
													.getCanonicalName(), Long
													.parseLong(check));
								}
							}
						} else {
							DbTransactions.deleteObjectsByProperty(
									model.Message.class.getCanonicalName(),
									"recieverId", user.getId());
						}
						Navigation.redirect(request, response, user.getId(),
								"messaging.delete.successMessage", "success");
					} catch (Exception deleteEx) {
						Navigation.redirect(request, response, user.getId(),
								"messaging.delete.errorMessage", "error");
					}  

				} else {
					try {
						if (all.equals("")) {
							String check;
							for (int i = 0; i < 10; i++) {
								if (request.getParameter(String.valueOf(i)) != null) {
									check = (String) request
											.getParameter(String.valueOf(i));
									model.Message message = Messager
											.getMessage(Long.parseLong(check));
									message.setReaded(true);
									DbTransactions.updateObject(message);

								}
							}
						} else {
							List<model.Message> messages = Messager
									.getIncoming(user.getId());
							for (int i = 0; i < messages.size(); i++) {
								model.Message message = messages.get(i);
								message.setReaded(true);
								DbTransactions.updateObject(message);
							}

						}
						Navigation.redirect(request, response, user.getId(),
								"messaging.signAsRead.successMessage",
								"success");
					} catch (Exception signException) {
						Navigation.redirect(request, response, user.getId(),
								"messaging.signAsRead.errorMessage", "error");
					}

				}
			}else{
				Navigation.logoutRedirect(request, response);
			}  
  
		} catch (Exception logoutException) {
			Navigation.logoutRedirect(request, response);
		}

	}

}
