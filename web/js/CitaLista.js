/*
 *  AR-009
 *  @Author: Horacio Porras Marín
 *  Constructor para iniciar las propiedades de una pagina desde js.
 * @returns {Boolean}
 */
$(document).ready(function () {
    function cargarCitas() {
        $.ajax({
            url: "/Artavia_Racing/CitaPorUsuarioController",
            type: "GET",
            data: {action: 'getCitas'},
            success: function (data) {
                var tbody = $('#tablaCitas tbody');
                tbody.empty(); // Limpiar los datos antiguos
                data.forEach(function (cita) {
                    // Crear un objeto Date con la fecha recibida
                    var fechaAgendada = new Date(cita.FechaAgendada);
                    // Formatear la fecha a formato local sin la hora
                    var formattedDate = fechaAgendada.toLocaleDateString('es-ES');
                    tbody.append(
                            '<tr>' +
                            '<td>' + cita.PlacaVehiculo + '</td>' +
                            '<td>' + cita.NombreVehiculo + '</td>' +
                            '<td>' + cita.NombreCategoria + '</td>' +
                            '<td>' + cita.NombreServicio + '</td>' +
                            '<td>' + formattedDate + '</td>' +
                            '<td>' + cita.HoraAgendada + '</td>' +
                            '<td>' + cita.EstadoCita + '</td>' +
                            '</tr>'
                            );
                });
            },
            error: function () {
                alert('Error al cargar las citas');
            }
        });
    }
    cargarCitas(); // Llamar a la función al cargar la página
});