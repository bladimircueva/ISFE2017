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

    <style type="text/css">

            html { background:#333333; }
            body {
                margin:auto;
                width:100%;
                height:600px;
                background:#fff;
                overflow:hidden;
                background: #707070;
            }
            
            div#menu {
                margin-left:auto;
                position:relative;
                top: auto;
                width: 100%;
            }
            
         div#copyright { display: none; }
        </style>


</head>
<body>
    <div style='background: #e3e3e3;' align='left' ><text style="color: black; font-family: serif">ISFE - Bienvenido Sr.<%=session.getAttribute("session_usu_nombreusuario")%></text>
            <div style="float: right;" >
                        <a href = "../../srvUsuarios?parAccion=create" style="text-decoration: none;font-size: 11.9px; font-weight: bold; text-rendering: optimizelegibility;" >
                            <font color="black">Registrar Usuario | </font>
                        </a>
                <a class="glyphicon glyphicon-user" href = "../../ser_IniciarSesion?parAccion=cerrar_sesion" style="text-decoration: none;font-size: 11.9px; font-weight: bold; text-rendering: optimizelegibility;" >
                            <font color="black">Cerrar Sesión</font>
                        </a> 
            </div>
        </div>
<nav class="navbar navbar-default" role="navigation">
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#acolapsar">
		<span class="sr-only"></span>
		<span class="icon-bar"></span>
		</button>
            <a href="#"><img style="width: 100px;height: 50px" src="../../css/images/logoisfe.png"></a>
	</div>
	<div class="collapse navbar-collapse" id="acolapsar">
		<ul class="nav navbar-nav">
			<li><a href="#"><span class="glyphicon glyphicon-home"></span>Inicio</a></li>
                        <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Operaciones<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Obras</span></a></li>
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Requerimientos</span></a></li>
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Recepcion</span></a></li>
                        
                                </ul>
                        </li>
                         <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Logistica<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Obras</span></a></li>
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Requerimientos</span></a></li>
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Recepcion</span></a></li>
                        
                                </ul>
                        </li>
                        <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Obras</span></a></li>
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Requerimientos</span></a></li>
					<li><a href="../OPERACIONES/index.jsp" target="container"><span>Recepcion</span></a></li>
                        
                                </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="glyphicon glyphicon-cog" data-toggle="dropdown">Mantenimiento<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="../MAESTROS/ROL/index.jsp" target="container"><span>Roles</span></a></li>
					<li><a href="../MAESTROS/CategoriaMaterial/index.jsp" target="container"><span>Categoria de Materiales</span></a></li>
					<li><a href="../MAESTROS/UnidadMedida/index.jsp" target="container"><span>Unidad de Medida</span></a></li>
                                        <li><a href="../MAESTROS/Proveedor/index.jsp" target="container"><span>Proveedor</span></a></li>
                                        <li><a href="../MAESTROS/Material/index.jsp" target="container"><span>Material</span></a></li>
                                        <li><a href="../MAESTROS/Marca/index.jsp" target="container"><span>Marca</span></a></li>
                                        <li><a href="../MAESTROS/Maquinaria/index.jsp" target="container"><span>Maquinaria</span></a></li>
                                        <li><a href="../MAESTROS/Profesion/index.jsp" target="container"><span>Profesion</span></a></li>
                                        <li><a href="../MAESTROS/Usuario/index.jsp" target="container"><span>Usuarios</span></a></li>
                                </ul>
                        </li>
		</ul>
	</div>
</div>
</nav>
<script src="../../js/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<iframe  id="container"  width="100%" height="100%"   frameBorder="0" name="container"></iframe>    
<div style="align-content:center">  <a href="#"><img src="../../css/images/logoisfe.png"></a></div>
</body>
</html>
