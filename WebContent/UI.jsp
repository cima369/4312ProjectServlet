<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "f"%>

<!DOCTYPE html>
<html lang="en">
<title>VideoCo</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
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

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
	<c:choose>
		<c:when test="${sessionScope.adminloggedin == '1'}">
			<form class='loginForm' action='VideoCo' method='GET'>
				<button name='logout' value='true'>Sign Out</button> 
			</form>	
			<a href="Adminpage.jsp">Admin Page</a>
		</c:when>
		<c:when test="${sessionScope.loggedin == '1'}">
			<form class='loginForm' action='VideoCo' method='GET'>
				<button name='logout' value='true'>Sign Out</button> 
			</form>
		</c:when>
		<c:otherwise>
			<a href="SignIn.jsp">Sign In</a> 
		</c:otherwise>
	</c:choose>
  <div class="w3-container">
    <h3 class="w3-padding-64"><b>VideoCo</b></h3>
  </div>
  <div class="w3-bar-block">
    <a href="#" onclick="close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
    <a href="#Music" onclick="close()" class="w3-bar-item w3-button w3-hover-white">Music</a> 
    <a href="#Movies" onclick="close()" class="w3-bar-item w3-button w3-hover-white">Movies</a> 
    <a href="#Comedy" onclick="close()" class="w3-bar-item w3-button w3-hover-white">Comedy</a> 
  </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="open()"></a>
  <span>VideoCo</span>
</header>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

  <!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="Music">
    <h1 class="w3-xxxlarge w3-text-red"><b>Music</b></h1>
	<div class="grid-container">
	  <div class="item1">1 ${music1} $45</div>
		<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmusic1' value='true'>Add To Cart</button>
		</form>
	  <div class="item2">${music2}</div>
		<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmusic2' value='true'>Add To Cart</button>
		</form>
	  <div class="item3">${music3}</div> 
	  	<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmusic3' value='true'>Add To Cart</button>
		</form> 
	  <div class="item4">${music4}</div>
	  	<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmusic4' value='true'>Add To Cart</button>
		</form>
	  <div class="item5">${music5}</div>
	</div>
  </div>

  <!-- Services -->
  <div class="w3-container" id="Movies" style="margin-top:75px">
    <h1 class="w3-xxxlarge w3-text-red"><b>Movies</b></h1>
	<div class="grid-container">
	  <div class="item1">${movie1}</div>
	  	<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmovie1' value='true'>Add To Cart</button>
		</form>
	  <div class="item1">${movie2}</div>
	    <form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmovie2' value='true'>Add To Cart</button>
		</form>
	  <div class="item1">${movie3}</div>
	    <form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmovie3' value='true'>Add To Cart</button>
		</form>  
	  <div class="item1">${movie4}</div>
	    <form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartmovie4' value='true'>Add To Cart</button>
		</form>
	  <div class="item1">${movie5}</div>
	</div>
  </div>
  
  <!-- Designers -->
  <div class="w3-container" id="Comedy" style="margin-top:75px">
    <h1 class="w3-xxxlarge w3-text-red"><b>Comedy</b></h1>
	<div class="grid-container">
	  <div class="item1">${comedy1}</div>
	  	<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartcomedy1' value='true'>Add To Cart</button>
		</form>
	  <div class="item1">${comedy2}</div>
	  	<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartcomedy2' value='true'>Add To Cart</button>
		</form>
	  <div class="item1">${comedy3}</div>
	  	<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartcomedy3' value='true'>Add To Cart</button>
		</form> 
	  <div class="item1">${comedy4}</div>
	  	<form class='loginForm' action='VideoCo' method='GET'>
			<button name='cartcomedy4' value='true'>Add To Cart</button>
		</form>
	  <div class="item1">${comedy5}</div> 
	</div>
  </div>
  
  
<!-- End page content -->
</div>

<script>
// Script to open and close sidebar
function open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

</script>

</body>
</html>
