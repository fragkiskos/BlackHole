<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<div id="side">
				<h4><%=LanguageParsing.getValue("latestNews") %></h4>
				
				
					<%List<BreakingNew> news = NewsParser.getBreakingNews();
					  for(int i=0;i<news.size();i++){
					BreakingNew item= news.get(i); 
					 %>
					 <div class="news">
					 <img src="<%=item.getImageUrl()%>" alt="<%=item.getImageUrl()%>" />
					 <br></br>
					<h5><a href="#"><%=item.getTitle()%></a></h5>
					<p><%=item.getSubTitle()%></p>
				</div>
					 <%}%>
					
				
				
				
				<div id="quote">
					<h4>Request a Free Quote</h4>
					<p>Phasellus diam sapien, fermentum a eleifend non, luctus non augue.</p>
				</div>

			</div>
			<!-- /side -->