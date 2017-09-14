<%-- 
    Document   : index
    Created on : 31-ago-2017, 15:18:11
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Roles</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/acceso.jspf" %>  
        <script src="../../../js/jquery.min.js"></script>
        <script src="../../../js/bootstrap.min.js"></script>
        <script src="../../../js/jquery.datetimepicker.js"></script>
        <script src="../../../js/jquery-ui-1.9.2.min.js"></script>
        <%@include file="/WEB-INF/jspf/imports.jspf" %>               
        <link href="../../../css/evol.colorpicker.min.css" rel="stylesheet" /> 
        <script src="../../../js/evol.colorpicker.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function()
            //prepare jTable        
            {
                $('#UsuariosTablaContenidos').jtable({
                    title: 'Mantenimiento de Usuarios',
                    actions:{
                        listAction: '../../../srvUsuarios?parAccion=list',
                        createAction: '../../../srvUsuarios?parAccion=create',
                        updateAction: '../../../srvUsuarios?parAccion=update',
                        deleteAction: '../../../srvUsuarios?parAccion=delete'
                    },
                    fields: {
                        id: {
                          key:true,
                          create: false,
                          edit: false,
                          list: false
                        },
                        nombres: {
                          title:'Nombres',
                          create: true,
                          edit: true,
                          list:true
                          //inputClass: 'validate{required}'
                        },
                        apellidos: {
                            title:'Apellidos',
                            create: true,
                            edit: true,
                            list: true
                        },
                         email: {
                          title:'e-mail',
                          create: true,
                          edit: true,
                          list:true
                        },
                         direccion: {
                          title:'Direccion',
                          create: true,
                          edit: true,
                          list:true
                        },
                         telefono: {
                          title:'Telefono',
                          create: true,
                          edit: true,
                          list:true
                        },
                         dni: {
                          title:'DNI',
                          create: true,
                          edit: true,
                          list:true
                        },
                         nombreusuario: {
                          title:'Nombre de Usuario',
                          create: true,
                          edit: true,
                          list:true
                        },
                         password: {
                          title:'Password',
                          create: true,
                          edit: true,
                          list:true
                        },
                        rol_id:{
                            title: 'Rol',
                            create: true,
                            edit: true,
                            list: true
                        }
                        
                    },
                    formCreated: function(event, data) {
                    }
                });
                $('#UsuariosTablaContenidos').jtable('load');
            });
        </script>
    <style>
    </style>
    
    </head>
    <body>
        <div class="container">
            <div id="UsuariosTablaContenidos"></div>
        </div>
    </body>
</html>
