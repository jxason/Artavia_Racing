<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Vehículos</title>
    <!-- Estilos CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
    <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <link href="css/inventario.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="menu-container">
        <!-- Menú se cargará aquí -->
    </div>
    <div class="container">
        <h2>Gestión de Vehículos</h2>
        <div class="form-container">
            <form id="vehicleForm" class="form-horizontal" enctype="multipart/form-data">
                <input type="hidden" id="editMode" value="false"> <!-- Campo oculto para modo de edición -->
                <div class="row">
                    <!-- Campos del formulario -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="placaVehiculoID">Placa Vehículo ID:</label>
                            <input type="text" id="placaVehiculoID" name="placaVehiculoID" class="form-control" required>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="vin">VIN:</label>
                            <input type="text" id="vin" name="vin" class="form-control" required>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="marca">Marca:</label>
                            <input type="text" id="marca" name="marca" class="form-control" required>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="modelo">Modelo:</label>
                            <input type="text" id="modelo" name="modelo" class="form-control" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="ano">Año:</label>
                            <input type="number" id="ano" name="ano" class="form-control" min="1900" max="2099" required>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="color">Color:</label>
                            <input type="text" id="color" name="color" class="form-control" required>
                        </div>
                    </div>
                     <div class="col-md-3">
                        <div class="form-group">
                            <label for="alDia">Al Día:</label>
                            <select id="alDia" name="alDia" class="form-control" required>
                                <option value="1">Sí</option>
                                <option value="0">No</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="tituloPropiedad">Título de Propiedad:</label>
                            <input type="file" id="tituloPropiedad" name="tituloPropiedad" class="form-control-file">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <button type="button" id="btnGuardar" class="btn btn-primary">Guardar</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="table-responsive">
            <table id="vehicleTable" class="display">
                <thead>
                    <tr>
                        <th>Placa</th>
                        <th>VIN</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Año</th>
                        <th>Color</th>
                        <th>Al Día</th>
                        <th>Imagen</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- DataTables llenará las filas aquí -->
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="js/vehicle.js" type="text/javascript"></script>
    <script src="js/Menu.js" type="text/javascript"></script>
</body>
</html>
