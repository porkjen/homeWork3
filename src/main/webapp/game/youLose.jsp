<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center;">LOSE</h1>

<br/><h2 style="text-align:center;">沒有次數了...</h2>
<%String hint = (String)request.getAttribute("hint"); %>
<p style="color:red; font-size:0.8em; text-align:center"><%= hint%></p>
<p style="text-align:center;"><a href="../">再來一局</a></p>
</body>
</html>