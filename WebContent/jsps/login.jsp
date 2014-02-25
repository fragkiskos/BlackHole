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

<script type="text/javascript">
$( document ).ready(function() {
	$('#email').focusout(function(){
		var value = document.getElementById("email").value;
		var indexOfAt = value.indexOf("@");
		value = value.substring(0,indexOfAt);
		document.getElementById("username").setAttribute("value", value);
	});
	});
	
	function validateForm(){
		document.getElementById("error").setAttribute("style", "display:none");
		document.getElementById("emailMissing").setAttribute("style", "display:none");
		document.getElementById("usernameMissing").setAttribute("style", "display:none");
		document.getElementById("userExists").setAttribute("style", "display:none");
		document.getElementById("loader").setAttribute("style", "visibility:visible");
		var email = $('#email').val();
		var validate = true;
		if(email.length == 0){
			document.getElementById("error").setAttribute("style", "display:block");
			document.getElementById("emailMissing").setAttribute("style", "display:block");
			validate = false;
		}
		var username = document.getElementById("username").value;
		if(username == 0 ){
			document.getElementById("error").setAttribute("style", "display:block");
			document.getElementById("usernameMissing").setAttribute("style", "display:block");
			validate = false;
		}
		if(email.length > 0){
			userAlreadyExists="false";
			$.ajax({
	            type: "get",
	            url: "http://localhost:8080/itstock/userExists", //this is my servlet
	            data: "email=" +email,
	            async: false,
	            success: function(msg){      
	            	userAlreadyExists=msg;
	            }
	        });
			if(userAlreadyExists=="false"){
				if(validate){
					return true;
				}
				
			}else{
				document.getElementById("error").setAttribute("style", "display:block");
				document.getElementById("userExists").setAttribute("style", "display:block");
				document.getElementById("loader").setAttribute("style", "visibility:hidden");
				return false;
			}
		}
		document.getElementById("loader").setAttribute("style", "visibility:hidden");
		return false;
	}
	
	
</script>

<div><b><%=LanguageParsing.getValue("login.message") %></b><br></br><a href="#"><img src="../images/facebook.jpg" alt="facebook" width="80px"  height="20px"/> </a>

<a href="#"><img src="../images/gmail.jpg" alt="gmail" width="60px" height="20px"/> </a></div>
<br></br>

<form action="/itstock/loginAction" method="post" class="basic-grey" onsubmit="return validateForm();">
     <div id="error"  class="error" style="display:none">
     <p id="emailMissing" style="display:none"><%=LanguageParsing.getValue("login.message.validate.email") %></p>
     <p id="usernameMissing" style="display:none"><%=LanguageParsing.getValue("login.message.validate.username") %></p>
     <p id="userExists" style="display:none"><%=LanguageParsing.getValue("login.message.validate.emailExistance") %></p>
     </div>
     
     <label>
        <span><%=LanguageParsing.getValue("login.email") %>: <span style="color:red">*</span></span>
        <input id="email" type="email" name="email" placeholder="<%=LanguageParsing.getValue("login.email") %>" />
    </label>
     <label>
        <span><%=LanguageParsing.getValue("login.username") %> :</span>
        <input id="username" type="text" name="username"  />
    </label>
    <label>
        <span><%=LanguageParsing.getValue("login.name") %> :</span>
        <input id="name" type="text" name="name" placeholder="<%=LanguageParsing.getValue("login.name") %>" />
    </label>
    
     <label>
        <span><%=LanguageParsing.getValue("login.sirname") %> :</span>
        <input id="sirname" type="text" name="sirname" placeholder="<%=LanguageParsing.getValue("login.sirname") %>" />
    </label>
    
    <label>
        <span><%=LanguageParsing.getValue("login.phone") %> :</span>
        <input id="phone" type="text" name="phone" placeholder="<%=LanguageParsing.getValue("login.phone") %>" />
    </label>  
    
     <label>
        <span>&nbsp;</span> 
        
        <input  type="submit" class="button" value="<%=LanguageParsing.getValue("login.action.message") %>"></input> 
        <br></br>
		<span>&nbsp;</span> 
        <img id="loader" style="visibility:hidden" src="../images/ajax-loader.gif" alt="loading_gif" width="230 px" height="10px"/> 
          
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