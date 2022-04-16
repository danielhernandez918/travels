<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Travel</title>
</head>
<body>
	<div class="container my-2">
		<div class=" d-flex justify-content-between align-items-center">
			<h1>Edit Expense</h1>
			<a href="/travels">Go back</a>
		</div>
		<form:form action="/travels/${travel.id}" method="post" modelAttribute="travel">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="expense">Expense Name: </form:label>
				<form:errors path="expense" style="color: red"/>
				<form:input path="expense"/>
			</p>
			<p>
				<form:label path="vendor">Vendor: </form:label>
				<form:errors path="vendor" style="color: red"/>
				<form:input path="vendor"/>
			</p>
			<p>
				<form:label path="amount">Amount: </form:label>
				<form:errors path="amount" style="color: red"/>
				<form:input type="number" path="amount"/>
			</p>
			<p>
		        <form:label path="description">Description: </form:label>
		        <form:errors path="description" style="color: red"/>
		        <form:textarea path="description"/>
			</p>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
<body>
</html>