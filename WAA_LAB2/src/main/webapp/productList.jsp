<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
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
		</div>
		
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>
	
</body>
</html>