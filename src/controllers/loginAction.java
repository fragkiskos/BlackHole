package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginAction
 */
@WebServlet(  urlPatterns ={"/loginAction"})
public class loginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginAction() {
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
		String name="";
		String username = "";
		String email = "";
		String sirname = "";
		String phone = "";
		
		if(request.getParameter("name")!=null){
			name = (String) request.getParameter("name");
		}
		if(request.getParameter("username")!=null){
			username = (String) request.getParameter("username");
		}
		if(request.getParameter("email")!=null){
			email = (String) request.getParameter("email");
		}
		if(request.getParameter("sirname")!=null){
			sirname = (String) request.getParameter("sirname");
		}
		if(request.getParameter("phone")!=null){
			phone = (String) request.getParameter("phone");
		}
		response.getWriter().println("name:"+name);
		response.getWriter().println("username:"+username);
		response.getWriter().println("email:"+email);
		response.getWriter().println("sirname:"+sirname);
		response.getWriter().println("phone:"+phone);
	}

}
