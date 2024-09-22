<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery Result</title>
</head>
<body>
<h2 style="text-align:center; color:red">樂透號碼產生結果</h2>
<table border="0" style="margin:auto; text-align:left">
<tbody>
<% ArrayList<Set<Integer>> results = (ArrayList<Set<Integer>>)request.getAttribute("results");%>
<% for(Set<Integer> s : results){ %>
<tr><td><%= s%></td></tr>
<% }%>
</tbody>
</table>
<br/>
<p style="text-align:center"><a href="../">回首頁</a></p>
</body>
</html>