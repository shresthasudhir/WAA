<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" rel="stylesheet">
<title>Add Customer Page</title>
</head>
<body class="container-fluid bg bg-info">

	<div>

		Language : <a href="?language=en_US">English </a>| <a
			href="?language=ne_NP">Nepali</a>


		<form:form modelAttribute="newCustomer" method="post">
			<%-- <form:errors path="*" element="div" /> --%>
			<table>
				<tr>
					<td><spring:message code="label.username" text="default text" /></td>
					<td><form:input path="username" /><br /></td>
					<td><form:errors path="username" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.address" text="default text" /></td>
					<td><form:input path="address" /><br /></td>
					<td><form:errors path="address" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.dob" text="default text" /></td>
					<td><form:input path="dateOfBirth" /><br /></td>
					<td><form:errors path="dateOfBirth" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.password" text="default text" /></td>
					<td><form:password path="password" /><br /></td>
					<td><form:errors path="password" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.sex" text="default text" /></td>
					<td><form:radiobutton path="sex" value="Male" />Male <form:radiobutton
							path="sex" value="Female" />Female</td>
					<td><form:errors path="sex" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
					<td></td>
				</tr>

			</table>
		</form:form>

	</div>
</body>
</html>