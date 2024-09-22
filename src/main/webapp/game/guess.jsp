<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess Game</title>
</head>
<body>
<h1 style="text-align:center">猜1~10以內的數字</h1>
<form action="gameController.do" method="post" style="text-align:center;">
<input type="number" id="guess" name="guess" min="1" max="10">
<input type="submit" value="Guess">
</form>
<%String hint = (String)request.getAttribute("hint"); %>
<% if(hint!=null) {%>
<p style="color:red; font-size:0.8em; text-align:center"><%= hint%></p>
<% }%>
</body>
</html>