package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;

import model.Company;
import model.Share;
import model.User;
import utils.HibernateUtil;
import utils.LanguageParsing;
@WebServlet(  urlPatterns = {"/dokimi"})
public class Dokimi extends HttpServlet{

	 public void doGet( HttpServletRequest request,
             HttpServletResponse response) throws ServletException, IOException{
		 System.out.println("ok");
		 System.out.print(LanguageParsing.getValue("latestNews"));
		 java.util.Date date= new java.util.Date();
		 
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	     session.beginTransaction();
	     Company company = new Company(new Long(1), "http://www.google.com", "google", "aasdsadadaada", "sdfsf", new Long(1));
	     session.save(company);
	        session.getTransaction().commit();
		 RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		   // view.forward(request, response);
		    response.getWriter().print("all right");
	 }
}
