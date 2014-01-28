<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<jsp:include page="header.jsp"/>
			
			<!-- main -->
			<div id="main">
				<h2 class="inner">Contact Us</h2>
				<form method="post" action="contact.html">
					<p>
						<label for="name">Name:</label>
						<input type="text" class="text" name="name" id="name" />
					</p>
					<p>
						<label for="email">E-mail Address:</label>
						<input type="text" class="text" name="email" id="email" />
					</p>
					<p>
						<label for="phone">Phone:</label>
						<input type="text" class="text" name="phone" id="phone" />
					</p>
					<p>
						<label for="text">Message:</label>
						<textarea class="text" name="text" id="text"></textarea>
					</p>
					<p>
						<input type="submit" class="submit" value="Send" />
					</p>
				</form>
			</div>
			<!-- /main -->
			
			<!-- side -->
			<jsp:include page="news.jsp"/>
			<!-- /side -->
		</div>
			
		<!-- footer -->
		<div id="footer">
			<div id="footerbg">
				<div class="wrap">
				
					<!-- footer links -->
					<p id="footer_menu">
						<a href="#">Jobs @ corporattica</a>
						<a href="#">Press Releases</a>
						<a href="#">Terms and Conditions</a>
						
						<!-- credit link -->
						<a href="http://www.solucija.com" title="Free CSS Templates">Solucija</a>
					</p>
					<!-- /footer links -->
					
					<p id="copy">corporattica <span>professional approach</span></p>
					
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!-- /footer -->
		
	</div>
</body>
</html>