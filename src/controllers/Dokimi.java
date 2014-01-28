package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import utils.LanguageParsing;
@WebServlet(  urlPatterns = {"/dokimi"})
public class Dokimi extends HttpServlet{

	 public void doGet( HttpServletRequest request,
             HttpServletResponse response) throws ServletException, IOException{
		 System.out.println("ok");
		 System.out.print(LanguageParsing.getValue("latestNews"));
		 RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		    view.forward(request, response);
	 }
}