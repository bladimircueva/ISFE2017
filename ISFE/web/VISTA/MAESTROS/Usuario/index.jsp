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
                         Direccion: {
                          title:'Direccion',
                          create: true,
                          edit: true,
                          list:true
                        },
                         Telefono: {
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
                    },
                    formCreated: function(event, data) {
                        $('.jtable-input > div').css('width','100%');
                        $('.jtable-input > div input').css('width','90%');
                    }
                });
                $('#UsuariosTablaContenidos').jtable('load');
            });
            
            
        </script>
    <style>

        #jtable-create-form, #jtable-edit-form {
            height: 495px;
        }
        .ui-dialog .ui-widget-header,.ui-widget-header
        {
            background: #0D0D0D;
            border: 1px solid;
        }
        body
        {
            padding: 0px;
            margin:0px;
        }
        .container
        {
            padding: 0px;
            margin:0px;
            margin-top:20px;
            width:auto;
        }

    </style>
    
    </head>
    <body>
        <div class="container">
            <div id="UsuariosTablaContenidos"></div>
        </div>
    </body>
</html>
