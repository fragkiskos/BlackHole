<%@page import="utils.modelUtils.UserUtil"%>
<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew"%>
<%@ page import="java.util.List"%>
<%@ page import="utils.NewsParser"%>
<%@ page import="utils.LanguageParsing"%>
<%@ page import="model.Message" %>
<jsp:include page="messagesHeader.jsp" />
<%@ page import="model.User" %>
<%@ page import="model.Message" %>
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
<%
User user = (User)request.getSession().getAttribute("user");
if(user!=null){
	
%>
<!-- side -->
<div id=mailSide>
			<ul class="side-menu">
					<li><a href="../../getIncoming?userId=<%=user.getId() %>"><%=LanguageParsing.getValue("messaging.incoming") %></a></li>
					<li><a href="../../getOutgoing?userId=<%=user.getId() %>"><%=LanguageParsing.getValue("messaging.outgoing") %></a></li>
					
				</ul>
			</div>
<!-- /side -->
<!-- main -->
<%
	Message  message = (Message)session.getAttribute("message");
String kind = (String)session.getAttribute("kind");
%>
<script type="text/javascript">

function reply(){
	var textarea = document.getElementById("msgBody").innerHTML;
	$("#sender").attr("readonly", false);
	var sender = document.getElementById("sender").getAttribute("value");
	document.getElementById("senderLabel").innerHTML='<%=LanguageParsing.getValue("messaging.reciever")+":" %>';
	document.getElementById("msgBody").innerHTML="";
	document.getElementById("msgBody").focus();
	document.getElementById("msgBody").removeAttribute("readonly");
	document.getElementById("msgBody").innerHTML=textarea+"\n ----------------------------"+'<%=LanguageParsing.getValue("messaging.actions.reply") %>'+" στον "+sender+"---------------\n";
	document.getElementById("replyBtn").removeAttribute("onclick");
	document.getElementById("replyBtn").setAttribute("value", '<%=LanguageParsing.getValue("messaging.actions.sendEmail")%>');

}
function forward(){
	$("#reciever").attr("readonly", false);
	document.getElementById("reciever").setAttribute("value", "");
	document.getElementById("reciever").focus();
	document.getElementById("forwardBtn").removeAttribute("onclick");
	document.getElementById("forwardBtn").setAttribute("value", '<%=LanguageParsing.getValue("messaging.actions.sendEmail")%>');
}

</script>
<div id=mailMain>
	<form  action="/itstock/sendMessage" method="post" class="basic-grey" onsubmit="return validateForm();">
	<%if(kind.equals("Incoming")){ %>
		<label> <span id="senderLabel"><%=LanguageParsing.getValue("messaging.sender") %>:
		</span> <input style="color:black" id="sender" type="text" name="reciever"
			value="<%=UserUtil.getUserById(message.getSenderId()).getUsername()  %>" readonly="readonly" />
		</label>
		<%}else{ %>
			<label> <span><%=LanguageParsing.getValue("messaging.reciever") %>:
			</span> <input style="color:black" id="reciever" type="text" name="reciever"
			value="<%=UserUtil.getUserById(message.getSenderId()).getUsername()  %>" readonly="readonly" />
		</label>
		<%} %>
		 <label> <span><%=LanguageParsing.getValue("messaging.theme") %>
				:</span> <input style="color:black;" id="theme" type="text" name="theme"
				value="<%=message.getTheme() %>" readonly="readonly" />
		</label>
		
		<label>
		<span style="visibility:hidden"><%=LanguageParsing.getValue("messaging.theme") %>
				:</span> 
		   <textarea readonly="readonly" name="text" id="msgBody">
		   <%=message.getText() %>
		  </textarea>
		 </label>  
		   
			
		
		
		 
		
		<label> <span>&nbsp;</span>
		<%
			if(kind.equals("Incoming")){
		%>
		 <input type="submit"
		 	id="replyBtn"
			class="button"
			value="<%=LanguageParsing.getValue("messaging.actions.reply") %>"
			onclick="reply(); return false;"
			></input>
			<br></br>
		<%}else if(kind.equals("Outgoing")) {%>
		 <input type="submit"
		 	id="forwardBtn"
			class="button"
			value="<%=LanguageParsing.getValue("messaging.actions.promotion") %>"
			onclick="forward(); return false;"
			></input>
			<br></br>
			<%} %>
			<img id="loader" style="visibility:hidden" src="../images/ajax-loader.gif" alt="loading_gif" width="230 px" height="10px"/> 
		</label>



	</form>
	<br></br>
</div>
<!-- /main -->

<%} %>

<jsp:include page="../footer.jsp" />