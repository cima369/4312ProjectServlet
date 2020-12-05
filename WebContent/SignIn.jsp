<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignIn</title>
</head>

<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}

.grid-container > div {
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  padding: 20px 0;
  font-size: 30px;
}
</style>

<body>
<nav>
	<a href="UI.jsp">Home</a> 
</nav> <br/>

<fieldset>
	<legend>Sign In</legend>
		<form class='loginForm' action='VideoCo' method='GET'>
			<label for='username'>Username / Email<BR /></label>
			<input type='text' id='username' name='username'></input> <br/>
			<label for='password'>Password<BR /></label>
			<input type='text' id='password' name='password'></input> <br/>
			<button name='login' value='true'>Sign In</button>
		</form>
</fieldset>
<br/>

<fieldset>
	<legend>Register</legend>
		<form class='loginForm' action='VideoCo' method='GET'>
			<label for='usernameregister'>Username / Email<BR /></label>
			<input type='text' id='usernameregister' name='usernameregister'></input> <br/>
			<label for='passwordregister'>Password<BR /></label>
			<input type='text' id='passwordregister' name='passwordregister'></input> <br/>
			<button name='register' value='true'>Register</button>
		</form>
</fieldset>
<br/>


</body>
</html>