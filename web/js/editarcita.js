
/*
 *  AR-001
 *  Autor: Luis Fernando Solorzano Campos
 *  Constructor para iniciar las propiedades de una pagina desde js.
 * @returns {Boolean}
 */


$(document).ready(function() {
    // Obtener el ID de la cita de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const citaId = urlParams.get('id');
    
    if (citaId) {
        // Solicitar información de la cita al servidor
        $.ajax({
            url: '/Artavia_Racing/EditarCitaController',
            method: 'GET',
            data: {
                action: 'get',
                id: citaId
            },
            dataType: 'json',
            success: function(data) {
                // Llenar los campos del formulario con la información de la cita
                $('#credencialId').val(data.CredencialId || '');
                $('#placaVehiculoId').val(data.PlacaVehiculoId || '');
                $('#vin').val(data.VIN || '');
                $('#servicioId').val(data.ServicioId || '');
                $('#estadoCitaId').val(data.EstadoCitaId || '');
                $('#descripcion').val(data.Descripcion || '');
                $('#horaAgendada').val(data.HoraAgendada || '');
                
                  // Convertir el string de fecha a un objeto Date
                var fechaString = data.FechaAgendada;

                // Mapeo de meses en español a su número correspondiente
                var meses = {
                    "ene": "01",
                    "feb": "02",
                    "mar": "03",
                    "abr": "04",
                    "may": "05",
                    "jun": "06",
                    "jul": "07",
                    "ago": "08",
                    "sep": "09",
                    "oct": "10",
                    "nov": "11",
                    "dic": "12"
                };

                // Extraer partes de la fecha
                var partes = fechaString.split(' ');
                var mes = meses[partes[0]];  // Convertir el mes a número
                var dia = partes[1].replace(',', '');  // Eliminar coma del día
                var año = partes[2];  // Obtener el año

                // Formatear la fecha a 'YYYY-MM-DD'
                var fechaFormateada = `${año}-${mes}-${dia.padStart(2, '0')}`;  // Asegurarse que el día tenga dos dígitos

                // Asignar la fecha formateada al input de tipo date
                document.getElementById('fechaAgendada').value = fechaFormateada;
                
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener la información de la cita:', error);
                toastr.error('Error al cargar la información de la cita.');
            }
        });
    }

    $('#editCitaForm').on('submit', function(event) {
        event.preventDefault();
        const formData = $(this).serialize();
        formData += '&action=update';

        $.ajax({
            url: '/EditarCitaController',
            method: 'POST',
            data: formData,
            dataType: 'json',
            success: function(data) {
                if (data.success) {
                    toastr.success('Cita actualizada con éxito');
                    window.location.href = 'listarCitas.jsp';
                } else {
                    toastr.error('Error al actualizar la cita');
                }
            },
            error: function(xhr, status, error) {
                console.error('Error al actualizar la cita:', error);
                toastr.error('Error al actualizar la cita.');
            }
        });
    });

    $('#deleteCita').on('click', function() {
        if (confirm('¿Está seguro de que desea eliminar esta cita?')) {
            $.ajax({
                url: '/EditarCitaController',
                method: 'POST',
                data: {
                    action: 'delete',
                    citaId: $('#citaId').val()
                },
                dataType: 'json',
                success: function(data) {
                    if (data.success) {
                        toastr.success('Cita eliminada con éxito');
                        window.location.href = 'listarCitas.jsp';
                    } else {
                        toastr.error('Error al eliminar la cita');
                    }
                },
                error: function(xhr, status, error) {
                    console.error('Error al eliminar la cita:', error);
                    toastr.error('Error al eliminar la cita.');
                }
            });
        }
    });
});