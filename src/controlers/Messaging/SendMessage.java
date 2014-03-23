package controlers.Messaging;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import model.User;
import utils.messageUtil.Messager;
import utils.modelUtils.UserUtil;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/sendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reciever = "";
		String theme = "";
		String text="";
		
		if(request.getParameter("reciever")!=null){
			reciever = (String) request.getParameter("reciever");
		}
		if(request.getParameter("theme")!=null){
			theme = (String) request.getParameter("theme");
			byte[] b = theme.getBytes("UTF-8");
			theme = new String(b);
		}
		if(request.getParameter("text")!=null){
			text = (String) request.getParameter("text");
			byte[] c = text.getBytes("UTF-8");
			text = new String(c);
		}
		User user = (User) request.getSession().getAttribute("user");
		Date now = new Date();
		User recieverOb = UserUtil.getUserByUsername(reciever);
		Message message = new Message(user.getId(), recieverOb.getId(), text, theme, now, false);
		Messager.sendMessage(message);
		response.sendRedirect("getIncoming?userId="+user.getId());
	}

}
