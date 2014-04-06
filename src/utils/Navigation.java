package utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Navigation {

	public static void redirect(HttpServletRequest request,HttpServletResponse response,  long id,String message,String success) throws IOException{
		request.getSession().setAttribute("sessionMessage", LanguageParsing.getValue(message));
		request.getSession().setAttribute("sessionMessageClass", success);
		String kind = (String)request.getSession().getAttribute("kind");
		if(kind!=null && kind.equals("Outgoing")){
			response.sendRedirect("getOutgoing?userId="+id);
		}else{
			response.sendRedirect("getIncoming?userId="+id);
		}
		
	}
	
	public static void redirectNotifications(HttpServletRequest request,HttpServletResponse response,  long id,String message,String success) throws IOException{
		request.getSession().setAttribute("sessionMessage", LanguageParsing.getValue(message));
		request.getSession().setAttribute("sessionMessageClass", success);
		String kind = (String)request.getSession().getAttribute("kind");
		response.sendRedirect("getNotifications?userId="+id);
		
		
	}
	
	public static void logoutRedirect(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		response.sendRedirect("jsps/index.jsp"); 
	}
}
