<%-- 
    Document   : index
    Created on : 16-ago-2017, 18:33:55
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="net.sf.json.JSONObject"%>
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
                $('#RolesTablaContenidos').jtable({
                    title: 'Mantenimiento de Roles',
                    actions:{
                        listAction: '../../../srvRoles?parAccion=list',
                        createAction: '../../../srvRoles?parAccion=create',
                        updateAction: '../../../srvRoles?parAccion=update',
                        deleteAction: '../../../srvRoles?parAccion=delete'
                    },
                    fields: {
                        id: {
                          key:true,
                          create: false,
                          edit: false,
                          list: true
                        },
                        codigo: {
                          title:'codigo',
                          create: true,
                          edit: true,
                          list:true
                        },
                        descripcion: {
                            title:'Descripcion',
                            create: true,
                            edit: true,
                            list: true
                        }
                    },
                    formCreated: function(event, data) {
                        $('.jtable-input > div').css('width','100%');
                        $('.jtable-input > div input').css('width','90%');
                    }
                });
                $('#RolesTablaContenidos').jtable('load');
            });
            
            
        </script>
    <style>

       .ui-dialog .ui-widget-header,.ui-widget-header
        {
            background: #006dcc;
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
        

#jtable-create-form, #jtable-edit-form {
                
                -moz-column-count:2;
                -webkit-column-count:2;
                column-count:2;
            }
    </style>
    
    </head>
    <body>
        <div class="container">
            <div id="RolesTablaContenidos"></div>
        </div>
    </body>
</html>
