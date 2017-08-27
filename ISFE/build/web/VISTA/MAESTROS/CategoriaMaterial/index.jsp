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
        <title>Categoria de Materiales</title>
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
                $('#CatMatTablaContenidos').jtable({
                    title: 'Mantenimiento de Categoria de Materiales',
                    actions:{
                        listAction: '../../../srvCatMateriales?parAccion=list',
                        createAction: '../../../srvCatMateriales?parAccion=create',
                        updateAction: '../../../srvCatMateriales?parAccion=update',
                        deleteAction: '../../../srvCatMateriales?parAccion=delete'
                    },
                    fields: {
                        id: {
                          key:true,
                          create: false,
                          edit: false,
                          list: false
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
                        },
                        usuariocreacion: {
                            create: false,
                            edit: false,
                            list: false
                        },
                        fechacreacion: {
                            create: false,
                            edit: false,
                            list: false
                        },
                        usuariomodificacion: {
                            create: false,
                            edit: false,
                            list: false
                        },
                        fechamodificacion: {
                            create: false,
                            edit: false,
                            list: false
                        }
                    },
                    formCreated: function(event, data) {
                        $('.jtable-input > div').css('width','100%');
                        $('.jtable-input > div input').css('width','90%');
                    }
                });
                $('#CatMatTablaContenidos').jtable('load');
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
            <div id="CatMatTablaContenidos"></div>
        </div>
    </body>
</html>
