<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" rel="stylesheet">
	
<title>Product List</title>

</head>
<body class="container-fluid bg bg-info">

		<div class="boxed">
			<h3>${product.name}</h3>
			<table>
				<tr>
					<td>Product Name:</td>
					<td>${product.name}</td>
				</tr>
				<tr>
					<td>Product Id:</td>
					<td>${product.productId}</td>
				</tr>
				<tr>
					<td>Unit Price:</td>
					<td>${product.unitPrice} USD</td>
				</tr>
				<tr>
					<td>Description:</td>
					<td>${product.description} </td>
				</tr>
				<tr>
					<td>Manufacturer:</td>
					<td>${product.manufacturer} </td>
				</tr>
				<tr>
					<td>Category:</td>
					<td>${product.category} </td>
				</tr>
				<tr>
					<td>Condition:</td>
					<td>${product.condition} </td>
				</tr>
				<tr>
					<td>Stock Available:</td>
					<td>${product.unitsInStock} </td>
				</tr>
				
			</table>
			<a href="<c:url value="/product/edit/${product.productId}" />">Edit Product</a>
			<a href="<c:url value="/product/delete/${product.productId}" />">Delete Product</a>
			
		</div>
	
</body>
</html>