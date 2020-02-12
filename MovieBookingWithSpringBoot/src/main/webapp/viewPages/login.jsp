<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
button {
	width: 90%;
}
</style>
</head>

<body>
	<div class="main">
		
		<h1>Movie Booking System</h1>
		<hr>

		<form method="post" action="login" >

			<input type="email" name="username" placeholder="Username or email" required> 
			<input type="password" name="password" placeholder="password" required> 
			<button type="submit">Login</button>
			
		</form>
		
		<form action="registration">
				<button type="submit">Register</button>
		</form>
	</div>
</body>
</html>
