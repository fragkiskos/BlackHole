<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.BreakingNew" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.NewsParser" %>
<%@ page import="utils.LanguageParsing" %>
<jsp:include page="header.jsp"/>
			
			<!-- main -->
			<div id="main">
				<div id="page">
					<h2 class="inner">Lorem Ipsum dolor sit amet</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel lorem eu libero laoreet facilisis. Aenean placerat, ligula quis placerat iaculis, mi magna luctus nibh, <a href="#">adipiscing pretium erat neque vitae augue</a>. Quisque consectetur odio ut sem semper commodo. Maecenas iaculis leo a ligula euismod condimentum. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. </p>
					
					<br />
					<h4>Table Example</h4>
					<br />
					<table class="table">
						<thead>
							<tr>
								<td>ID</td>
								<td>Row Title</td>
								<td>Row Description</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Lorem ipsum dolor sit amet</td>
								<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit</td>
							</tr>
							<tr class="odd">
								<td>2</td>
								<td>Lorem ipsum dolor sit amet</td>
								<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Lorem ipsum dolor sit amet</td>
								<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit</td>
							</tr>
							<tr class="odd">
								<td>4</td>
								<td>Lorem ipsum dolor sit amet</td>
								<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit</td>
							</tr>
							<tr>
								<td>5</td>
								<td>Lorem ipsum dolor sit amet</td>
								<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit</td>
							</tr>
						</tbody>
					</table>
					
					<br />
					<h4>List Example</h4>
					<br />
					<ul>
						<li>lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
						<li>lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
						<li>lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
						<li>lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
						<li>lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
					</ul>
					
					<br />
					<h4>Box Examples</h4>
					<br />
					
					<!-- half boxes -->
					<div class="half">
						<h4>Box</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel lorem eu libero.</p>
					</div>
					<div class="half last">
						<h4>Box</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel lorem eu libero.</p>
					</div>
					<!-- /half boxes -->
					
					<!-- third boxes -->
					<div class="third">
						<h4>Box</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel lorem eu libero.</p>
					</div>
					<div class="third">
						<h4>Box</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel lorem eu libero.</p>
					</div>
					<div class="third last">
						<h4>Box</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel lorem eu libero.</p>
					</div>
					<!-- /third boxes -->
					
					<div class="clear"></div>					
					
				</div>
			</div>
			<!-- /main -->
			
			<!-- side -->
			<div id="side">
				<h4>Menu Example</h4>
				
				<ul class="side-menu">
					<li><a href="#">side menu item</a></li>
					<li><a href="#">side menu item</a></li>
					<li><a href="#">side menu item</a></li>
					<li><a href="#">side menu item</a></li>
					<li><a href="#">side menu item</a></li>
				</ul>
				
			</div>
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