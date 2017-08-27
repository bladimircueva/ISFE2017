<%-- 
    Document   : main
    Created on : 15-ago-2017, 13:12:52
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ISFE Contratistas</title>
        <link type="text/css" href="../../css/menu.css" rel="stylesheet" />
    
    <style type="text/css">
            * { margin:0;
                padding:0;
            }
            html { background:#333333; }
            body {
                margin:40px auto;
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
        <div style='margin-top: -40px;background: black;' align='left' ><text style="color: orange; font-family: serif">ISFE - Bienvenido Sr.<%=session.getAttribute("session_usu_nombreusuario")%></text>
            <div style="float: right;" >
                        <a href = "../../ser_IniciarSesion?parAccion=cerrar_sesion"  
                           style="text-decoration: none;font-size: 11.9px;
                           font-weight: bold;
                           text-rendering: optimizelegibility;" >
                            <font color="orange">Cerrar Sesión</font>
                        </a> 
                        <font color="#EAF88D">|</font>
            </div>
        </div>
            
        <div id="menu">
            <ul class="menu">
                <li class="last"><a href="#"><span>Home</span></a>
                    <div><ul>
                            <li><a href="Maestros/MantenimientoEntidades/index.jsp"  target="container"><span>Nosotros</span></a></li> 
                        </ul></div>  
                </li>
                
                <li><a href="Maestros/Tramites/index.jsp" class="parent" target="container"><span>Operaciones</span></a>
                    <div><ul>
                            <li><a href="../OPERACIONES/index.jsp" target="container"><span>Obras</span></a>
                            </li>
                            <li><a href="../OPERACIONES/index.jsp" target="container"><span>Requerimientos</span></a>
                            </li>
                            <li><a href="../OPERACIONES/index.jsp" target="container"><span>Recepcion</span></a>
                            </li>
                        </ul>
                        
                        
                    </div>
                </li>
                <li><a href="Maestros/Reportes/ReporteTodosindex.jsp" target="container" class="parent"><span>Logistica</span></a>
                </li>
                <li><a href="Maestros/Reportes/ReporteSBStxt.jsp" target="container" class="parent"><span>Reportes</span></a>
                   
                </li>
                <li><a class="parent"><span>Mantenimiento</span></a>
                    <div><ul>
                            <li><a href="../MAESTROS/ROL/index.jsp" target="container"><span>Roles</span></a>
                            </li>
                            <li><a href="../MAESTROS/CategoriaMaterial/index.jsp" target="container"><span>Categoria de Materiales</span></a>
                            </li>
                            <li><a href="../MAESTROS/UnidadMedida/index.jsp" target="container"><span>Unidad de Medida</span></a>
                            </li>
                            <li><a href="../MAESTROS/Proveedor/index.jsp" target="container"><span>Proveedor</span></a>
                            </li>
                            <li><a href="../MAESTROS/Material/index.jsp" target="container"><span>Material</span></a>
                            </li>
                            <li><a href="../MAESTROS/Marca/index.jsp" target="container"><span>Marca</span></a>
                            </li>
                            <li><a href="../MAESTROS/Maquinaria/index.jsp" target="container"><span>Maquinaria</span></a>
                            </li>
                            <li><a href="../MAESTROS/Profesion/index.jsp" target="container"><span>Profesion</span></a>
                            </li>
                            
                        </ul>
                        
                    </div>
                </li>
                <li style="float: right" class="last"><a href="" target="_blank" style=" float: right;">             
                        <img src="imagenes/icon_grupo_comet_powered_alpha.png"></a>
                </li>
            </ul>
        </div>    
        <iframe  id="container"  width="100%" height="99%"   frameBorder="0" name="container"></iframe>    
    </body>
</html>
