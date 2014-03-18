<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<jsp:include page="header.jsp"/>
			
			<!-- main -->
			<div id="main">
				<div id="intro">
					<h2><%=LanguageParsing.getValue("intro.Title") %></h2>
					<p><%=LanguageParsing.getValue("intro.WelcomeText") %></p>
				</div>
			
				<!-- bits -->
				<div id="bits">
					<div class="bit">
						<h4>Approach</h4>
						<div class="photo">
							<a href="#approach"><img src="images/thumb1.png" alt="Thumb" /></a>
						</div>
						<p>Aliquam erat volutpat. Donec a sem consequat tortor posuere dignissim sit amet at ipsum.</p>
						<p class="more"><a href="#">Read More</a></p>
						<div id="approach">
							<img src="images/portfolio.jpg" alt="Approach" />
						</div>
					</div>
					<div class="bit">
						<h4>Methods</h4>
						<div class="photo">
							<a href="#methods"><img src="images/thumb1.png" alt="Thumb" /></a>
						</div>
						<p>Aliquam erat volutpat. Donec a sem consequat tortor posuere dignissim sit amet at ipsum.</p>
						<p class="more"><a href="#">Read More</a></p>
						<div id="methods">
							<img src="images/portfolio.jpg" alt="Methods" />
						</div>
					</div>
					<div class="bit last">
						<h4>Results</h4>
						<div class="photo">
							<a href="#results"><img src="images/thumb1.png" alt="Thumb" /></a>
						</div>
						<p>Aliquam erat volutpat. Donec a sem consequat tortor posuere dignissim sit amet at ipsum.</p>
						<p class="more"><a href="#">Read More</a></p>
						<div id="results">
							<img src="images/portfolio.jpg" alt="Results" />
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- /bits -->
		
			</div>
			<!-- /main -->
			
			<!-- side -->
			<jsp:include page="news.jsp"/>
		
			
<jsp:include page="footer.jsp"/>	