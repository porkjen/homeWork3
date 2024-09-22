<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery</title>
</head>
<body>
<h1 style="text-align:center; color:red">Lottery</h1>
<%LinkedList<String> errors = (LinkedList<String>)request.getAttribute("errors"); %>
	<%if(errors != null){ %>
	<ul style="color:red;font-size:0.8em">
	<table style="margin:auto;text-align:left">
		<%for(String error:errors){ %>
			<tr><td><li><%=error %></li></td></tr>
		<%} %>
	</table>
		
	</ul>
<%} %>
<form action="lotteryController.do" method="post">
<table style="margin:auto">
<tbody>
<tr>
<td>組數</td><td><input type="text" id="group" name="group" value="${param.group}"></td>
</tr>
<tr></tr><tr></tr>
<tr>
<td>排除數字</td><td><input type="text" id="exclude" name="exclude" value="${param.exclude}"></td>
</tr>
<tr><td></td><td style="font-size:0.5em">以空格間隔!</td></tr>
<tr>
<td></td><td><input type="submit" value="確認"></td>
</tr>
</tbody>
</table>
</form>
</body>
</html>