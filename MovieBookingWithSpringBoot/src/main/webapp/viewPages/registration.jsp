<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<script type="text/javascript">

function checkPassword(form)
{
	if(form.password.value != form.cpassword.value)
		{
		alert("Password and Confirm Password is not same. Please enter again");
		form.password.focus();
		return false;
		}
	else
		{
		 var pattern = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&]).{6,12}/;
		
		if(!pattern.test(form.password.value))
			{
			alert("Password must contain one uppercase, lowercase, number, special character and between 6 to 12 characters");
			form.password.focus();
			return false;
			}
		else
			return true;	
		}
	}

</script>

</head>

<body>
	<div class="main">
		
		<h1>Register Yourself</h1>
		<hr>

		<form method="post" action="addUser" onsubmit="return checkPassword(this);">

			<input type="email" name="username" placeholder="Email" required> 
			<input type="password" name="password" placeholder="Password" required> 
			<input type="password" name="cpassword" placeholder="Confirm Password" required>
			
			<button type="reset">Reset</button>
			<button type="submit">Register</button>

		</form>
	</div>
</body>
</html>
