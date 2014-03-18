package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import utils.modelUtils.UserUtil;
import model.User;

/**
 * Servlet implementation class SaveForgotMyPassword
 */
@WebServlet("/SaveForgotMyPassword")
public class SaveForgotMyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveForgotMyPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String question = "";
		String answer = "";
		
		if(request.getParameter("question")!=null){
			question = (String) request.getParameter("question");
		}
		if(request.getParameter("answer")!=null){
			answer = (String) request.getParameter("answer");
		}
		HttpSession session  = request.getSession();
		User user =(User) request.getSession().getAttribute("user");
		user.setPassQuestion(question);
		user.setPassAnswer(answer);
		boolean ok = UserUtil.Save(user);
		if(ok){
			response.getWriter().print("ok");
		}else{
			response.getWriter().print("wrong");
		}
	}

}
