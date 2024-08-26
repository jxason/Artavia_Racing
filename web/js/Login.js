/**
 * AR-001
 * @author José Andrés Alvarado Matamoros
 * @file login.js
 * @brief Contiene la lógica para la validación de usuario al iniciar sesión.
 * 
 * @version 1.0
 * @function ValidarUsuario
 * @description Función que se llama al hacer clic en el botón de "Iniciar Sesión". 
 *              Realiza una solicitud AJAX para validar las credenciales del usuario.
 * @returns {void} No devuelve ningún valor. Redirige al usuario según el resultado de la autenticación.
 */
function ValidarUsuario() {
    // Obtener el valor de los campos de email y contraseña
    var email = $("#email").val();
    var password = $("#password").val();

    // Validar campos vacíos
    if (!email || !password) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    // Mostrar un mensaje de carga (opcional)
    $("#loginSpinner").show(); // Asegúrate de tener un elemento con ID 'loginSpinner' para mostrar un spinner

    // Enviar solicitud AJAX al servlet LoginController
    $.ajax({
        type: "POST",
        url: "/Artavia_Racing/LoginController", // URL del servlet que manejará la solicitud
        data: {
            email: email,
            password: password
        },
        dataType: "json",
        async: false, // Esto hace que la llamada sea sincrónica
        success: function(response) {
            // Ocultar el mensaje de carga
            $("#loginSpinner").hide();

            if (response.success) {
                // Redirigir al home si la autenticación es exitosa
                window.location.href = "home.jsp";
            } else {
                // Mostrar un mensaje de error si las credenciales son incorrectas
                alert("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
            }
        },
        error: function() {
            // Ocultar el mensaje de carga
            $("#loginSpinner").hide();

            // Mostrar un mensaje de error en caso de falla en la solicitud AJAX
            alert("Ocurrió un error. Por favor, inténtelo de nuevo.");
        }
    });
}
