<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<%@page import="java.net.URLEncoder" %>
<%@page import="model.User" %>
<%@page import="utils.modelUtils.*" %>
<jsp:include page="header.jsp"/>
<script type="text/javascript">

	
	function validateForm(){
		document.getElementById("loader").setAttribute("style", "visibility:visible");
		document.getElementById("error").setAttribute("style", "display:none");
		document.getElementById("questionMissing").setAttribute("style", "display:none");
		document.getElementById("answerMissing").setAttribute("style", "display:none");
		var question = $('#question').val();
		var validate = true;
		if(question.length == 0){
			document.getElementById("error").setAttribute("style", "display:block");
			document.getElementById("emailMissing").setAttribute("style", "display:block");
			validate = false;
		}
		var answer = document.getElementById("answer").value;
		if(answer == 0 ){
			document.getElementById("error").setAttribute("style", "display:block");
			document.getElementById("answerMissing").setAttribute("style", "display:block");
			validate = false;
		}
		var serverResponse; 
		if(validate){
			$.ajax({
	            type: "get",
	            url: "http://localhost:8080/itstock/SaveForgotMyPassword?answer="+answer+"&question="+question, //this is my servlet
	            async: false,
	            success: function(msg){      
	            	serverResponse=msg;
	            }
	        });
			if(serverResponse == "ok"){
				document.getElementById("error").setAttribute("style", "display:none");
				document.getElementById("success").setAttribute("style", "display:block");
			}
		}
		document.getElementById("loader").setAttribute("style", "visibility:hidden");
		return false;
	}
	
	
</script>			
			<!-- main -->
			<div id="main">
			<div id="intro">
			<%
			if(request.getSession().getAttribute("Message")!=null){
				String message = (String)request.getSession().getAttribute("Message");
				String success = message.split("###")[0];
				if(success.equals("success")){%>
					
	<% 
	User user = (User)request.getSession().getAttribute("user");
	if(user.getFirstLogin()){
			user.setFirstLogin(false);
			UserUtil.Save(user);
			
			%>
			<div class="success"><%=message.split("###")[1] %></div>
		
					<form action="/itstock/SaveForgotMyPassword" method="post" class="basic-grey" onsubmit="return validateForm();">
     <div id="error"  class="error" style="display:none">
     <p id="questionMissing" style="display:none"><%=LanguageParsing.getValue("login.message.validate.question") %></p>
     <p id="answerMissing" style="display:none"><%=LanguageParsing.getValue("login.message.validate.answer") %></p>
     
     </div>
     <div id="success" class="success" style="display:none" >
     	<p><%=LanguageParsing.getValue("passwordRemind.succes") %></p>
     </div>
     <label>
        <span><%=LanguageParsing.getValue("login.question") %>: </span>
        <input id="question" type="text" name="question" value="<%=LanguageParsing.getValue("login.question.default") %>" />
    </label>
     <label>
        <span><%=LanguageParsing.getValue("login.answer") %> :</span>
        <input id="answer" type="text" name="answer" placeholder="<%=LanguageParsing.getValue("login.answer") %>"  />
    </label>
     
    
     <label>
        <span>&nbsp;</span> 
        
        <input  type="submit" class="button" value="<%=LanguageParsing.getValue("login.button.save") %>"></input> 
        <br></br>
		<span>&nbsp;</span> 
        <img id="loader" style="visibility:hidden" src="../images/ajax-loader.gif" alt="loading_gif" width="230 px" height="10px"/> 
          
    </label> 
   

       
</form>
<%}else{ %>
	<div class="success"><%=LanguageParsing.getValue("login.message.success.login") %></div>
<%} %>
				<% }else{%>
					<div class="error"><%=message.split("###")[1] %></div>
				<% }
				request.getSession().setAttribute("Message", null);
				
			}else{
				%>
				<div class="success"><%=LanguageParsing.getValue("login.message.success.logout") %></div>
				<%} %>
			
			</div>
			</div>
			<!-- /main -->
	
			<!-- side -->
			<jsp:include page="news.jsp"/>
			
		</div>
			
<jsp:include page="footer.jsp"/>	