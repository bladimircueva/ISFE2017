<%-- 
    Document   : index
    Created on : 15/09/2017, 03:43:17 AM
    Author     : Bladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width-device-width, initial-scale=1">
        <title> Menu ISFE</title>
        <link href="../../css/bootstrap.min.css" rel="stylesheet">
        <link href="../../css/bootstrap-select.css" rel="stylesheet">
        <script src="../../js/jquery.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <link href="../../css/bootstrap-select.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../../css/bootstrap-select.css">
        <script src="../../js/bootstrap-select.js"></script>
        <script src="../../js/bootstrap-select.min.js"></script>
        <!--<link href="~/Styles/Site.css" rel="stylesheet" type="text/css" />-->
        <!--Include JQuery Style File-->
        <link href="../../css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <link href="../../css/jquery-ui.css" rel="stylesheet" type="text/css" />
        <!--Include JQuery File-->
        <script type="text/javascript" language="Javascript" src="../../js/jquery.min.js"></script>
        <!--Include JQuery UI File-->
        <script type="text/javascript" language="Javascript" src="../../js/jquery-ui.min.js"></script>
        <script type="text/javascript" language="Javascript" src="../../js/jquery-ui.js"></script>
    
     <script type="text/javascript">
         
         //$ ( '.typeahead' ). typeahead ()
         
         $(document).ready(function ()
        {
            $('#listaobras').html('');
            $.post('/ISFE/srvObras', {
                parAccion: 'getListObra'}, 
            function (rsp)
            {
                var JSONObject = JSON.parse(rsp);
                $.each(JSONObject, function (index, item) {
                    
                console.log(rsp);
                    $('#listaobras').append("<option value=" + item.id + ">" + item.nombre + "</option>");
                });
            });
        });
        
        
         
         </script>
    </head>
    <body>
        <div class="row" style="align-content: center">
            <div class="col-lg-">
                  <label for="menu">Obras Registradas</label><br>
                  <select id="listaobras"  data-style="btn-primary">
                          <OPTION VALUE="" selected>--Seleccione--</OPTION>
                  </select>
            </div>
</div>
    </body>
</html>
