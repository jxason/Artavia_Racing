<%-- 
    Document   : CitaForm
    Created on : 11 ago 2024, 20:23:28
    Author     : Horacio Porras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nueva Cita</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
        <style>
            .text-danger {
                color: red;
            }
        </style>
    </head>

    <body>
        <div class="modal fade" id="citaModal" tabindex="-1" aria-labelledby="citaModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="citaModalLabel">Nueva Cita</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="citaForm">
                            <!-- Campo para vehiculos del usuario -->
                            <div class="form-group">
                                <label for="codigoVehiculo">Mi Vehiculo</label>
                                <select class="form-control" id="codigoVehiculo">
                                    <option value="">Seleccione un vehiculo</option>
                                </select>
                                <label id="errorCodigoVehiculo" class="text-danger"></label>
                            </div>

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

                            <div class="form-group">
                                <label for="fechaAgendada">Fecha de la Cita</label>
                                <input type="date" class="form-control" id="fechaAgendada">
                                <label id="errorFechaAgendada" class="text-danger"></label>
                            </div>

                            <div class="form-group">
                                <label for="descripcion">Descripción</label>
                                <textarea class="form-control" id="descripcion" placeholder="Ingrese la descripción" rows="3"></textarea>
                                <label id="errorDescripcion" class="text-danger"></label>
                            </div>

                            <button type="submit" class="btn btn-primary btn-block">Agendar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>         
        <!-- Scripts JavaScript -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/CitaForm.js" type="text/javascript"></script>
    </body>
</html>