<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<nav>
	<a href="UI.jsp">Home</a> 
</nav> <br/>
<fieldset>
	<legend>Add Item</legend>
		<form class='loginForm' action='VideoCo' onsubmit="return alertSubmit();" method='GET'>
			<label for='username'>Video ID<BR /></label>
			<input type='text' id='videoid' name='videoid'></input> <br/>
			<label for='password'>Video Name<BR /></label>
			<input type='text' id='videoname' name='videoname'></input> <br/>
			<label for='username'>Category<BR /></label>
			<input type='text' id='category' name='category'></input> <br/>
			<label for='password'>Director<BR /></label>
			<input type='text' id='director' name='director'></input> <br/>
			<button name='additem' value='true'>Add Item</button>
		</form>
</fieldset>
<br/>
<fieldset>
	<legend>Shipping</legend>
		<form class='loginForm' action='VideoCo' method='GET'>
			<label for='username'>Order ID<BR /></label>
			<input type='text' id='orderid' name='orderid'></input> <br/>
			<button name='checkinformation' value='true'>Check Information</button>
			<div class="item1">${orderinformation}</div>
		</form>
</fieldset>
</body>

<script type="text/javascript">
function alertSubmit(){
alert("Item has been added.");
} 
</script>
</html>

