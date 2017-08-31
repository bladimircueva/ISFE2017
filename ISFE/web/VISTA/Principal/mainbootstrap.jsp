<%-- 
    Document   : mainbootstrap
    Created on : 30-ago-2017, 10:21:08
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title> Menu ISFE</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#acolapsar">
		<span class="sr-only">toggle navigation</span>
		<span class="icon-bar">toggle navigation</span>
		</button>
		<a href="#" class="navbar-brand"> Mi Proyecto</a>
	</div>
	<div class="collapse navbar-collapse" id="acolapsar">
		<ul class="nav navbar-nav">
			<li><a href="#"><span class="glyphicon glyphicon-home"></span>Inicio</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-cog"></span>Setting</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Desplegar<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">prueba1</a></li>
					<li><a href="#">prueba 2</a></li>
					<li><a href="#">prueba 3</a></li>
		</ul>
	</div>
</div>
</nav>
<script src="../../js/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>
