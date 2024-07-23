/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 *  Función para validar el formulario antes de enviarlo al servlet
 * @returns {Boolean}
 */
function validarFormulario() {
    let esValido = true;

    // Obtener los valores de los campos del formulario
    const credencialId = document.getElementById('credencialId').value.trim();
    const nombre = document.getElementById('nombre').value.trim();
    const primerApellido = document.getElementById('primerApellido').value.trim();
    const segundoApellido = document.getElementById('segundoApellido').value.trim();
    const fechaNacimiento = document.getElementById('fechaNacimiento').value.trim();
    const email = document.getElementById('txtEmail').value.trim();
    const contrasena = document.getElementById('contraseña').value.trim();
    const confirmarContrasena = document.getElementById('confirmarContraseña').value.trim();
    const numeroTelefono = document.getElementById('numeroTelefono').value.trim();
    const categoriaTelefonoId = document.getElementById('categoriaTelefonoId').value;
    const numeroExtension = document.getElementById('numeroExtension').value.trim();
    const descripcionTelefono = document.getElementById('descripcionTelefono').value.trim();
    const codigoPais = document.getElementById('codigoPais').value;
    const codigoEstado = document.getElementById('codigoEstado').value;
    const codigoCondado = document.getElementById('codigoCondado').value;
    const codigoDistrito = document.getElementById('codigoDistrito').value;
    const descripcionDireccion = document.getElementById('descripcionDireccion').value.trim();

    // Limpiar mensajes de error
    const errorFields = document.querySelectorAll('.text-danger');
    errorFields.forEach(field => field.textContent = '');

    // Validación de cédula
    if (credencialId === '') {
        document.getElementById('errorCredencialId').textContent = 'La cédula es obligatoria.';
        esValido = false;
    }

    // Validación de nombre
    if (nombre === '') {
        document.getElementById('errorNombre').textContent = 'El nombre es obligatorio.';
        esValido = false;
    }

    // Validación de primer apellido
    if (primerApellido === '') {
        document.getElementById('errorPrimerApellido').textContent = 'El primer apellido es obligatorio.';
        esValido = false;
    }

    // Validación de segundo apellido
    if (segundoApellido === '') {
        document.getElementById('errorSegundoApellido').textContent = 'El segundo apellido es obligatorio.';
        esValido = false;
    }

    // Validación de fecha de nacimiento
    if (fechaNacimiento === '') {
        document.getElementById('errorFechaNacimiento').textContent = 'La fecha de nacimiento es obligatoria.';
        esValido = false;
    }

    // Validación de correo electrónico
    if (email === '') {
        document.getElementById('errorEmail').textContent = 'El correo electrónico es obligatorio.';
        esValido = false;
    }

    // Validación de contraseña
    const contrasenaRequisitos = validarContrasena(contrasena);
    document.getElementById('errorContrasena').textContent = contrasenaRequisitos.error;

    // Actualizar color de los requisitos de la contraseña
    actualizarRequisitosContrasena(contrasena);

    // Validación de confirmación de contraseña
    if (contrasena !== confirmarContrasena) {
        document.getElementById('errorConfirmarContrasena').textContent = 'Las contraseñas no coinciden.';
        esValido = false;
    }

    // Validación de número de teléfono
    if (numeroTelefono === '') {
        document.getElementById('errorNumeroTelefono').textContent = 'El número de teléfono es obligatorio.';
        esValido = false;
    }

    // Validación de categoría de teléfono
    if (categoriaTelefonoId === '') {
        document.getElementById('errorCategoriaTelefonoId').textContent = 'La categoría de teléfono es obligatoria.';
        esValido = false;
    }

    // Validación de país
    if (codigoPais === '') {
        document.getElementById('errorCodigoPais').textContent = 'El país es obligatorio.';
        esValido = false;
    }

    // Validación de estado
    if (codigoEstado === '') {
        document.getElementById('errorCodigoEstado').textContent = 'El estado es obligatorio.';
        esValido = false;
    }

    // Validación de condado
    if (codigoCondado === '') {
        document.getElementById('errorCodigoCondado').textContent = 'El condado es obligatorio.';
        esValido = false;
    }

    // Validación de distrito
    if (codigoDistrito === '') {
        document.getElementById('errorCodigoDistrito').textContent = 'El distrito es obligatorio.';
        esValido = false;
    }

    // Validación de descripción de dirección
    if (descripcionDireccion === '') {
        document.getElementById('errorDescripcionDireccion').textContent = 'La descripción de la dirección es obligatoria.';
        esValido = false;
    }

    if (esValido) {
        // Hacer el llamado AJAX si el formulario es válido
        $.ajax({
            url: 'UserRegisterController', // URL del servlet
            type: 'POST',
            data: {
                credencialId: credencialId,
                nombre: nombre,
                primerApellido: primerApellido,
                segundoApellido: segundoApellido,
                fechaNacimiento: fechaNacimiento,
                email: email,
                contrasena: contrasena,
                numeroTelefono: numeroTelefono,
                categoriaTelefonoId: categoriaTelefonoId,
                numeroExtension: numeroExtension,
                descripcionTelefono: descripcionTelefono,
                codigoPais: codigoPais,
                codigoEstado: codigoEstado,
                codigoCondado: codigoCondado,
                codigoDistrito: codigoDistrito,
                descripcionDireccion: descripcionDireccion
            },
            success: function(response) {
                // Manejar la respuesta del servidor aquí
                console.log('Usuario registrado exitosamente.');
                // Puedes redirigir a otra página o mostrar un mensaje de éxito
                alert('Registro exitoso.');
                $('#registroModal').modal('hide'); // Cerrar el modal
            },
            error: function(xhr, status, error) {
                // Manejar errores aquí
                console.error('Error al registrar el usuario:', error);
                alert('Hubo un error al registrar el usuario.');
            }
        });
    }

    return esValido;
}

/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 *  Función para validar la contraseña y retornar los requisitos cumplidos
 * @param {type} contrasena
 * @returns {validarContrasena.RegistroAnonym$1}
 */
function validarContrasena(contrasena) {
    const requisitos = {
        mayuscula: /[A-Z]/.test(contrasena),
        digitos: /\d.*\d/.test(contrasena),
        especial: /[!@#$%^&*(),.?":{}|<>]/.test(contrasena),
        longitud: contrasena.length >= 6
    };

    let error = '';

    if (!requisitos.longitud) {
        error = 'La contraseña debe tener al menos 6 caracteres.';
    } else if (!requisitos.mayuscula) {
        error = 'La contraseña debe contener al menos una letra mayúscula.';
    } else if (!requisitos.digitos) {
        error = 'La contraseña debe contener al menos dos dígitos.';
    } else if (!requisitos.especial) {
        error = 'La contraseña debe contener al menos un carácter especial.';
    }

    return { error };
}

/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 * Función para actualizar los requisitos de la contraseña
 * @param {type} contrasena
 * @returns
 */
function actualizarRequisitosContrasena(contrasena) {
    const requisitos = {
        mayuscula: /[A-Z]/.test(contrasena),
        digitos: /\d.*\d/.test(contrasena),
        especial: /[!@#$%^&*(),.?":{}|<>]/.test(contrasena),
        longitud: contrasena.length >= 6
    };

    document.getElementById('requisitoLongitud').style.color = requisitos.longitud ? 'green' : 'red';
    document.getElementById('requisitoMayuscula').style.color = requisitos.mayuscula ? 'green' : 'red';
    document.getElementById('requisitoDigitos').style.color = requisitos.digitos ? 'green' : 'red';
    document.getElementById('requisitoEspecial').style.color = requisitos.especial ? 'green' : 'red';
}

/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 * Función para manejar la entrada del usuario y capitalizar el primer carácter
 * @param {Event} event
 */
function manejarEntrada(event) {
    const id = event.target.id;

    // Limpiar mensaje de error al escribir en el campo
    const errorLabel = document.getElementById(`error${id.charAt(0).toUpperCase() + id.slice(1)}`);
    if (errorLabel) {
        errorLabel.textContent = '';
    }

    // Si no es el campo de contraseña, capitalizar el primer carácter
    if (id !== 'contraseña' && id !== 'confirmarContraseña') {
        const valor = event.target.value;
        event.target.value = valor.charAt(0).toUpperCase() + valor.slice(1);
    }
}

// Array con los identificadores de los campos del formulario
const campos = [
    'credencialId',
    'nombre',
    'primerApellido',
    'segundoApellido',
    'fechaNacimiento',
    'txtEmail',
    'contraseña',
    'confirmarContraseña',
    'numeroTelefono',
    'categoriaTelefonoId',
    'numeroExtension',
    'descripcionTelefono',
    'codigoPais',
    'codigoEstado',
    'codigoCondado',
    'codigoDistrito',
    'descripcionDireccion'
];

// Añadir el evento de entrada a cada campo
campos.forEach(campo => {
    document.getElementById(campo).addEventListener('input', manejarEntrada);
    if (campo === 'contraseña') {
        document.getElementById(campo).addEventListener('input', function() {
            const contrasena = this.value;
            actualizarRequisitosContrasena(contrasena);
        });
    }
});

// Añadir el evento de validación al enviar el formulario
document.getElementById('registroForm').addEventListener('submit', function(event) {
    if (!validarFormulario()) {
        event.preventDefault(); // Prevenir el envío del formulario si no es válido
    }
});
