package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import utils.dbUtils.DbTransactions;
import utils.messageUtil.Messager;
@WebServlet(  urlPatterns = {"/dokimi"})
public class Dokimi extends HttpServlet{

	 public void doGet( HttpServletRequest request,
             HttpServletResponse response) throws ServletException, IOException{
		 System.out.println("ok");
		 System.out.print(LanguageParsing.getValue("latestNews"));
		 java.util.Date date= new java.util.Date();
		 long l =2;
		 double d =3.0;
		 Boolean b = true;
		 Map properties = new HashMap<String,String>();
		
		 String dateString = "2014-02-18 17:58:29";
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 try {
			Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
			 properties.put("old_price",l);
			 properties.put("date", date2);
			//List<Hit> o = (List<Hit>)(List<?>) DbTransactions.getObjectsByProperties(Hit.class.getCanonicalName(), properties);
			//List<Hit> o = (List<Hit>)(List<?>) DbTransactions.getObjectsByProperty(Hit.class.getCanonicalName(), "date",date2);
			//System.out.println(o.size());
			// DbTransactions.deleteObjectById(Hit.class.getCanonicalName(), 4);
			 
				model.Message message = Messager.getMessage(l);
				Messager.replyMessage(message, "sdfsfsfds");
				
			 //RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			   // view.forward(request, response);
			    response.getWriter().print("all right ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	     
	 }
}
