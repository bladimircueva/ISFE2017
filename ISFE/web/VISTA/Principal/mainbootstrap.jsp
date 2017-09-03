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
<script src="../../js/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<!--<link href="~/Styles/Site.css" rel="stylesheet" type="text/css" />-->
<!--Include JQuery Style File-->
<link href="../../css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<link href="../../css/jquery-ui.css" rel="stylesheet" type="text/css" />
<!--Include JQuery File-->
<script type="text/javascript" language="Javascript" src="../../js/jquery.min.js"></script>
<!--Include JQuery UI File-->
<script type="text/javascript" language="Javascript" src="../../js/jquery-ui.min.js"></script>
<script type="text/javascript" language="Javascript" src="../../js/jquery-ui.js"></script>
 
    <style type="text/css">
            body {
  padding-top: 20px;
  padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header,
.marketing,
.footer {
  padding-right: 15px;
  padding-left: 15px;
}

/* Custom page header */
.header {
  border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
  padding-bottom: 19px;
  margin-top: 0;
  margin-bottom: 0;
  line-height: 40px;
}

/* Custom page footer */
.footer {
  padding-top: 19px;
  color: #777;
  border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media (min-width: 768px) {
  .container {
    max-width: 730px;
  }
}
.container-narrow > hr {
  margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}

/* Supporting marketing content */
.marketing {
  margin: 40px 0;
}
.marketing p + h4 {
  margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
  /* Remove the padding we set earlier */
  .header,
  .marketing,
  .footer {
    padding-right: 0;
    padding-left: 0;
  }
  /* Space out the masthead */
  .header {
    margin-bottom: 30px;
  }
  /* Remove the bottom border on the jumbotron for visual effect */
  .jumbotron {
    border-bottom: 0;
  }
}
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
                <a id="CallRegistroDialog" runat="server" href = "#" style="text-decoration: none;font-size: 11.9px; font-weight: bold; text-rendering: optimizelegibility;" >
                            <font color="black">Registrar Usuario | </font>
                        </a>
                <a class="glyphicon glyphicon-user" href = "../../ser_IniciarSesion?parAccion=cerrar_sesion" style="text-decoration: none;font-size: 11.9px; font-weight: bold; text-rendering: optimizelegibility;" >
                            <font color="black">Cerrar Sesión</font>
                        </a> 
            </div>
    </div>
            
    <div id="dialogregistrousuario" title="Dialogo de registro de usuario">
            <div class="container">
                <h1 class="well">REGISTRAR USUARIOOOOOOOOOOO</h1>
                    <div class="col-lg-12 well">
                    <div class="row">
				<form>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Nombres</label>
								<input type="text" placeholder="Enter First Name Here.." class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Apellidos</label>
								<input type="text" placeholder="Enter Last Name Here.." class="form-control">
							</div>
						</div>					
						<div class="form-group">
							<label>Direccion</label>
							<textarea placeholder="Enter Address Here.." rows="3" class="form-control"></textarea>
						</div>	
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>E-mail</label>
								<input type="text" placeholder="Enter City Name Here.." class="form-control">
							</div>	
							<div class="col-sm-4 form-group">
								<label>State</label>
								<input type="text" placeholder="Enter State Name Here.." class="form-control">
							</div>	
							<div class="col-sm-4 form-group">
								<label>Zip</label>
								<input type="text" placeholder="Enter Zip Code Here.." class="form-control">
							</div>		
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Title</label>
								<input type="text" placeholder="Enter Designation Here.." class="form-control">
							</div>		
							<div class="col-sm-6 form-group">
								<label>Company</label>
								<input type="text" placeholder="Enter Company Name Here.." class="form-control">
							</div>	
						</div>						
					<div class="form-group">
						<label>Phone Number</label>
						<input type="text" placeholder="Enter Phone Number Here.." class="form-control">
					</div>		
					<div class="form-group">
						<label>Email Address</label>
						<input type="text" placeholder="Enter Email Address Here.." class="form-control">
					</div>	
					<div class="form-group">
						<label>Website</label>
						<input type="text" placeholder="Enter Website Name Here.." class="form-control">
					</div>
					<button type="button" class="btn btn-lg btn-info">Submit</button>					
					</div>
				</form> 
				</div>
	</div>
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

<iframe  id="container"  width="100%" height="100%"   frameBorder="0" name="container"></iframe>    
<div style="align-content:center">  <a href="#"><img src="../../css/images/logoisfe.png"></a></div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#dialogregistrousuario").dialog({ autoOpen: false });
 
        $("#CallRegistroDialog").click(
            function () {
                $("#dialogregistrousuario").dialog('open');
                return false;
            }
        );
    });
</script>

</body>
</html>
