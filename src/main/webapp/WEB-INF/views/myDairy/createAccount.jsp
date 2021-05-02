<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container ">
		<div class="row">
			<div class="col-sm-4 mx-auto pt-5">
				<div class="text-center text-warning">
					<p>${msg}</p>
				</div>
				<div class="card">
					<div class="container pt-4">
						<h4 class="text-center pt-3">Create Accout</h4>
						<form method="post" action="createAccount" commandName="user">

							<div class="form-group">
								<label for="userName">UserName:</label> <input type="username"
									class="form-control" id="userName" placeholder="Enter username"
									name="userName" required>
							</div>
							<div class="form-group">
								<label for="email">Email:</label> <input type="email"
									class="form-control" id="email" placeholder="Enter email"
									name="email" required>
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input type="password"
									class="form-control" id="pwd" placeholder="Enter password"
									name="pswd" required>
							</div>
							

							<div style="width: 400px;">
								<div style="float: left; width: 130px">
									<button type="submit" name="submit" class="btn btn-primary">Submit</button>
								</div>


								<div style="float: right; width: 225px">
									<a href="${pageContext.request.contextPath}/">
										<button type="button" name="submit" class="btn btn-primary">Login</button>
									</a>
								</div>
							</div>
							
							
							
					</div>
					</form>
				</div>
				<div class="card-body"></div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>