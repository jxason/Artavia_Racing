<%-- 
    Document   : CitaLista
    Created on : 11 ago 2024, 20:23:08
    Author     : Horacio Porras
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Mis Citas - Artavia Racing</title>

        <!-- Estilos CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
        <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
        <link href="css/citaLista.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">    
    </head>
    <body>
        <div id="menu-container">
            <!-- Menú se cargará aquí -->
        </div>


        <div class="main-container">
            <h1>Mis Citas</h1>
            <div class="row">
                <div class="col-md-12">
                    <button type="button" class="btn btn-primary">
                        <a href="CitaController?action=new" style="color: white !important; text-decoration: none;">Agendar Nueva Cita</a>
                    </button>                        
                </div>
            </div>
            <br>
            <table id="tablaCitas">
                <thead>
                    <tr>
                        <th>Placa del Vehiculo</th>
                        <th>Vehiculo</th>
                        <th>Categoría del Servicio</th>
                        <th>Servicio</th>
                        <th>Fecha Agendada</th>
                        <th>Hora Agendada</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Las filas se llenarán con jQuery/AJAX -->
                </tbody>
            </table>
            <!-- Scripts JavaScript -->
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
            <script src="js/Menu.js" type="text/javascript"></script>
            <script src="js/CitaLista.js" type="text/javascript"></script>
        </div>
    </body>
</html>