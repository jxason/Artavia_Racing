<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Editar Cita</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
</head>
<body>
    <div class="container">
        <h2>Editar Cita</h2>
        <form id="editCitaForm">
            <input type="hidden" id="citaId" name="citaId" value="${param.id}">

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

            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <button type="button" id="deleteCita" class="btn btn-danger">Eliminar Cita</button>
        </form>
    </div>
            
            <script src="js/editarcita.js" type="text/javascript"></script>
</body>
</html>