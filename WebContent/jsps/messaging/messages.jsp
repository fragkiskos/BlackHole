<%@page import="utils.modelUtils.UserUtil"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<jsp:include page="messagesHeader.jsp"/>
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
			<div id=mailMain>
			<span><a class="mailMessages" href="#"><%=LanguageParsing.getValue("messaging.create") %></a></span>&nbsp;
			<span><a class="mailMessages" href="#"><%=LanguageParsing.getValue("messaging.delete") %></a></span>&nbsp;
			<span><a class="mailMessages" href="#"><%=LanguageParsing.getValue("messaging.signedAsRead") %></a></span>
			
			<table class="table">
						<thead>
						
							<tr>
								<td><%=LanguageParsing.getValue("messaging.sender") %></td>
								<td><%=LanguageParsing.getValue("messaging.reciever") %></td>
								<td><%=LanguageParsing.getValue("messaging.theme") %></td>
								<td><%=LanguageParsing.getValue("messaging.date") %></td>
							</tr>
						</thead>
						<tbody>
						
						<%List<model.Message> messages =(List<model.Message>) session.getAttribute("messages");
							
							
							if(messages!=null){
								for(int i=0;i<messages.size();i++){
									model.Message message = messages.get(i);
									boolean isreaded = message.getReaded();
									if(isreaded){
						%>
								
									<tr style="background: silver;">
									
										<td><input type="checkbox" />&nbsp;<a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getSenderId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getReceiverId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=message.getTheme() %></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=message.getDate() %></a></td>
									</tr>
								
								<%}else{ %>
									
										<tr>
										
										<td><input type="checkbox"  />&nbsp;<a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getSenderId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getReceiverId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=message.getTheme() %></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=message.getDate() %></a></td>
										
									</tr>
								
								<%} %>
							<%} %>	
						<%} %>
						
						</tbody>
					</table>
			</div>
			<!-- /main -->
			
			
<%} %>		
			
<jsp:include page="../footer.jsp"/>