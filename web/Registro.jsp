<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
    <style>
        .text-danger {
            color: red;
        }
    </style>
</head>
<body>

<div class="modal fade" id="registroModal" tabindex="-1" aria-labelledby="registroModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registroModalLabel">Registro de Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="registroForm">
                   <div class="form-group">
                        <label for="credencialId">Cédula</label>
                        <input type="text" class="form-control" id="credencialId" placeholder="Ingrese su cédula"
                               pattern="\d*" title="Solo se permiten digitos">
                        <label id="errorCredencialId" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" placeholder="Ingrese su nombre">
                        <label id="errorNombre" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="primerApellido">Primer Apellido</label>
                        <input type="text" class="form-control" id="primerApellido" placeholder="Ingrese su primer apellido">
                        <label id="errorPrimerApellido" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="segundoApellido">Segundo Apellido</label>
                        <input type="text" class="form-control" id="segundoApellido" placeholder="Ingrese su segundo apellido">
                        <label id="errorSegundoApellido" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="fechaNacimiento">Fecha de Nacimiento</label>
                        <input type="date" class="form-control" id="fechaNacimiento">
                        <label id="errorFechaNacimiento" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="email">Correo Electrónico</label>
                        <input type="email" class="form-control" id="txtEmail" placeholder="Ingrese su correo electrónico">
                        <label id="errorEmail" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="contraseña">Contraseña</label>
                        <input type="password" class="form-control" id="contraseña" placeholder="Ingrese su contraseña">
                        <label id="errorContrasena" class="text-danger"></label>
                        <ul>
                            <li id="requisitoMayuscula">Una letra mayúscula</li>
                            <li id="requisitoDigitos">Dos dígitos</li>
                            <li id="requisitoEspecial">Un carácter especial</li>
                            <li id="requisitoLongitud">Al menos 6 caracteres</li>
                        </ul>
                    </div>
                    <div class="form-group">
                        <label for="confirmarContraseña">Confirmar contraseña</label>
                        <input type="password" class="form-control" id="confirmarContraseña" placeholder="Ingrese nuevamente su contraseña">
                        <label id="errorConfirmarContrasena" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="numeroTelefono">Número de Teléfono</label>
                        <input type="text" class="form-control" id="numeroTelefono" placeholder="Ingrese su número de teléfono">
                        <label id="errorNumeroTelefono" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="categoriaTelefonoId">Categoría de Teléfono</label>                        
                        <select class="form-control" id="categoriaTelefonoId">
                            <option value="">Seleccione tipo teléfono</option>
                        </select>
                        <label id="errorCategoriaTelefonoId" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="numeroExtension">Número de Extensión (opcional)</label>
                        <input type="text" class="form-control" id="numeroExtension" placeholder="Ingrese su número de extensión">
                       
                    </div>
                    <div class="form-group">
                        <label for="descripcionTelefono">Descripción de Teléfono (opcional)</label>                       
                        <textarea class="form-control" id="descripcionTelefono" placeholder="Ingrese la descripción del teléfono" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="codigoPais">País</label>
                      <select class="form-control" id="codigoPais">
                        <option value="">Seleccione un país</option>
                      </select>
                      <label id="errorCodigoPais" class="text-danger"></label>
                    </div>

                    <div class="form-group">
                        <label for="codigoEstado">Estado</label>
                        <select class="form-control" id="codigoEstado">
                            <option value="">Seleccione un estado</option>
                        </select>                        
                        <label id="errorCodigoEstado" class="text-danger"></label>
                    </div>

                    <div class="form-group">
                        <label for="codigoCondado">Condado</label>
                        <select class="form-control" id="codigoCondado">
                            <option value="">Seleccione un estado</option>
                        </select>                           
                        <label id="errorCodigoCondado" class="text-danger"></label>
                    </div>

                    <div class="form-group">
                        <label for="codigoDistrito">Distrito</label>
                        <select class="form-control" id="codigoDistrito">
                            <option value="">Seleccione un estado</option>
                        </select>
                        <label id="errorCodigoDistrito" class="text-danger"></label>
                    </div>
                    <div class="form-group">
                        <label for="descripcionDireccion">Descripción de la Dirección</label>
                        <textarea class="form-control" id="descripcionDireccion" placeholder="Ingrese la descripción de la dirección" rows="3"></textarea>
                        <label id="errorDescripcionDireccion" class="text-danger"></label>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Registrar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="js/Registro.js" type="text/javascript"></script>
</body>
</html>
