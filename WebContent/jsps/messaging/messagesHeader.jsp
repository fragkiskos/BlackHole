<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<%@ page import="model.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>ItStock</title>
	<script type="text/javascript" src="../../js/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="../../js/menu.js"></script>
	<script type="text/javascript" src="../../js/slideshow.js"></script>
	<script type="text/javascript" src="../../js/cufon-yui.js"></script>
	<script type="text/javascript" src="../../js/Arial.font.js"></script>
	<script type="text/javascript">
		Cufon.replace('h1,h2,h3,h4,h5,#menu,#copy,.blog-date');
	</script>
	<script type="text/javascript" src="../../js/fancyzoom.min.js"></script>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$('div.photo a').fancyZoom({directory: 'images/zoom', scaleImg: true, closeOnClick: true});
		});
	</script>
	<link rel="stylesheet" href="../../css/main.css" type="text/css" />
	<link rel="stylesheet" href="../../css/style.css" type="text/css" />
	<link rel="stylesheet" href="../../css/menu.css" type="text/css" />
</head>
<body>
<h1>ItStock</h1>
	<div id="bg">
	
	<div style="background-color:gray;">
<div class="primary">
        <p style="visibility:hidden">Primary Sidebar</p>
    </div>
    
    <div class="content">
        <form method="get" action="/search" id="search">
  			<input name="q" type="text" size="40" placeholder="Search..." />
		</form>
    </div>
    <% 
    boolean logedIn = false;
    if(request.getSession().getAttribute("user")!=null){
    	 logedIn =(Boolean) request.getSession().getAttribute("logedIn");
    	 
    }
    User user = (User)request.getSession().getAttribute("user");
         %>
    <div class="secondary">
    
    <%if(logedIn){ %>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="profile.jsp" class="username"> <%=user.getUsername() %>&nbsp;</a>
        <span class="noti_Container">
        <a href="../../getIncoming?userId=<%=user.getId()%>">
        <img src="../../images/menu/mail.png" class="menuIcon" title="messages"/>
        <span class="noti_bubble">2</span>
        </a>
        </span>
        <span class="noti_Container">
        <img src="../../images/menu/notifications.png" class="menuIcon" title="notifications"/>
        <span class="noti_bubble">2</span>
        </span>
       <a href="/itstock/logout"> <img src="../../images/menu/exit.png" class="menuIcon" title="logout" /></a>
        <%}else{ %>
        <div >
        	<form method="post" action="/itstock/loginAction" id="signIn">
        	<div class="primary">
        		<input name="username" type="text" size="20" placeholder="username" />
        	</div>
        	<div class="content">
  				<input name="password" type="password" size="20"  placeholder="password" />
  			</div>
  			<div class="secondary">
  				<input id="loginButton" type="submit" value="σύνδεση" />
  				</div>
	 		</form> 
	 	</div> 
        <%} %>
      
    </div>	


	</div>
	</div>
		<div class="wrap">
			
			<!-- logo 
			<h1><a href="index.jsp">ItStock</a></h1>
			<!-- /logo -->
			
			<!-- menu -->
			<div id="mainmenu">
				<ul id="menu">
					<li><a class="current" href="../index.jsp"><%=LanguageParsing.getValue("home") %></a></li>
					<li><a href="../inner.jsp"><%=LanguageParsing.getValue("actions") %></a>
						<ul><li><a href="../inner.jsp"><%=LanguageParsing.getValue("buy") %></a></li><li><a href="../inner.jsp"><%=LanguageParsing.getValue("sell") %></a></li></ul>
					</li>
					<li><a href="../portfolio.jsp"><%=LanguageParsing.getValue("statistics") %></a></li>
					<li><a href="../about.jsp"><%=LanguageParsing.getValue("about") %></a></li>
					<li><a href="../contact.jsp"><%=LanguageParsing.getValue("contact") %></a></li>
					<li><a href="../login.jsp"><%=LanguageParsing.getValue("login") %></a></li>
				</ul>
			</div>
			<!-- /menu -->
			<!-- pitch -->
			<div id="mailPitch">
				
			</div>
			<!-- /pitch -->
			