<%-- 
    Document   : index
    Created on : 26-ago-2017, 9:48:12
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Materiales</title>
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
                $('#MaterialTablaContenidos').jtable({
                    title: 'Mantenimiento de Materiales',
                    actions:{
                        listAction: '../../../srvMaterial?parAccion=list',
                        createAction: '../../../srvMaterial?parAccion=create',
                        updateAction: '../../../srvMaterial?parAccion=update',
                        deleteAction: '../../../srvMaterial?parAccion=delete'
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
                        preciounitarioexpediente: {
                            title:'Precio Unitario Expediente',
                            create: true,
                            edit: true,
                            list: true
                        },
                        usuariocreacion: {
                            title:'Usuario Creacion',
                            create: false,
                            edit: false,
                            list: false
                        },
                        fechacreacion: {
                            title:'Fecha Creacion',
                            create: false,
                            edit: false,
                            list: false
                        },
                        unidadmedida_id: {
                            title:'Unidad de Medida',
                            create: false,
                            edit: false,
                            list: false
                        },
                        materialcategoria_id: {
                            title:'Categoria de Material',
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
                $('#MaterialTablaContenidos').jtable('load');
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
            <div id="MaterialTablaContenidos"></div>
        </div>
    </body>
</html>
