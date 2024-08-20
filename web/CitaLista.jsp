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
        <title>Lista de Citas - Artavia Racing</title>

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
        <h1>Tus Citas</h1>
        <div class="row">
            <div class="col-md-12">
                <button type="button" class="btn btn-primary">
                    <a href="CitaController?action=new" style="color: white !important; text-decoration: none;">Agendar Nueva Cita</a>
                </button>                        
            </div>
        </div>
        <br>
        <table>
            <thead>
                <tr>
                    <th>ID Cita</th>
                    <th>Cliente</th>
                    <th>Vehiculo</th>
                    <th>Servicio</th>
                    <th>Fecha Agendada</th>
                    <th>Hora Agendada</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cita" items="${listaCitas}">
                    <tr>
                        <td>${cita.id}</td>
                        <td>${cita.nombreCliente}</td>
                        <td>${cita.vehiculo}</td>
                        <td>${cita.servicio}</td>
                        <td>${cita.fecha}</td>
                        <td>${cita.hora}</td>
                        <td>${cita.estado}</td>
                        <td class="actions">
                            <a href="CitaController?action=edit&id=${cita.id}">Editar</a>
                            <a href="CitaController?action=delete&id=${cita.id}" onclick="return confirm('¿Estás seguro de que deseas cancelar esta cita?');">Cancelar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Scripts JavaScript -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
        <script src="js/Menu.js" type="text/javascript"></script> <!-- Asegúrate de cargar el script aquí -->
        </div>
    </body>
</html>