package controlers.Messaging;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import model.Notification;
import model.User;
import utils.Navigation;
import utils.dbUtils.DbTransactions;

/**
 * Servlet implementation class DeleteNotification
 */
@WebServlet("/deleteNotification")
public class DeleteNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNotification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param1 = request.getParameter("notificationId");
		try{
			User user = (User) request.getSession().getAttribute("user");
			long notId = Long.parseLong(param1);
			DbTransactions.deleteObjectById(Notification.class.getCanonicalName(), notId);
			Navigation.redirectNotifications(request, response, user.getId(), "notifications.delete.successMessage", "success");
		}catch(Exception ex){
			Navigation.logoutRedirect(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
