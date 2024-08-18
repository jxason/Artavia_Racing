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
    <style>
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], textarea, input[type="date"], select {
            width: 100%;
            padding: 8px;
            margin: 4px 0;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1><c:out value="${cita == null ? 'Nueva Cita' : 'Editar Cita'}" /></h1>
    <form action="CitaController" method="post">
        <input type="hidden" name="action" value="${cita == null ? 'insert' : 'update'}">
        <c:if test="${cita != null}">
            <input type="hidden" name="id" value="${cita.id}">
        </c:if>
        
        <label for="nombreCliente">Nombre del Cliente:</label>
        <input type="text" id="nombreCliente" name="nombreCliente" value="${cita != null ? cita.nombreCliente : ''}" required>

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" required>${cita != null ? cita.descripcion : ''}</textarea>

        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" value="${cita != null ? cita.fecha : ''}" required>

        <label for="estado">Estado:</label>
        <select id="estado" name="estado">
            <option value="Agendada" ${cita != null && cita.estado == 'Agendada' ? 'selected' : ''}>Agendada</option>
            <option value="Completada" ${cita != null && cita.estado == 'Completada' ? 'selected' : ''}>Completada</option>
            <option value="Cancelada" ${cita != null && cita.estado == 'Cancelada' ? 'selected' : ''}>Cancelada</option>
        </select>

        <input type="submit" value="${cita == null ? 'Agregar Cita' : 'Actualizar Cita'}">
    </form>
</body>
</html>