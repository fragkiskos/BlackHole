<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<%@page import="java.net.URLEncoder" %>
<jsp:include page="header.jsp"/>
			
			<!-- main -->
			<div id="main">
			<div id="intro">
			<%
			if(request.getSession().getAttribute("Message")!=null){
				String message = (String)request.getSession().getAttribute("Message");
				String success = message.split("###")[0];
				if(success.equals("success")){%>
					<div class="success"><%=message.split("###")[1] %></div>
				<% }else{%>
					<div class="error"><%=message.split("###")[1] %></div>
				<% }
				request.getSession().setAttribute("Message", null);
			}
				%>
			
			</div>
			</div>
			<!-- /main -->
	
			<!-- side -->
			<jsp:include page="news.jsp"/>
			
		</div>
			
<jsp:include page="footer.jsp"/>	