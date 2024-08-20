<%-- 
    Document   : CitaForm
    Created on : 11 ago 2024, 20:23:28
    Author     : Horacio Porras
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title><c:out value="${cita == null ? 'Nueva Cita' : 'Editar Cita'}" /> - Artavia Racing</title>

        <!-- Estilos CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
        <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
        <link href="css/citaForm.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">  
    </head>
    <body>
        <div id="menu-container">
            <!-- Menú se cargará aquí -->
        </div>
        
        
        <div class="main-container">
        <h1><c:out value="${cita == null ? 'Nueva Cita' : 'Editar Cita'}" /></h1>
        <form action="CitaController" method="post">
            <input type="hidden" name="action" value="${cita == null ? 'insert' : 'update'}">
            <c:if test="${cita != null}">
                <input type="hidden" name="id" value="${cita.id}">
            </c:if>

            <label for="placaVehiculo">Número de Placa del Vehiculo</label>
            <input type="text" id="placaVehiculo" name="placaVehiculo" value="${cita != null ? cita.placaVehiculo : ''}" required>

            <!-- Campo para categoría del servicio -->
                <div class="form-group">
                    <label for="codigoCategoriaServicio">Categoría de Servicio</label>
                    <select class="form-control" id="codigoCategoriaServicio">
                        <option value="">Seleccione una categoría</option>
                    </select>
                    <label id="errorCodigoCategoriaServicio" class="text-danger"></label>
                </div>
            
            <!-- Campo para servicio en base a la categoría -->
            <div class="form-group">
                <label for="codigoServicio">Servicio</label>
                <select class="form-control" id="codigoServicio">
                    <option value="">Seleccione un servicio</option>
                </select>
                <label id="errorCodigoServicio" class="text-danger"></label>
            </div>
            
            <input type="submit" value="${cita == null ? 'Agregar Cita' : 'Actualizar Cita'}">
        </form>
        <!-- Scripts JavaScript -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/Menu.js" type="text/javascript"></script>
        <script src="js/CitaForm.js" type="text/javascript"></script>
        </div>
    </body>
</html>