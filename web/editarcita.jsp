<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Editar Cita</title>
<!-- Estilos CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
    <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">    
    
    
</head>
<body>
    <div id="menu-container">
        <!-- Menú se cargará aquí -->
    </div>
    
    <div class="container">
        <h2>Editar Cita</h2>
        <form id="editCitaForm" class="form-horizontal" enctype="multipart/form-data">
            <input type="hidden" id="citaId" name="citaId" value="">

            <div class="form-group">
                <label for="credencialId">Credencial ID:</label>
                <input type="text" class="form-control" id="credencialId" name="credencialId">
            </div>

            <div class="form-group">
                <label for="placaVehiculoId">Placa Vehículo ID:</label>
                <input type="text" class="form-control" id="placaVehiculoId" name="placaVehiculoId">
            </div>

            <div class="form-group">
                <label for="vin">VIN:</label>
                <input type="text" class="form-control" id="vin" name="vin">
            </div>

            <div class="form-group">
                <label for="servicioId">Servicio ID:</label>
                <input type="text" class="form-control" id="servicioId" name="servicioId">
            </div>

            <div class="form-group">
                <label for="estadoCitaId">Estado Cita ID:</label>
                <input type="text" class="form-control" id="estadoCitaId" name="estadoCitaId">
            </div>

            <div class="form-group">
                <label for="fechaAgendada">Fecha Agendada:</label>
                <input type="date" class="form-control" id="fechaAgendada" name="fechaAgendada">
            </div>

            <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <textarea class="form-control" id="descripcion" name="descripcion"></textarea>
            </div>

            <div class="form-group">
                <label for="horaAgendada">Hora Agendada:</label>
                <input type="time" class="form-control" id="horaAgendada" name="horaAgendada">
            </div>

            <div class="form-group">
                <label for="horaFinalizacion">Hora Finalización:</label>
                <input type="time" class="form-control" id="horaFinalizacion" name="horaFinalizacion">
            </div>

            <!-- Nuevo campo de diagnóstico -->
            <div class="form-group">
    <label for="diagnostico">Diagnóstico:</label>
    <input type="text" class="form-control" id="diagnostico" name="descripcion" placeholder="Ingrese el diagnóstico">
</div>

            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <button type="button" id="deleteCita" class="btn btn-danger">Eliminar Cita</button>
        </form>
    </div>
            <!-- Scripts JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="js/Menu.js" type="text/javascript"></script> <!-- Asegúrate de cargar el script aquí -->
    <script src="js/editarcita.js" type="text/javascript"></script>
</body>
</html>