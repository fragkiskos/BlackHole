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

<div><a href="#"><img src="../images/facebook.jpg" alt="facebook" width="20px"  height="5px"/> </a>

<a href="#"><img src="../images/gmail.jpg" alt="facebook" width="20px" height="5px"/> </a></div>
<br></br>
<form action="dokimi" method="post" class="basic-grey">
   
    <label>
        <span>Name :</span>
        <input id="name" type="text" name="name" placeholder="Your Full Name" />
    </label>
    
     <label>
        <span>Sirname :</span>
        <input id="sirname" type="text" name="sirname" placeholder="Your Sirname " />
    </label>
    
    <label>
        <span>Username :</span>
        <input id="username" type="text" name="username" placeholder="Your Username " />
    </label>
    
    
    <label>
        <span>phone :</span>
        <input id="phone" type="text" name="phone" placeholder="Your phone " />
    </label>
    
    <label>
        <span>Email :</span>
        <input id="email" type="email" name="email" placeholder="Valid Email Address" />
    </label>
    
    <label>
        <span>Message :</span>
        <textarea id="message" name="message" placeholder="Your Message to Us"></textarea>
    </label> 
     <label>
        <span>Subject :</span><select name="selection">
        <option value="Job Inquiry">Job Inquiry</option>
        <option value="General Question">General Question</option>
        </select>
    </label>    
     <label>
        <span>&nbsp;</span> 
        <input type="button" class="button" value="Send" /> 
    </label>    
</form>
<br></br>


				</div>
			
				
		
			</div>
			<!-- /main -->
	
			<!-- side -->
			
			<jsp:include page="news.jsp"/>
		</div>
			
<jsp:include page="footer.jsp"/>	