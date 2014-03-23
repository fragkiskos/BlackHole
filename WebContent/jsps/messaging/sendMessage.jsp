<%@page import="utils.modelUtils.UserUtil"%>
<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="model.BreakingNew"%>
<%@ page import="java.util.List"%>
<%@ page import="utils.NewsParser"%>
<%@ page import="utils.LanguageParsing"%>
<%@ page import="model.Message" %>
<jsp:include page="messagesHeader.jsp" />
<%@ page import="model.User" %>
<%@ page import="model.Message" %>
<%
User user = (User)request.getSession().getAttribute("user");
if(user!=null){
	
%>
<script type="text/javascript">
function validateForm(){
	document.getElementById("error").setAttribute("style", "display:none");
	document.getElementById("usernameMissing").setAttribute("style", "display:none");
	document.getElementById("loader").setAttribute("style", "visibility:visible");
	var email = $('#reciever').val();
	var theme = $('#theme').val();
	var validate = true;
	if(email.length == 0){
		document.getElementById("error").setAttribute("style", "display:block");
		document.getElementById("usernameMissing").setAttribute("style", "display:block");
		validate = false;
	}
	

	document.getElementById("loader").setAttribute("style", "visibility:hidden");
	return validate;
}
</script>
<!-- side -->
<div id=mailSide>
			<ul class="side-menu">
					<li><a href="../../getIncoming?userId=<%=user.getId() %>"><%=LanguageParsing.getValue("messaging.incoming") %></a></li>
					<li><a href="../../getOutgoing?userId=<%=user.getId() %>"><%=LanguageParsing.getValue("messaging.outgoing") %></a></li>
					
				</ul>
			</div>
<!-- /side -->
<!-- main -->

<div id=mailMain>
	 
	<form action="/itstock/sendMessage" method="post" class="basic-grey" onsubmit="return validateForm();">
	<div id="error"  class="error" style="display:none">
     <p id="usernameMissing" style="display:none"><%=LanguageParsing.getValue("messaging.validate.usernameMissing") %></p>
     </div>
		<label> <span><%=LanguageParsing.getValue("messaging.reciever") %>:
		</span> <input style="color:black" id="reciever" type="text" name="reciever"
			 />
		</label>
		
		 <label> <span><%=LanguageParsing.getValue("messaging.theme") %>
				:</span> <input style="color:black;" id="theme" type="text" name="theme" 
				  />
		</label>
		
		<label>
		<span style="visibility:hidden"><%=LanguageParsing.getValue("messaging.theme") %>
				:</span> 
		   <textarea  name="text">
		  
		  </textarea>
		 </label>  
		   
			
		
		
		 
		
		<label> <span>&nbsp;</span> <input type="submit"
			class="button"
			value="<%=LanguageParsing.getValue("messaging.actions.sendEmail") %>"></input>
			 <br></br>
		<span>&nbsp;</span> 
        <img id="loader" style="visibility:hidden" src="../images/ajax-loader.gif" alt="loading_gif" width="230 px" height="10px"/> 
          


		</label>



	</form>
	<br></br>
</div>
<!-- /main -->

<%} %>

<jsp:include page="../footer.jsp" />