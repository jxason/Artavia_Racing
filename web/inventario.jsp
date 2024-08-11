<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Productos</title>
    <!-- Estilos CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <style>
        .container {
            max-width: 1200px;
            margin-top: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-container {
            max-width: 100%;
            margin: auto;
        }
        .row-cols-md-4>.col-md-3 {
            padding: 5px;
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div id="menu-container">
        [Menu]
    </div>
    <div class="container">
        <h2>Gestión de Productos</h2>
        <div class="form-container">
            <form id="productoForm" class="form-horizontal">
                <div class="row row-cols-md-4">
                    <!-- Campo para ID del producto -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="productoId">ID:</label>
                            <input type="text" id="productoId" name="productoId" class="form-control" readonly>
                        </div>
                    </div>
                    <!-- Campo para nombre del producto -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" class="form-control" required>
                        </div>
                    </div>
                    <!-- Campo para categoría del producto -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="codigoCategoriaProducto">Categoría Producto:</label>
                            <select class="form-control" id="codigoCategoriaProducto">
                              <option value="">Seleccione una categoría</option>
                            </select>
                        </div>
                    </div>
                    <!-- Campo para precio unitario -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="precioUnitario">Precio Unitario:</label>
                            <input type="number" id="precioUnitario" name="precioUnitario" class="form-control" step="0.01" required>
                        </div>
                    </div>
                </div>
                <div class="row row-cols-md-4">
                    <!-- Campo para descripción del producto -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="descripcion">Descripción:</label>
                            <textarea id="descripcion" name="descripcion" class="form-control"></textarea>
                        </div>
                    </div>
                    <!-- Campo para cantidad del producto -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="cantidad">Cantidad:</label>
                            <input type="number" id="cantidad" name="cantidad" class="form-control" required>
                        </div>
                    </div>
                    <!-- Campo para editado por -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="editadoPor">Editado Por:</label>
                            <input type="text" id="editadoPor" name="editadoPor" class="form-control" required>
                        </div>
                    </div>
                    <!-- Campo para habilitado -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="habilitado">Habilitado:</label>
                            <select id="habilitado" name="habilitado" class="form-control">
                                <option value="1">Sí</option>
                                <option value="0">No</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row row-cols-md-4">
                    <!-- Campo para fecha de creación -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="fechaCreacion">Fecha de Creación:</label>
                            <input type="date" id="fechaCreacion" name="fechaCreacion" class="form-control" required>
                        </div>
                    </div>
                    <!-- Campo para imagen -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="imagen">Imagen:</label>
                            <input type="file" id="imagen" name="imagen" class="form-control">
                        </div>
                    </div>
                </div>
                <!-- Botones para guardar y cancelar -->
                <div class="row">
                    <div class="col-md-12">
                        <button type="button" id="btnGuardar" class="btn btn-primary">Guardar</button>
                        <button type="button" id="btnCancelar" class="btn btn-secondary">Cancelar</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- Tabla para mostrar los productos -->
        <div class="table-responsive">
            <table id="productosTable" class="display">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Precio Unitario</th>
                        <th>Cantidad</th>
                        <th>Editado Por</th>
                        <th>Habilitado</th>
                        <th>Fecha de Creación</th>
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
    <!-- Scripts JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="js/Inventario.js" type="text/javascript"></script>
    <script src="js/CategoriasProducto.js" type="text/javascript"></script>
</body>
</html>
