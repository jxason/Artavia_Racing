/*
 *  AR-003
 *  @Author: Horacio Porras Marín
 *  Constructor para iniciar las propiedades de una pagina desde js.
 * @returns {Boolean}
 */
$(document).ready(function () {
    cargarCategoriaServicio();

    $('#codigoCategoriaServicio').change(function () {
        cargarServicio($(this).val()); // Llamar a la función para cargar servicios
    });

    cargarVehiculo();
});

/*
 *  AR-003
 *  @Author: Horacio Porras Marín
 *  Función para cargar la lista de categorias de servicio desde el servidor
 */
function cargarCategoriaServicio() {
    $.ajax({
        url: '/Artavia_Racing/CategoriaServicioController',
        type: 'GET',
        data: {action: 'getCategoriasServicio'},
        success: function (response) {
            const categoriaSelect = document.getElementById('codigoCategoriaServicio');
            categoriaSelect.innerHTML = ''; // Limpiar el contenido existente

            // Agregar opción por defecto
            const defaultOption = document.createElement('option');
            defaultOption.value = '';
            defaultOption.textContent = 'Seleccione una categoria';
            defaultOption.disabled = true; // La opción no será seleccionable
            defaultOption.hidden = true;   // La opción no será visible en el dropdown
            defaultOption.selected = true; // Esta opción aparece seleccionada por defecto
            categoriaSelect.appendChild(defaultOption);

            // Agregar nuevas opciones
            response.forEach(function (categoria) {
                const option = document.createElement('option');
                option.value = categoria.CodigoCategoriaServicio;
                option.textContent = categoria.CategoriaServicio;
                categoriaSelect.appendChild(option);
            });
        },
        error: function (xhr, status, error) {
            console.error('Error al cargar las categorias:', error);
            alert('Hubo un error al cargar la lista de categorias.');
        }
    });
}

/*
 *  AR-003
 *  @Author: Horacio Porras Marín
 *  Función para cargar la lista de servicios desde el servidor
 */
function cargarServicio(codigoCategoriaServicio) {
    $.ajax({
        url: '/Artavia_Racing/CategoriaServicioController',
        type: 'GET',
        data: {action: 'getServicios', codigoCategoriaServicio: codigoCategoriaServicio},
        success: function (response) {
            const servicioSelect = document.getElementById('codigoServicio');
            servicioSelect.innerHTML = ''; // Limpiar el contenido existente

            // Agregar opción por defecto
            const defaultOption = document.createElement('option');
            defaultOption.value = '';
            defaultOption.textContent = 'Seleccione un servicio';
            defaultOption.disabled = true; // La opción no será seleccionable
            defaultOption.hidden = true;   // La opción no será visible en el dropdown
            defaultOption.selected = true; // Esta opción aparece seleccionada por defecto
            servicioSelect.appendChild(defaultOption);

            // Agregar nuevas opciones
            response.forEach(function (servicio) {
                const option = document.createElement('option');
                option.value = servicio.CodigoServicio;
                option.textContent = servicio.NombreServicio;
                servicioSelect.appendChild(option);
            });
        },
        error: function (xhr, status, error) {
            console.error('Error al cargar los servicios:', error);
            alert('Hubo un error al cargar la lista de servicios.');
        }
    });
}

/*
 *  AR-003
 *  @Author: Horacio Porras Marín
 *  Función para cargar la lista de vehiculos desde el servidor
 */
function cargarVehiculo() {
    $.ajax({
        url: '/Artavia_Racing/VehiculoPorClienteController',
        type: 'GET',
        data: {action: 'getVehiculos'},
        success: function (response) {
            const vehiculoSelect = document.getElementById('codigoVehiculo');
            vehiculoSelect.innerHTML = ''; // Limpiar el contenido existente

            // Agregar opción por defecto
            const defaultOption = document.createElement('option');
            defaultOption.value = '';
            defaultOption.textContent = 'Seleccione un vehiculo';
            defaultOption.disabled = true; // La opción no será seleccionable
            defaultOption.hidden = true;   // La opción no será visible en el dropdown
            defaultOption.selected = true; // Esta opción aparece seleccionada por defecto
            vehiculoSelect.appendChild(defaultOption);

            // Agregar nuevas opciones
            response.forEach(function (vehiculo) {
                const option = document.createElement('option');
                option.value = vehiculo.CodigoVehiculo;
                option.textContent = vehiculo.NombreVehiculo;
                vehiculoSelect.appendChild(option);
            });
        },
        error: function (xhr, status, error) {
            console.error('Error al cargar los vehiculos:', error);
            alert('Hubo un error al cargar la lista de vehiculos.');
        }
    });
}

/*
 *  AR-009
 *  Autor: Horacio Porras Marin
 *  Función para validar el formulario antes de enviarlo al servlet
 * @returns {Boolean}
 */
function validarFormulario() {
    let esValido = true;

    // Obtener los valores de los campos del formulario
    const placaVehiculoId = document.getElementById('codigoVehiculo').value;
    const servicioId = document.getElementById('codigoServicio').value;
    const descripcion = document.getElementById('descripcion').value.trim();

    // Limpiar mensajes de error
    const errorFields = document.querySelectorAll('.text-danger');
    errorFields.forEach(field => field.textContent = '');

    // Validación de vehiculo
    if (placaVehiculoId === '') {
        document.getElementById('errorPlacaVehiculoId').textContent = 'El vehiculo es obligatorio.';
        esValido = false;
    }

    // Validación de servicio
    if (servicioId === '') {
        document.getElementById('errorServicioId').textContent = 'El servicio es obligatorio.';
        esValido = false;
    }

    // Validación de descripcion
    if (descripcion === '') {
        document.getElementById('errorDescripcion').textContent = 'Por favor ingrese una breve descripcion.';
        esValido = false;
    }

    if (esValido) {
        // Hacer el llamado AJAX si el formulario es válido
        $.ajax({
            url: '/Artavia_Racing/CitaController', // URL del servlet
            type: 'POST',
            async: false, // Esto hace que la llamada sea sincrónica
            data: {
                placaVehiculoId: placaVehiculoId,
                servicioId: servicioId,
                descripcion: descripcion
            },
            success: function(response) {
                // Manejar la respuesta del servidor aquí
                console.log('Cita agendada exitosamente.');
                // Puedes redirigir a otra página o mostrar un mensaje de éxito
                alert('Registro exitoso.');
                $('#citaModal').modal('hide'); // Cerrar el modal
            },
            error: function(xhr, status, error) {
                // Manejar errores aquí
                console.error('Error al registrar la cita:', error);
                alert('Hubo un error al registrar la cita.');
            }
        });
    }

    return esValido;
}

// Añadir el evento de validación al enviar el formulario
document.getElementById('citaForm').addEventListener('submit', function(event) {
    if (!validarFormulario()) {
        event.preventDefault(); // Prevenir el envío del formulario si no es válido
    }
});
