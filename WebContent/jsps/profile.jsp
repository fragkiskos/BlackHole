<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<%@page import="java.net.URLEncoder" %>
<%@page import="model.User" %>
<%@page import="utils.modelUtils.*" %>
<jsp:include page="header.jsp"/>
			
			<!-- main -->
			<div id="main">
				<div id="#personal info" style="background-color: blue;">
					<div  >
						<h2>Personal details</h2>
						<div>Name</div>
						<div>Sirname</div>
						<div>email</div>
					</div>
				</div>
				<br></br>
				<div id="#personal info2" >
					<div  style="background-color: red;">
						<h2>Personal details</h2>
						<div>Name</div>
						<div>Sirname</div>
						<div>email</div>
					</div>
				</div>
			</div>
			<!-- /main -->
	
			<!-- side -->
			
			
			
			<div id="shares"></div>
			<div id="behaviour"></div>
			
<jsp:include page="footer.jsp"/>	