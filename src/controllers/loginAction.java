package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import utils.LanguageParsing;
import utils.dbUtils.DbTransactions;
import utils.modelUtils.UserUtil;

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
		
		RequestDispatcher view = request.getRequestDispatcher("/jsps/index.jsp");
		
		
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = "";
		String password = "";
		
		if(request.getParameter("username")!=null){
			username = (String) request.getParameter("username");
		}
		if(request.getParameter("password")!=null){
			password = (String) request.getParameter("password");
		}
		User user = UserUtil.getUserByUsername(username);
		
		if(user!=null){
			 
			 try {
				String passwordEncoded = UserUtil.makeSHA1Hash(password);
				if(user.getPassword().equals(passwordEncoded)){
					response.getWriter().print("ok you are logged in");
					request.getSession().setAttribute("Message", "success###"+LanguageParsing.getValue("login.message.success.login.firstTime"));
					request.getSession().setAttribute("user",user);
					request.getSession().setAttribute("logedIn", true);
				}else{
					response.getWriter().print("false password bitch");
					request.getSession().setAttribute("Message","failure###" +LanguageParsing.getValue("login.message.failure.falsePassword"));
					request.getSession().setAttribute("logedIn", false);
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("no such algorithm");
				request.getSession().setAttribute("Message","failure###" +LanguageParsing.getValue("login.message.failure.falseAlgorithm"));
				request.getSession().setAttribute("logedIn", false);
				
			}
			 
		}else{
			response.getWriter().print("user not exists");
			request.getSession().setAttribute("Message","failure###" +LanguageParsing.getValue("login.message.failure.userNotExists"));
			request.getSession().setAttribute("logedIn", false);
		}
		
		
		response.sendRedirect("jsps/loginMessage.jsp");
		
		
	}

}
