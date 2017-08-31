package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>ISFE : login</title>\n");
      out.write("        <link href=\"");
      out.print( request.getContextPath());
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"");
      out.print( request.getContextPath());
      out.write("/css/bootstrap-responsive.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"");
      out.print( request.getContextPath());
      out.write("/css/css_style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"");
      out.print( request.getContextPath());
      out.write("/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/bootstrap-responsive.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"/css/css_style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"/css/bootstrap.css\">\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script language=\"Javascript\">\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                \n");
      out.write("            });\n");
      out.write("            var varConexion, varRcvReq;\n");
      out.write("    function crearXMLHttpRequest() {\n");
      out.write("                var xmlHttp = null;\n");
      out.write("                if (window.ActiveXObject)\n");
      out.write("                    xmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                else if (window.XMLHttpRequest)\n");
      out.write("                    xmlHttp = new XMLHttpRequest();\n");
      out.write("                return xmlHttp;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("    function recuperarDatos()\n");
      out.write("            {\n");
      out.write("                varConexion = crearXMLHttpRequest();\n");
      out.write("                varConexion.onreadystatechange = procesarEventos;\n");
      out.write("                var varNombreUsuario = \"\", varContrasenha = \"\", varConsulta = \"\";\n");
      out.write("                varNombreUsuario = document.getElementById('parNombreUsuario').value;\n");
      out.write("                varContrasenha = document.getElementById(\"parContrasenha\").value;\n");
      out.write("                varConsulta = \"?parAccion=consulta&parNombreUsuario=\" + varNombreUsuario + \"&parContrasenha=\" + varContrasenha;\n");
      out.write("                varConexion.open(\"GET\", 'ser_IniciarSesion' + varConsulta, false);\n");
      out.write("                varConexion.send(null);\n");
      out.write("                //alert(varConsulta);\n");
      out.write("            }\n");
      out.write("            function procesarEventos()\n");
      out.write("            {\n");
      out.write("                if(varConexion.readyState === 4)\n");
      out.write("                {\n");
      out.write("                    var usuario = varConexion.responseText.trim();\n");
      out.write("                    if (usuario === 'true') \n");
      out.write("                    {\n");
      out.write("                       parent.location.href = \"/ISFE/VISTA/Principal/mainbootstrap.jsp\";\n");
      out.write("                    }\n");
      out.write("                    else\n");
      out.write("                    {\n");
      out.write("                        Alert.render(\"Usuario y/o Contraseña Incorrecta(s)\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                    \n");
      out.write("            }\n");
      out.write("    function CustomAlert() {\n");
      out.write("                this.render = function(dialog) {\n");
      out.write("                    var winW = window.innerWidth;\n");
      out.write("                    var winH = window.innerHeight;\n");
      out.write("                    var dialogoverlay = document.getElementById('dialogoverlay');\n");
      out.write("                    var dialogbox = document.getElementById('dialogbox');\n");
      out.write("                    dialogoverlay.style.display = \"block\";\n");
      out.write("                    dialogoverlay.style.height = winH + \"px\";\n");
      out.write("                    dialogbox.style.left = (winW / 2) - (550 * .5) + \"px\";\n");
      out.write("                    dialogbox.style.top = \"100px\";\n");
      out.write("                    dialogbox.style.display = \"block\";\n");
      out.write("                    document.getElementById('dialogboxhead').innerHTML = \"Advertencia\";\n");
      out.write("                    document.getElementById('dialogboxbody').innerHTML = dialog;\n");
      out.write("                    document.getElementById('dialogboxfoot').innerHTML = '<button onclick=\"Alert.ok()\">OK</button>';\n");
      out.write("                }\n");
      out.write("                this.ok = function() {\n");
      out.write("                    document.getElementById('dialogbox').style.display = \"none\";\n");
      out.write("                    document.getElementById('dialogoverlay').style.display = \"none\";\n");
      out.write("                    parent.location.href = \"/ISFE/\";\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            var Alert = new CustomAlert();\n");
      out.write("        </script>\n");
      out.write("    \n");
      out.write("        <style>\n");
      out.write("            #dialogoverlay{\n");
      out.write("                display: none;\n");
      out.write("                opacity: .8;\n");
      out.write("                position: fixed;\n");
      out.write("                top: 0px;\n");
      out.write("                left: 0px;\n");
      out.write("                background: #FFF;\n");
      out.write("                width: 100%;\n");
      out.write("                z-index: 10;\n");
      out.write("            }\n");
      out.write("            #dialogbox{\n");
      out.write("                display: none;\n");
      out.write("                position: fixed;\n");
      out.write("                background: #000;\n");
      out.write("                border-radius:7px; \n");
      out.write("                width:550px;\n");
      out.write("                z-index: 10;\n");
      out.write("            }\n");
      out.write("            #dialogbox > div{ background:#FFF; margin:8px; }\n");
      out.write("            #dialogbox > div > #dialogboxhead{ background: #666; font-size:19px; padding:10px; color:#CCC; }\n");
      out.write("            #dialogbox > div > #dialogboxbody{ background:#333; padding:20px; color:#FFF; }\n");
      out.write("            #dialogbox > div > #dialogboxfoot{ background: #666; padding:10px; text-align:right; }\n");
      out.write("        \n");
      out.write("        </style>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stylelogin.css\">\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div id=\"dialogoverlay\"></div>\n");
      out.write("        <div id=\"dialogbox\">\n");
      out.write("            <div>\n");
      out.write("                <div id=\"dialogboxhead\"></div>\n");
      out.write("                <div id=\"dialogboxbody\"></div>\n");
      out.write("                <div id=\"dialogboxfoot\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"login\">\n");
      out.write("\n");
      out.write("            <form action=\"ser_IniciarSesion\" method=\"post\" style=\" margin-top: 200px\">\n");
      out.write("\n");
      out.write("                <span class=\"fontawesome-user\"></span><input type=\"text\" id=\"parNombreUsuario\" name=\"parNombreUsario\" required value=\"NombreUsuario\" onBlur=\"if (this.value == '')\n");
      out.write("                            this.value = 'NombreUsuario'\" onFocus=\"if (this.value == 'NombreUsuario')\n");
      out.write("                                        this.value = ''\">\n");
      out.write("                <input type=\"hidden\" id=\"parAccion\" name=\"parAccion\" value=\"iniciar\">\n");
      out.write("                <!-- JS because of IE support; better: placeholder=\"Username\" -->\n");
      out.write("                <span class=\"fontawesome-lock\"></span><input type=\"password\" id=\"parContrasenha\" name=\"parContrasenha\" required value=\"Contraseña\" onBlur=\"if (this.value == '')\n");
      out.write("                            this.value = 'Contraseña'\" onFocus=\"if (this.value == 'Contraseña')\n");
      out.write("                                        this.value = ''\"> <!-- JS because of IE support; better: placeholder=\"Password\" -->\n");
      out.write("                <input type=\"button\" id=\"frmIngresar\" onclick=\"recuperarDatos();\"  value=\"Iniciar Sesion\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("         <div id=\"footer\">\n");
      out.write("            <a href=\"#\" target=\"_blank\"> <img src=\"css/images/logoisfe.png\"></a>\n");
      out.write("            <p>ISFE Contratistas Generales S.A.C.</p><br>\n");
      out.write("         </div><\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
