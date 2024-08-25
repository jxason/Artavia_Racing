
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
                
                 // Hacer que los campos sean readonly
                $('#credencialId').prop('readonly', true);
                $('#placaVehiculoId').prop('readonly', true);
                $('#vin').prop('readonly', true);
                $('#servicioId').prop('readonly', true);
                $('#estadoCitaId').prop('readonly', true);
                $('#descripcion').prop('readonly', true);
                $('#horaAgendada').prop('readonly', true);
                $('#fechaAgendada').prop('readonly', true);
            },
            error: function(xhr, status, error) {
                console.error('Error al obtener la información de la cita:', error);
                toastr.error('Error al cargar la información de la cita.');
            }
        });
    }

    $('#editCitaForm').on('submit', async function(event) {
        event.preventDefault();  // Prevenir la recarga de la página al enviar el formulario

        // Obtener el ID de la cita de la URL
        const urlParams = new URLSearchParams(window.location.search);
        const citaUserId = urlParams.get('id');

        const citaId = citaUserId;
        const descripcion = $('#diagnostico').val().trim();

        const formData = new FormData();        
        formData.append('citaId', citaId);
        formData.append('descripcion', descripcion);

        const url = '/Artavia_Racing/EditarCitaController?method=save';

        try {
            // Esperar a que la respuesta del servidor sea recibida y procesada
            const response = await fetch(url, {
                method: 'POST',
                body: formData
            });

            const data = await response.json();

            // Detener el flujo de ejecución hasta aquí
            if (data.success) {
                alert('Diagnóstico guardado exitosamente.');
                window.location.href = 'citas.jsp';
            } else {
                alert('Error al guardar el diagnóstico.');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Error al intentar guardar el diagnóstico.');
        }

        // El flujo de código no continuará más allá de este punto hasta recibir y procesar la respuesta
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
                        window.location.href = 'citas.jsp';
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