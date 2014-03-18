package controlers.Messaging;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.dbUtils.DbTransactions;
import utils.messageUtil.Messager;

/**
 * Servlet implementation class ReadMessage
 */
@WebServlet("/readMessage")
public class ReadMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param =  request.getParameter("messageId");
		Long messageId = Long.parseLong(param);
		model.Message message = Messager.getMessage(messageId);
		message.setReaded(true);
		DbTransactions.updateObject(message);
		HttpSession session = request.getSession(false);
		session.setAttribute("message", message);
		
	    response.sendRedirect("jsps/messaging/message.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
