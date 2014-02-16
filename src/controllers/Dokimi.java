package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;

import model.CallForBuy;
import model.CallForSell;
import model.Company;
import model.Exchange;
import model.ExchangePanel;
import model.PanelBuyers;
import model.PanelExchanges;
import model.PanelSellers;
import model.PanelShareNegotiations;
import model.Share;
import model.Hit;
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
		 long l = 0;
		 double d = 0.0;
		 Boolean b = true;
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	     session.beginTransaction();
	     //Νegotiation o = new Νegotiation( l, l, d, d, date);
	     //session.save(o);
	     PanelExchanges o = new PanelExchanges(l, l);
	     session.save(o);
	     session.getTransaction().commit();
		 RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		   // view.forward(request, response);
		    response.getWriter().print("all right");
	 }
}
