<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products Page</title>
<link href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body class="container-fluid bg bg-info">
	
		<c:forEach items="${customers}" var="customer">
			<div class="boxed">
				<%-- <h3><a href="/productList?productId=${product.productId}">${product.name}</a></h3> --%>
				<h3>
					<a href="<c:url value="/productList/${customer.username}" />">${customer.username}</a>
				</h3>
				<%-- <p>${product.productId}</p>
			<p>${product.unitPrice}USD</p> --%>
				<p>Address:  ${customer.address} </p>
			</div>
		</c:forEach>
	
</body>
</html>