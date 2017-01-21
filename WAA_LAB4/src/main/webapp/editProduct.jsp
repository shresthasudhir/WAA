<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>Edit Product Page</title>
</head>
<body class="container-fluid bg bg-info">

	<div>
		<form:form modelAttribute="editProduct" method="post">
			<%-- <form:errors path="*" element="div" /> --%>

			<table>
				<tr>
					<td>Product ID:</td>
					<td><form:input path="productId" /></td>
				</tr>
				<tr>
					<td>Product Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Unit Price:</td>
					<td><form:input path="unitPrice" /></td>
				</tr>
				<tr>
					<td>Manufacturer:</td>
					<td><form:input path="manufacturer" /></td>
				</tr>
				<tr>
					<td>Category:</td>
					<td><form:input path="category" /></td>
				</tr>
				<tr>
					<td>Units In Stock:</td>
					<td><form:input path="unitsInStock" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:textarea path="description" /></td>
				</tr>
				<tr>
					<td>Condition:</td>
					<td><form:radiobutton path="condition" value="New" />New <form:radiobutton
							path="condition" value="Old" />Old <form:radiobutton
							path="condition" value="Refurbished" />Refurbished</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Edit Product" /></td>
				</tr>
			</table>

		</form:form>

	</div>

</body>
</html>