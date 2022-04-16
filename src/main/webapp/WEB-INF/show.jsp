<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Travel</title>
</head>
<body>
	<div class="container my-2">
			<div class="d-flex justify-content-between align-items-center">
				<h1>Expense Details</h1>
				<a href="/travels">Go back</a>
			</div>
			<p>${travel.expense}</p>
			<p>Number of Pages: ${travel.vendor}</p>
			<p>Language: ${travel.amount}</p>
			<p>Description: ${travel.description}</p>
	</div>
<body>
</html>