package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.LanguageParsing;
import utils.modelUtils.UserUtil;

/**
 * Servlet implementation class createAccount
 */
@WebServlet("/createAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
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
		try{
			boolean create = UserUtil.createUser(name, username, email, sirname, phone, "itstock");
			//boolean create=true;
			if(create){
				request.getSession().setAttribute("Message", "success###"+LanguageParsing.getValue("login.message.success"));
			}else{
				request.getSession().setAttribute("Message","failure###" +LanguageParsing.getValue("login.message.failure"));
			}
		}catch(Exception ex){
			request.setAttribute("Message","failure###" +LanguageParsing.getValue("login.message.failure"));
		}
		
		
		response.sendRedirect("jsps/message.jsp");
	}

}
