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
    String fbURL = "http://www.facebook.com/dialog/oauth?client_id=415236351913053&redirect_uri=" + URLEncoder.encode("http://localhost:8080//signin_fb.do") + "&scope=email";
%>

<a href="<%= fbURL %>">facebook</a>/home/fragkiskos/Downloads
				</div>
			
				
		
			</div>
			<!-- /main -->
	
			<!-- side -->
			<jsp:include page="news.jsp"/>
		</div>
			
<jsp:include page="footer.jsp"/>	