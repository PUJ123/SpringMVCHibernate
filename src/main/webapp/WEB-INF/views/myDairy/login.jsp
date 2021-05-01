<!DOCTYPE html>
<html lang="en">
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
				<div class="card">
					<div class="container pt-4">
						<h4 class="text-center pt-3">Login</h4>
						<form method="post" action="login" commandName="user">
							<div class="form-group">
								<label for="email">Email:</label> <input type="email"
									class="form-control" id="email" placeholder="Enter email"
									name="email">
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input type="password"
									class="form-control" id="pwd" placeholder="Enter password"
									name="pswd">
							</div>
							<div class="form-group form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" name="remember">
									Remember me
								</label>
							</div>
							<div class="form-group form-check mx-auto">
								<button type="submit" name="submit" class="btn btn-primary">Submit</button>
							</div>

							<div class="form-group form-check text-center">
								<button type="button" class="btn">Create an Account</button>
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
