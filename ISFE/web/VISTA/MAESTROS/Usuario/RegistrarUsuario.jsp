<%-- 
    Document   : RegistrarUsuario
    Created on : 31-ago-2017, 19:37:20
    Author     : Blad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
         <head>

                 <title>Formulario de Registro</title>
                 
                 
          <style type="text/css" >

.Estilo1 {
 color: #FFFFFF;
 font-weight: bold;
         }

body,td,th 
        {
 font-family: Arial, Helvetica, sans-serif;
 font-size: 12px;
        }


input:hover
        {
          background-color:#FFFF99
        }
input
        { 
         background-color:#D7D7FF;
         text-transform:uppercase;
        }



         </style>

         </head>

         <body>

         <form name="form" method="post" action="">
  
            <table width="393" border="0" align="center" cellpadding="5" cellspacing="1" bgcolor="#999999">
<tr>
                  <td colspan="2" align="center" bgcolor="#0066CC">
                  <span class="Estilo1">Registro de postulante</span> </td>
             </tr>
<tr>
                 <td width="110" bgcolor="#D7D7FF"><strong>Nombres</strong></td>
                 <td width="260" bgcolor="#FFFFFF">   
                 <input name="nombres" type="text" id="nombres" />      </td>
             </tr>
<tr>
                 <td bgcolor="#D7D7FF"><strong>Apellido Paterno </strong></td>
                 <td bgcolor="#FFFFFF"><input name="apellidopaterno" type="text"/></td>
    </tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Apellido Materno </strong></td>
      <td bgcolor="#FFFFFF"><input name="apellidomaterno" type="text" /></td>
    </tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Sexo</strong></td>
      <td bgcolor="#FFFFFF">
        <input name="sexo" type="radio"/> Masculino
        <input name="sexo" type="radio"/> Femenino </td>
    </tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>DNI</strong></td>
      <td bgcolor="#FFFFFF"><input name="dni" type="text" size="8" maxlength="8" /></td>
    </tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Dirección</strong></td>
      <td bgcolor="#FFFFFF"><input name="direccion" type="text" size="40" /></td>
    </tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Email</strong></td>
      <td bgcolor="#FFFFFF"><input name="email" type="text" size="40" /></td>
    </tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Ciudad</strong></td>
      <td bgcolor="#FFFFFF">
        <select name="ciudad" id="ciudad">
          <option value="">Seleccione</option>
          <option value="1">Lima</option>
          <option value="2">Tarapoto</option>
          <option value="3">Cusco</option>
          <option value="4">Iquitos</option>
          <option value="5">Tacna</option>
          <option value="7">Piura</option>
          <option value="8">Chiclayo</option>
          <option value="9">Tumbes</option>
        </select>     
     </td>

</tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Carrera</strong></td>
      <td bgcolor="#FFFFFF">

     <select name="carrera" id="carrera">
        <option value="">Seleccione</option>
        <option value="1">Ingeniería de Sistemas e Infromática</option>
        <option value="2">Ingeniería Civil</option>
        <option value="3">Arquitectura</option>
        <option value="4">Ingeniería Agroindustrial</option>
        <option value="5">Medicina Humana</option>
        <option value="6">Medicina Veterianaria</option>
     </select>
      </td>

</tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Colegio</strong></td>
      <td bgcolor="#FFFFFF"><input name="colegio" type="text" id="colegio" size="40" /></td>
    
</tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Tipo Colegio </strong></td>
      <td bgcolor="#FFFFFF"><input name="tipocolegio" type="radio" value="radiobutton" />
Nacional
  <input name="tipocolegio" type="radio" value="radiobutton" /> 
  Privado</td>
    </tr>
<tr>
      <td bgcolor="#D7D7FF"><strong>Intereses</strong></td>
      <td bgcolor="#FFFFFF">
           <input type="checkbox"  value="checkbox" />Matemáticas<br>
     <input type="checkbox"  value="checkbox" />Literatura<br>
     <input type="checkbox"  value="checkbox" />Historia<br>
     <input type="checkbox"  value="checkbox" />Botánica<br>
     <input type="checkbox"  value="checkbox" />Medicina<br>
            <input type="checkbox" value="checkbox" />Agro  
      </td>
    
</tr>
<tr>
      <td colspan="2" align="center" bgcolor="#0066CC">
        <input name="enviar" type="button" id="enviar" value="Enviar" />     
      </td>
</tr>
</table>
</form>
</body>

</html>
