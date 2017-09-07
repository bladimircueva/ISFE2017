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
                    actions:{
                        listAction: '../../srvObras?parAccion=list',
                        createAction: '../../../srvObras?parAccion=create',
                        updateAction: '../../../srvObras?parAccion=update',
                        deleteAction: '../../../srvObras?parAccion=delete'
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
                        nombre: {
                            title:'Obra',
                            create: true,
                            edit: true,
                            list: true
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
                            list: true
                        },
                        fechafin: {
                            title:'Finalizacion',
                            create: true,
                            edit: true,
                            list: true
                        },
                        presupuesto: {
                            title:'Presupuesto de Obra',
                            create: true,
                            edit: true,
                            list: true
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
                                var $img = $('<img src="<%= request.getContextPath()%>/imagenes/list.png" />');
                                $img.click(function() {
                                    $('#ObrasTablaContenidos').jtable('openChildTable',
                                            $img.closest('tr'), //Parent row
                                            {
                                                title: 'Partidas',
                                                editinline: {enable: true},
                                                actions: {
                                                    listAction: '../../srvObras?parAccion=listchild&varmaster=' + listauxe.record.obr_id,
                                                    updateAction: '../../srvObras?parAccion=updatechild',
                                                    deleteAction: '../../srvObras?parAccion=deletechild',
                                                    createAction: '../../srvObras?parAccion=createchild&varmaster=' + listauxe.record.ent_id
                                                },
                                                fields: {
                                                    par_id: {
                                                        key: true,
                                                        create: false,
                                                        edit: false,
                                                        list: false
                                                    },
                                                    par_CodigoPartida: {
                                                        title: 'Direccion',
                                                        create: true,
                                                        edit: true,
                                                        width: '1%',
                                                        list: true,
                                                        inputClass: 'validate[required,maxSize[50],minSize[10]]'
                                                    },
                                                    par_FechaInicio: {
                                                        title: 'Telefono',
                                                        create: true,
                                                        edit: true,
                                                        width: '1%',
                                                        list: true
                                                    },
                                                    par_FechaFin: {
                                                        title: 'Celular',
                                                        create: true,
                                                        edit: true,
                                                        width: '1%',
                                                        list: true
                                                    },
                                                    par_usucreacion: {
                                                        title: 'UsuCreacion',
                                                        width: '10%',
                                                        list: false,
                                                        create: false,
                                                        edit: false
                                                    },
                                                    par_feccreacion: {
                                                        title: 'FecCreacion',
                                                        width: '10%',
                                                        list: false,
                                                        create: false,
                                                        edit: false
                                                    },
                                                    par_usumodificacion: {
                                                        title: 'UsuModificacion',
                                                        width: '10%',
                                                        list: false,
                                                        create: false,
                                                        edit: false
                                                    },
                                                    par_fecmodificacion: {
                                                        title: 'FecModificacion',
                                                        width: '10%',
                                                        list: false,
                                                        create: false,
                                                        edit: false
                                                    }
                                                },
                                                formCreated: function(event, data) {
                                                    data.form.find('input[name="edi_direccion"]').prop('maxlength', '100');
                                                    data.form.find('input[name="edi_direccion"]').css('width', '100%');
                                          
                                                    if (data.formType === 'edit') {
                                                        $('.jtable-edit-form div:nth-child(17)').hide();
                                                        $('.jtable-edit-form div:nth-child(18)').hide();
                                                        $('.jtable-edit-form div:nth-child(19)').hide();
                                                        ubi_departamento = $('#Edit-ubi_departamento').val();
                                                        ubi_provincia = $('#Edit-ubi_provincia').val();
                                                        ubi_distrito = $('#Edit-ubi_distrito').val();
                                                    }
                                                    else {
                                                        $('.jtable-create-form div:nth-child(15)').hide();
                                                        $('.jtable-create-form div:nth-child(16)').hide();
                                                        $('.jtable-create-form div:nth-child(17)').hide();
                                                    }

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
                        $('.jtable-input > div').css('width','100%');
                        $('.jtable-input > div input').css('width','90%');
                    }
                });
                $('#ObrasTablaContenidos').jtable('load');
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
            <div id="ObrasTablaContenidos"></div>
        </div>
    </body>
</html>
