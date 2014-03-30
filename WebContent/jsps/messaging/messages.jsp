<%@page import="utils.modelUtils.UserUtil"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<%@ page import="utils.DateUtils" %>
<jsp:include page="messagesHeader.jsp"/>
<%@ page import="model.User" %>
<%@ page import="model.Message" %>
<%
User user = (User)request.getSession().getAttribute("user");
if(user!=null){
	
%>
<script type="text/javascript" src="../../js/popup.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	var kind = '<%= session.getAttribute("kind") %>';
	document.getElementById(kind).parentNode.setAttribute("style", "background-color:silver");
	$("input#all").change(function() {
		 if(this.checked) {
		    	$('input:checkbox').attr('checked','checked');
		    }else{
		    	$('input:checkbox').removeAttr('checked');
		    }
	});
	$('input:checkbox').change(function() {
		if(this.checked) {
	    	
	    }else{
	    	$("input#all").removeAttr('checked');
	    }
	});
	
	$("a#delete").click(function(){
		document.getElementById("action").setAttribute("value", "delete");
		var counter = isOneCheckBoxChecked();
		if(counter==0){
			popup('<%=LanguageParsing.getValue("popup.chooseOne")%>');
		}else{
			popupConfirm('<%=LanguageParsing.getValue("popup.areYouSure.delete")%>');
			$('#ok').click(function () {
				$("form#messageAction").submit();
			});	
			
		}
	});
	$("a#signedAsRead").click(function(){
		document.getElementById("action").setAttribute("value", "signedAsRead");
		var counter = isOneCheckBoxChecked();
		if(counter==0){
			popup('<%=LanguageParsing.getValue("popup.chooseOne")%>');
		}else{
			
			$("form#messageAction").submit();
		}
	});
	
	function isOneCheckBoxChecked(){
		
		return  $( "input:checked" ).length;
	}
	
});
</script>
<jsp:include page="../popUps/popup.jsp" />
<jsp:include page="../popUps/confirm.jsp" />
			<!-- side -->
			<div id=mailSide>
			<ul class="side-menu">
					<li ><a id="Incoming" href="../../getIncoming?userId=<%=user.getId() %>"><%=LanguageParsing.getValue("messaging.incoming") %></a></li>
					<li ><a id="Outgoing" href="../../getOutgoing?userId=<%=user.getId() %>"><%=LanguageParsing.getValue("messaging.outgoing") %></a></li>
					
				</ul>
			</div>
			<!-- /side -->
			<form id="messageAction" method="post" action="/itstock/messageHandler">
			<input id="action" name="action" style="display:none;" type="text" value="signedAsRead"/>
			<!-- main -->
			<div id=mailMain>
			<span><a class="mailMessages" href="../messaging/sendMessage.jsp"><%=LanguageParsing.getValue("messaging.create") %></a></span>&nbsp;
			<span><a id="delete" class="mailMessages" href="#"><%=LanguageParsing.getValue("messaging.delete") %></a></span>&nbsp;
			<span><a id="signedAsRead" class="mailMessages" href="#"><%=LanguageParsing.getValue("messaging.signedAsRead") %></a></span>
			
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
							
						int allMessages = (Integer) session.getAttribute("allMessages");
						int start = (Integer) session.getAttribute("start");
						int end = (Integer) session.getAttribute("end");
						boolean hasNext = (Boolean)session.getAttribute("hasNext");
						boolean hasPrevious = (Boolean)session.getAttribute("hasPrevious");
							if(messages!=null && messages.size()>0 ){%>
							
								<tr ><td style="width:150px;font-size:12px"><input type="checkbox" id="all" name="all" value="all" style="position:relative;top: 3px;left:95px" /><%=LanguageParsing.getValue("selectAll") %></td>
								<td style="width:100px;"></td>
								<td></td>
								<td style="font-size:12px"><%=start+1 %>-<%=end %>&nbsp;&nbsp;
								<% if(hasPrevious) {
									int previous =(Integer) session.getAttribute("previous");
								%>
									<a href="../../get<%= session.getAttribute("kind") %>?userId=<%=user.getId() %>&start=<%=previous%>&end=<%=previous+10%>">
										<span class="next-previous">&lt;</span>
									</a>
								<%} %>
									<% if(hasNext) {
									int next =(Integer) session.getAttribute("next");
								%>
								&nbsp;
									<a href="../../get<%= session.getAttribute("kind") %>?userId=<%=user.getId() %>&start=<%=start+10%>&end=<%=next%>">
										<span class="next-previous">&gt;</span>
									</a>
								<%} %>
									</td>
								<tr>
								<% for(int i=0;i<messages.size();i++){
									model.Message message = messages.get(i);
									boolean isreaded = message.getReaded();
									if(isreaded){
								%>
								
									<tr style="background: silver;">
									
										<td><input type="checkbox" name=<%=i %>   value="<%=message.getId() %>" style="position:relative;top: 3px;left:1px" />&nbsp;<a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getSenderId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getReceiverId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=message.getTheme() %></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=DateUtils.getEuropeDate(message.getDate()) %></a></td>
									</tr>
								
								<%}else{ %>
									
										<tr>
										
										<td><input type="checkbox" name=<%=i %>   value="<%=message.getId() %>"  name="<%=message.getId() %>" value="true" style="position:relative;top: 3px;left:1px"/>&nbsp;<a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getSenderId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=UserUtil.getUserById(message.getReceiverId()).getUsername()%></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=message.getTheme() %></a></td>
										<td><a href="../../readMessage?messageId=<%=message.getId() %>"><%=DateUtils.getEuropeDate(message.getDate()) %></a></td>
										
									</tr>
								
								<%} %>
							<%} %>	
						<%} %>
						
						</tbody>
					</table>
			</div>
			<!-- /main -->
			</form>
			
<%} %>		
			
<jsp:include page="../footer.jsp"/>