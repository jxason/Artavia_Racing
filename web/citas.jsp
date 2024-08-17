<%-- 
    Document   : index
    Created on : 16 ago 2024, 11:33:24
    Author     : Luis Solorzano
    AR-001  Esta vista se usa para ver las citas y la gestion de citas
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestión de Citas</title>
    
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
    <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">    
    
    
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-4">Gestión de Citas</h2>
        
        <!-- Tabla de Citas -->
        <table id="citasTable" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Cliente</th>
                    <th>Servicio</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Los datos se llenarán dinámicamente con AJAX -->
            </tbody>
        </table>
        
        <!-- Formulario para añadir/editar citas -->
        <div id="citaFormContainer">
            <h3 class="text-center mt-4">Añadir/Editar Cita</h3>
            <form id="citaForm">
                <input type="hidden" id="citaId">
                <div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="date" class="form-control" id="fecha" required>
                </div>
                <div class="form-group">
                    <label for="hora">Hora:</label>
                    <input type="time" class="form-control" id="hora" required>
                </div>
                <div class="form-group">
                    <label for="cliente">Cliente:</label>
                    <input type="text" class="form-control" id="cliente" required>
                </div>
                <div class="form-group">
                    <label for="servicio">Servicio:</label>
                    <input type="text" class="form-control" id="servicio" required>
                </div>
                <div class="form-group">
                    <label for="estado">Estado:</label>
                    <select class="form-control" id="estado" required>
                        <option value="Pendiente">Pendiente</option>
                        <option value="Confirmada">Confirmada</option>
                        <option value="Cancelada">Cancelada</option>
                    </select>
                </div>
                <button type="button" id="btnGuardarCita" class="btn btn-primary">Guardar Cita</button>
            </form>
        </div>
    </div>
    
    <!-- Bootstrap JS, Popper.js, jQuery -->
    
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="js/citas.js" type="text/javascript"></script>
    <script src="js/Menu.js" type="text/javascript"></script> <!-- Asegúrate de cargar el script aquí -->
</body>
</html>