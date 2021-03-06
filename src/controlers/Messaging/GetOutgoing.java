package controlers.Messaging;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.dbUtils.Pagination;
import utils.messageUtil.Messager;

/**
 * Servlet implementation class GetOutgoing
 */
@WebServlet("/getOutgoing")
public class GetOutgoing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOutgoing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int start = 0;
		int end = 10;
		String param =  request.getParameter("userId");
		String param1 = request.getParameter("start");
		String param2 = request.getParameter("end");
		if(param1!=null){
			try{
				start = Integer.parseInt(param1);
			}catch(Exception ex){
				start = 0;
			}
			
		}
		if(param2!=null){
			try{
				end = Integer.parseInt(param2);
			}catch(Exception ex){
				end = 10;
			}
			
		}
		try{
			Long userId = Long.parseLong(param);
			List<model.Message> allMessages = Messager.getOutGoing(userId);
			List<model.Message> messages;
			if(allMessages.size()>10){
				 messages =  Messager.getOutGoing(userId).subList(start, end);
			}else{
				 messages = allMessages;
			}
			
			HttpSession session = request.getSession(false);
			session.setAttribute("messages", messages);
			session.setAttribute("kind", "Outgoing");
			session.setAttribute("messagesCount", allMessages.size());
			session.setAttribute("start", start);
			session.setAttribute("end", end);
			session.setAttribute("hasPrevious", Pagination.hasPrevious(start));
			session.setAttribute("hasNext", Pagination.hasNext(end, allMessages.size()));
			if(Pagination.hasNext(end, allMessages.size())){
				session.setAttribute("next", Pagination.getPaginationNext(start, end, allMessages.size()));
			}
			if(Pagination.hasPrevious(start)){
				session.setAttribute("previous", Pagination.getPaginationPrevious(start));
			}
			
			response.sendRedirect("jsps/messaging/messages.jsp");
		}catch(Exception ex){
			response.sendRedirect("jsps/index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
