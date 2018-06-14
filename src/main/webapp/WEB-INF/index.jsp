<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
	<p> Your Gold: <c:out value="${ countGold }"></c:out></p><br>
	
	<div class="property">
	<form action="/gold/farm" method="POST">
		<h3>Farm</h3>
		<p>earns (10-20 gold)</p>
		<input type = "hidden" name = "farm"></input>
		<button name="farm">Find Gold</button>
	</form>
	</div>
	
	<div class="property">
	<form action="/gold/cave" method="POST">
		<h3>Cave</h3>
		<p>earns (5-10 gold)</p>
		<input type = "hidden" name = "cave"></input>
		<button name="cave">Find Gold</button>
	</form>
	</div>
	
	<div class="property">
	<form action="/gold/house" method="POST">
		<h3>House</h3>
		<p>earns (2-5 gold)</p>
		<input type = "hidden" name = "house"></input>
		<button name="house">Find Gold</button>
	</form>
	</div>
	
	<div class="property">
	<form action="/gold/casino" method="POST">
		<h3>Casino</h3>
		<p>earns/takes (0-50 gold)</p>
		<input type = "hidden" name = "casino"></input>
		<button name="casino">Find Gold</button>
	</form>
	</div>
	
	<h2>Activities</h2>
	<div class="activities">
		<ul>
		   <% ArrayList<String> logList = (ArrayList<String>)session.getAttribute("logList"); %>
		   <% if (logList != null && logList.size() > 0) { %>
		       <% for (int i = logList.size() - 1; i >= 0; i--) { %>
		           <% if (logList.get(i).contains("lost")) { %>
		               <li class="lose"><%= i %> - <%= logList.get(i) %></li>
		           <% } else { %>                       
		               <li class="earn"><%= i %> - <%= logList.get(i) %></li>
		           <% } %>                       
		       <% } %>                        
		   <% } %>                        
		</ul> 
	</div>
</div>	
</body>
</html>