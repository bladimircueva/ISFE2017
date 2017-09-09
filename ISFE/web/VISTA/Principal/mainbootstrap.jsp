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
        <link href="../../css/bootstrap-select.css" rel="stylesheet">
        <script src="../../js/jquery.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <link href="../../css/bootstrap-select.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../../css/bootstrap-select.css">
        <script src="../../js/bootstrap-select.js"></script>
        <script src="../../js/bootstrap-select.min.js"></script>
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

            .modal-body .form-horizontal .col-sm-2,
            .modal-body .form-horizontal .col-sm-10 {
                width: 100%
            }

            .modal-body .form-horizontal .control-label {
                text-align: left;
            }
            .modal-body .form-horizontal .col-sm-offset-2 {
                margin-left: 15px;
            }
        </style>      
    </head>
    <body>
        <div style='background: #e3e3e3;' align='left' ><text style="color: black; font-family: serif">ISFE - Bienvenido Sr.<%=session.getAttribute("session_usu_nombreusuario")%></text>
            <div style="float: right;" >
                <a id="CallRegistroDialog" data-toggle="modal" data-target="#myModalNorm" runat="server" href = "#" style="text-decoration: none;font-size: 11.9px; font-weight: bold; text-rendering: optimizelegibility;" >
                    <font color="black">Registrar Usuario | </font>
                </a>
                <a class="glyphicon glyphicon-user" href = "../../ser_IniciarSesion?parAccion=cerrar_sesion" style="text-decoration: none;font-size: 11.9px; font-weight: bold; text-rendering: optimizelegibility;" >
                    <font color="black">Cerrar Sesión</font>
                </a> 
            </div>
        </div>

        <div class="modal fade" id="myModalNorm" tabindex="-1" role="dialog" 
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <button type="button" class="close" 
                                data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            Registro de Usuario
                        </h4>
                    </div>

                    <!-- Modal Body -->
                    <div class="modal-body" class="col-sm-10">

                        <form role="form">
                            <div class="row">
                                <div  class="col-md-6">
                                    <label for="nombres">Nombres</label>
                                    <input type="text" class="form-control"
                                           id="nombres" placeholder="Nombres"/>
                                </div>
                                <div  class="col-md-6">
                                    <label for="apellidos">Apellidos</label>
                                    <input type="text" class="form-control"
                                           id="apellidos" placeholder="Apellidos"/>
                                </div>
                                <div  class="col-md-6">
                                    <label for="email">E-mail</label>
                                    <input type="email" class="form-control"
                                           id="email" placeholder="tucorreo@gmail.com"/>
                                </div>
                                <div  class="col-md-6">
                                    <label for="direccion">Direccion</label>
                                    <input type="text" class="form-control"
                                           id="direccion" placeholder="Direccion"/>
                                </div>
                                <div  class="col-md-6">
                                    <label for="telefono">Telefono</label>
                                    <input type="text" class="form-control"
                                           id="telefono" placeholder="Telefono"/>
                                </div>
                                <div  class="col-md-6">
                                    <label for="dni">DNI</label>
                                    <input type="text" class="form-control"
                                           id="dni" placeholder="Dni"/>
                                </div>
                                <div  class="col-md-6">
                                    <label for="nombreusuario">Nombre de cuenta</label>
                                    <input type="text" class="form-control"
                                           id="nombreusuario" placeholder="nombre de usuario"/>
                                </div>
                                <div  class="col-md-6">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control"
                                           id="password" placeholder="Password"/>
                                </div>
                                <div  class="col-md-10">
                                    <label for="menu">Rol</label><br>
                                    <select id="listarol"  data-style="btn-primary">
                                        <OPTION VALUE="" selected>--Seleccione--</OPTION>
                                    </select>

                                </div>
                            </div>
                        </form>


                    </div>

                    <!-- Modal Footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">
                            Close
                        </button>
                        <button type="button" onclick="GuardarUsuario()" class="btn btn-primary">
                            Registrar
                        </button>
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
                        <li><a href="mainbootstrap.jsp"><span class="glyphicon glyphicon-home"></span>Inicio</a></li>
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

       
        
        
            
            
            
            <iframe  id="container"   width="100%" height="100%"   frameBorder="0" name="container" style="background-image: url(../../css/images/logoisfe.png);background-repeat: no-repeat;background-size: 100%">
                 <img src="../../css/images/logoisfe.png"/>
            </iframe>   
        
        
        




    </body>

    <script language="Javascript">
        
        function GuardarUsuario()
        {
            var varUsuNombre = $('#nombres').val();
            var varUsuApellidos = $('#apellidos').val();
            var varUsuEmail = $('#email').val();
            var varUsuDireccion = $('#direccion').val();
            var varUsuTelefono = $('#telefono').val();
            var varUsuDni = $('#dni').val();
            var varUsuNombreusuario = $('#nombreusuario').val();
            var varUsuPassword = $('#password').val();
            var varUsuRol = $('#listarol').val();
            
            $.post('../../srvUsuarios',{
                parAccion: 'create',
                nombres: varUsuNombre,
                apellidos: varUsuApellidos,
                email: varUsuEmail,
                direccion: varUsuDireccion,
                telefono: varUsuTelefono,
                dni: varUsuDni,
                nombreusuario: varUsuNombreusuario,
                password: varUsuPassword,
                rol_id: varUsuRol
            },function(rsp){alert(rsp);});
        }
        
        $(document).ready(function ()
        {
            $('#listarol').html('');
            $.post('/ISFE/srvRoles', {
                parAccion: 'getListRol'}, 
            function (rsp)
            {
                var JSONObject = JSON.parse(rsp);
                $.each(JSONObject, function (index, item) {
                    
                console.log(rsp);
                    $('#listarol').append("<option value=" + item.id + ">" + item.descripcion + "</option>");
                });
            });
        });


    </script>

</html>
