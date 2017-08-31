<%-- 
    Document   : index
    Created on : 16-ago-2017, 11:01:54
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ISFE : login</title>
        <link href="<%= request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%= request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
        <link href="<%= request.getContextPath()%>/css/css_style.css" rel="stylesheet" type="text/css" />
        <link href="<%= request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap-responsive.css">
        <link rel="stylesheet" href="/css/css_style.css">
        <link rel="stylesheet" href="/css/bootstrap.css">
        <script src="js/jquery.min.js"></script>
        <script language="Javascript">
            $(document).ready(function() {
                
            });
            var varConexion, varRcvReq;
    function crearXMLHttpRequest() {
                var xmlHttp = null;
                if (window.ActiveXObject)
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                else if (window.XMLHttpRequest)
                    xmlHttp = new XMLHttpRequest();
                return xmlHttp;
            }
            
    function recuperarDatos()
            {
                varConexion = crearXMLHttpRequest();
                varConexion.onreadystatechange = procesarEventos;
                var varNombreUsuario = "", varContrasenha = "", varConsulta = "";
                varNombreUsuario = document.getElementById('parNombreUsuario').value;
                varContrasenha = document.getElementById("parContrasenha").value;
                varConsulta = "?parAccion=consulta&parNombreUsuario=" + varNombreUsuario + "&parContrasenha=" + varContrasenha;
                varConexion.open("GET", 'ser_IniciarSesion' + varConsulta, false);
                varConexion.send(null);
                //alert(varConsulta);
            }
            function procesarEventos()
            {
                if(varConexion.readyState === 4)
                {
                    var usuario = varConexion.responseText.trim();
                    if (usuario === 'true') 
                    {
                       parent.location.href = "/ISFE/VISTA/Principal/mainbootstrap.jsp";
                    }
                    else
                    {
                        Alert.render("Usuario y/o Contraseña Incorrecta(s)");
                    }
                }
                    
            }
    function CustomAlert() {
                this.render = function(dialog) {
                    var winW = window.innerWidth;
                    var winH = window.innerHeight;
                    var dialogoverlay = document.getElementById('dialogoverlay');
                    var dialogbox = document.getElementById('dialogbox');
                    dialogoverlay.style.display = "block";
                    dialogoverlay.style.height = winH + "px";
                    dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
                    dialogbox.style.top = "100px";
                    dialogbox.style.display = "block";
                    document.getElementById('dialogboxhead').innerHTML = "Advertencia";
                    document.getElementById('dialogboxbody').innerHTML = dialog;
                    document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Alert.ok()">OK</button>';
                }
                this.ok = function() {
                    document.getElementById('dialogbox').style.display = "none";
                    document.getElementById('dialogoverlay').style.display = "none";
                    parent.location.href = "/ISFE/";
                }
                
            }
            var Alert = new CustomAlert();
        </script>
    
        <style>
            #dialogoverlay{
                display: none;
                opacity: .8;
                position: fixed;
                top: 0px;
                left: 0px;
                background: #FFF;
                width: 100%;
                z-index: 10;
            }
            #dialogbox{
                display: none;
                position: fixed;
                background: #000;
                border-radius:7px; 
                width:550px;
                z-index: 10;
            }
            #dialogbox > div{ background:#FFF; margin:8px; }
            #dialogbox > div > #dialogboxhead{ background: #666; font-size:19px; padding:10px; color:#CCC; }
            #dialogbox > div > #dialogboxbody{ background:#333; padding:20px; color:#FFF; }
            #dialogbox > div > #dialogboxfoot{ background: #666; padding:10px; text-align:right; }
        
        </style>
        <link rel="stylesheet" href="css/stylelogin.css">
    </head>
    
    
    <body>
        <div id="dialogoverlay"></div>
        <div id="dialogbox">
            <div>
                <div id="dialogboxhead"></div>
                <div id="dialogboxbody"></div>
                <div id="dialogboxfoot"></div>
            </div>
        </div>
        <div id="login">

            <form action="ser_IniciarSesion" method="post" style=" margin-top: 200px">

                <span class="fontawesome-user"></span><input type="text" id="parNombreUsuario" name="parNombreUsario" required value="NombreUsuario" onBlur="if (this.value == '')
                            this.value = 'NombreUsuario'" onFocus="if (this.value == 'NombreUsuario')
                                        this.value = ''">
                <input type="hidden" id="parAccion" name="parAccion" value="iniciar">
                <!-- JS because of IE support; better: placeholder="Username" -->
                <span class="fontawesome-lock"></span><input type="password" id="parContrasenha" name="parContrasenha" required value="Contraseña" onBlur="if (this.value == '')
                            this.value = 'Contraseña'" onFocus="if (this.value == 'Contraseña')
                                        this.value = ''"> <!-- JS because of IE support; better: placeholder="Password" -->
                <input type="button" id="frmIngresar" onclick="recuperarDatos();"  value="Iniciar Sesion">
            </form>
        </div>
         <div id="footer">
            <a href="#" target="_blank"> <img src="css/images/logoisfe.png"></a>
            <p>ISFE Contratistas Generales S.A.C.</p><br>
         </div><
    </body>
</html>
