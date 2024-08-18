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
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .actions a {
            margin-right: 10px;
            text-decoration: none;
            color: blue;
        }
        .actions a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Lista de Citas</h1>
    <a href="CitaController?action=new">Agregar Nueva Cita</a>
    <br><br>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Cliente</th>
                <th>Descripción</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cita" items="${listaCitas}">
                <tr>
                    <td>${cita.id}</td>
                    <td>${cita.nombreCliente}</td>
                    <td>${cita.descripcion}</td>
                    <td>${cita.fecha}</td>
                    <td>${cita.estado}</td>
                    <td class="actions">
                        <a href="CitaController?action=edit&id=${cita.id}">Editar</a>
                        <a href="CitaController?action=delete&id=${cita.id}" onclick="return confirm('¿Estás seguro de que deseas cancelar esta cita?');">Cancelar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>