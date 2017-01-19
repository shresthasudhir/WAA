<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Login Page</title>
</head>
<body>

	<div class="container">
		<h2>Login Form</h2>
		<form class="form-horizontal" name="loginForm" action="login"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2">Username:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="username"
						value="${userName }" placeholder="Enter username">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" name="password"
						placeholder="Enter password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<div class="checkbox">
						<label><input type="checkbox" name="remember" value="1 "
							${checked}> Remember Me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>

		<div class="loginfail container">
			<label class="control-label col-sm-2"> <%
 	if (request.getAttribute("msgLoginFailed") != null)
 		out.println(request.getAttribute("msgLoginFailed"));
 %>
			</label>
		</div>
	</div>

</body>
</html>