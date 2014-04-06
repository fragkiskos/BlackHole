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
<jsp:include page="../popUps/popup.jsp" />
<jsp:include page="../popUps/confirm.jsp" />
<%
User user = (User)request.getSession().getAttribute("user");
if(user!=null){
	
%>
<script type="text/javascript" src="../../js/popup.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	
});
function controlDelete(id){
	
	document.getElementById("deleteId").setAttribute("value", id);
	popupConfirm('<%=LanguageParsing.getValue("popup.areYouSure.delete")%>');
	$('#ok').click(function () {
		$("form#notActions").submit();
	});
	
}
</script>
<jsp:include page="../popUps/popup.jsp" />
<jsp:include page="../popUps/confirm.jsp" />
			<!-- side -->
			
			<div class="columnLeft">
			<h4>Killers of the month</h4>
			</div>
			<div  class="columnRight">
			<h4>companies of the month</h4>
			</div>
			
			<!-- /side -->
			<form id="notActions" method="get" action="/itstock/deleteNotification" >
			<input style="display:none" id="deleteId" type="text" name="notificationId" value=""/> 
			<div class="columnCenter"  class="columnRight" >
		
			<% 
			   List<model.Notification> notifications =(List<model.Notification>) session.getAttribute("notifications");
			   int allMessages = (Integer) session.getAttribute("notificationsCount");
			   int start = (Integer) session.getAttribute("start");
			   int end = (Integer) session.getAttribute("end");
			   boolean hasNext = (Boolean)session.getAttribute("hasNext");
			   boolean hasPrevious = (Boolean)session.getAttribute("hasPrevious");
			   if(notifications!=null && notifications.size()>0 ){%>
			<!-- main -->
			
			<div style="font-size:12px">
			<%if(hasNext){ %>
			<%=start+1 %>-<%=end %>&nbsp;&nbsp;
			<%} %>
								<% if(hasPrevious) {
									int previous =(Integer) session.getAttribute("previous");
								%>
									<a href="../../getNotifications?userId=<%=user.getId() %>&start=<%=previous%>&end=<%=previous+10%>">
										<span class="next-previous">&lt;</span>
									</a>
								<%} %>
									<% if(hasNext) {
									int next =(Integer) session.getAttribute("next");
								%>
								&nbsp;
									<a href="../../getNotifications?userId=<%=user.getId() %>&start=<%=start+10%>&end=<%=next%>">
										<span class="next-previous">&gt;</span>
									</a>
								<%} %>
								</div>
			<%for(int i=0;i<notifications.size();i++){ %>
			<div class="notification-container">
			<div class="notification">
			<p style="color:blue;"><%=DateUtils.getEuropeDate(notifications.get(i).getDate()) %></p>
			<p style="margin:20px"><%=notifications.get(i).getText() %> </p>
			<a     onclick="controlDelete('<%= notifications.get(i).getId()%>');"><img class="deleteIcon" src="../../images/delete.png" width="15px" title="delete"/></a>
			</div> 
			</div>
			<%} %>
			<%} %>
			 
			</div>
			
			</form>
			<!-- /main -->
			
			
			
<%} %>		
			
<jsp:include page="../footer.jsp"/>