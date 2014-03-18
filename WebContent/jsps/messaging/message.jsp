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
%>
<div id=mailMain>
	<form action="/itstock/createAccount" method="post" class="basic-grey">
		<label> <span><%=LanguageParsing.getValue("messaging.sender") %>:
		</span> <input style="color:black" id="sender" type="text" name="sender"
			value="<%=UserUtil.getUserById(message.getSenderId()).getUsername()  %>" readonly="readonly" />
		</label>
		
		 <label> <span><%=LanguageParsing.getValue("messaging.theme") %>
				:</span> <input style="color:black;" id="theme" type="text" name="theme"
				value="<%=message.getTheme() %>" readonly="readonly" />
		</label>
		
		<label>
		<span style="visibility:hidden"><%=LanguageParsing.getValue("messaging.theme") %>
				:</span> 
		   <textarea readonly="readonly" name="message">
		   <%=message.getText() %>
		  </textarea>
		 </label>  
		   
			
		
		
		 
		
		<label> <span>&nbsp;</span> <input type="submit"
			class="button"
			value="<%=LanguageParsing.getValue("login.action.message") %>"></input>
			<br></br>


		</label>



	</form>
	<br></br>
</div>
<!-- /main -->

<%} %>

<jsp:include page="../footer.jsp" />