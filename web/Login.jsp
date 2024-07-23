<%-- 
    Document   : Login
    Created on : 8 jul 2024, 17:33:24
    Author     : Andrés Alvarado Matamoeos
    AR-001 Este pop up se utiliza para inciar sesión al sitio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<!-- Modal de Iniciar Sesión -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Iniciar Sesión</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="email">Correo Electrónico</label>
                        <input type="email" class="form-control" id="email" placeholder="Ingrese su correo electrónico">
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input type="password" class="form-control" id="password" placeholder="Ingrese su contraseña">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>
                    <div class="text-center mt-3">
                        <a id="btnOlvidoContraseña" href="#" class="btn btn-link">¿Olvidó su contraseña?</a>
                    </div>
                    <div class="text-center mt-3">
                        <a id="btnRegistrarse" href="#" class="btn btn-link" data-toggle="modal" data-target="#registroModal">Registrarse</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal de Registro -->
<jsp:include page="Registro.jsp" />

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
