package controlers.Messaging;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Notification;
import utils.dbUtils.DbTransactions;
import utils.dbUtils.Pagination;
import utils.messageUtil.Messager;

/**
 * Servlet implementation class GetNotifications
 */
@WebServlet("/getNotifications")
public class GetNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNotifications() {
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
			List<model.Notification> allNotifications = Messager.getNotifications(userId);
			
			List<model.Notification> notifications;
			if(allNotifications.size()>10){
				 notifications =  Messager.getNotifications(userId).subList(start, end);
			}else{
				notifications = allNotifications;
			}
			if(notifications.size()>0){
				for(int i=0;i<notifications.size();i++){
					Notification not = notifications.get(i);
					not.setReaded(true);
					DbTransactions.updateObject(not);
				}
			}
			HttpSession session = request.getSession(false);
			session.setAttribute("notifications", notifications);
			session.setAttribute("notificationsCount", allNotifications.size());
			session.setAttribute("start", start);
			session.setAttribute("end", end);
			session.setAttribute("hasPrevious", Pagination.hasPrevious(start));
			session.setAttribute("hasNext", Pagination.hasNext(end, allNotifications.size()));
			if(Pagination.hasNext(end, allNotifications.size())){
				session.setAttribute("next", Pagination.getPaginationNext(start, end, allNotifications.size()));
			} 
			if(Pagination.hasPrevious(start)){
				session.setAttribute("previous", Pagination.getPaginationPrevious(start));
			}
			
			response.sendRedirect("jsps/messaging/notifications.jsp");
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
