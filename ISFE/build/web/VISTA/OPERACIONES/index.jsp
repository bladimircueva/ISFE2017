<%-- 
    Document   : index
    Created on : 19-ago-2017, 4:40:01
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obras</title>
           <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../..//WEB-INF/jspf/acceso.jspf" %>  
        <script src="../../js/jquery.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/jquery.datetimepicker.js"></script>
        <script src="../../js/jquery-ui-1.9.2.min.js"></script>
        <%@include file="../../WEB-INF/jspf/imports.jspf" %>  
        
        <script type="text/javascript">
            $(document).ready(function()
            //prepare jTable        
            {
                $('#ObrasTablaContenidos').jtable({
                    title: 'Obras',
                    useBootstrap: true,
                    actions:{
                        listAction: '../../srvObras?parAccion=list',
                        createAction: '../../srvObras?parAccion=create',
                        updateAction: '../../srvObras?parAccion=update',
                        deleteAction: '../../srvObras?parAccion=delete'
                    },
                    fields: {
                        id: {
                          key:true,
                          create: false,
                          edit: false,
                          list: true
                        },
                        usuariocreacion: {
                          title:'Creado por',
                          create: false,
                          edit: false,
                          list:true
                        },
                        codigo: {
                          title:'codigo',
                          create: true,
                          edit: true,
                          list:true,
                          inputClass:'validate[required,maxSize[4]]' 
                        },
                        nombre: {
                            title:'Obra',
                            create: true,
                            edit: true,
                            list: true,
                            inputClass: 'validate[required,maxSize[50]]'
                        },  
                        nombrecliente: {
                            title:'Cliente',
                            create: true,
                            edit: true,
                            list: true
                        },
                        ubicacion: {
                            title:'Ubicacion',
                            create: true,
                            edit: true,
                            list: true
                        },
                        fechainicio: {
                            title:'Inicializacion',
                            create: true,
                            edit: true,
                            list: true,
                            type: 'date'
                        },
                        fechafin: {
                            title:'Finalizacion',
                            create: true,
                            edit: true,
                            list: true,
                            type: 'date'
                        },
                        presupuesto: {
                            title:'Presupuesto de Obra',
                            create: true,
                            edit: true,
                            list: true,
                            type: 'number'
                        },
                        numeropartidas: {
                            title:'Partidas',
                            create: true,
                            edit: true,
                            list: true
                        },
                        Partidas: {
                            title: 'Partidas',
                            width: '2%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(listauxe) {
                                var $img = $('<img src="<%= request.getContextPath()%>/css/images/list.png" />');
                                $img.click(function() {
                                    $('#ObrasTablaContenidos').jtable('openChildTable',
                                            $img.closest('tr'), //Parent row
                                            {
                                                title: 'Partidas',
                                                editinline: {enable: true},
                                                actions: {
                                                    listAction: '../../srvObras?parAccion=listchild&varmaster=' + listauxe.record.id,
                                                    updateAction: '../../srvObras?parAccion=updatechild',
                                                    deleteAction: '../../srvObras?parAccion=deletechild',
                                                    createAction: '../../srvObras?parAccion=createchild&varmaster=' + listauxe.record.id
                                                },
                                                fields: {
                                                    id: {
                                                        key: true,
                                                        create: false,
                                                        edit: false,
                                                        list: true
                                                    },
                                                    codigo: {
                                                        title: 'codigo',
                                                        create: true,
                                                        edit: true,
                                                        list: true,
                                                        inputClass: 'validate[required,maxSize[4]]'
                                                    },
                                                    fechainicio: {
                                                        title: 'Fecha Inicio',
                                                        create: true,
                                                        edit: true,
                                                        list: true,
                                                        type: 'date'
                                                    },
                                                    fechafin: {
                                                        title: 'Fecha Fin',
                                                        create: true,
                                                        edit: true,
                                                        list: true,
                                                        type: 'date'
                                                    },
                                                    usuariocreacion: {
                                                        title: 'Creado por ',
                                                        list: true,
                                                        create: false,
                                                        edit: false
                                                    }
                                                },
                                                formCreated: function(event, data) {
                                                }
                                            }, function(data) {
                                        data.childTable.jtable('load');
                                    });
                                });

                                return $img;
                            }
                        },
                    },
                    formCreated: function(event, data) {
                        
                    }
                });
                $('#ObrasTablaContenidos').jtable('load');
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
            <div id="ObrasTablaContenidos"></div>
        </div>
    </body>
</html>
