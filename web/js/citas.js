
/*
 *  AR-001
 *  Autor: Luis Fernando Solorzano Campos
 *  Constructor para iniciar las propiedades de una pagina desde js.
 * @returns {Boolean}
 */


$(document).ready(function() {
    $('#citasTable').DataTable({
        "ajax": {
            "url": "/Artavia_Racing/AdminCitaController?method=getAll",
            "dataSrc": "citas"
        },
        "columns": [
            { "data": "citaId" },
            { "data": "fechaAgendada" },
            { "data": "horaAgendada" },
            { "data": "credencialId" },
            { "data": "servicioId" },
            { "data": "estadoCitaId" },
            {
                "data": null,
                "render": function(data, type, row) {
                    return `
                        <button onclick="editCita(${row.citaId})">Editar</button>
                        <button onclick="deleteCita(${row.citaId})">Eliminar</button>
                    `;
                }
            }
        ]
    });

    // Manejo del botón guardar
    $('#btnGuardarCita').on('click', function() {
        const citaId = $('#citaId').val();
        const fechaAgendada = $('#fecha').val();
        const horaAgendada = $('#hora').val();
        const credencialId = $('#cliente').val();
        const servicioId = $('#servicio').val();
        const estadoCitaId = $('#estado').val();
        const descripcion = $('#descripcion').val(); // Si tienes un campo de descripción

        const formData = {
            citaId: citaId,
            fechaAgendada: fechaAgendada,
            horaAgendada: horaAgendada,
            credencialId: credencialId,
            servicioId: servicioId,
            estadoCitaId: estadoCitaId,
            descripcion: descripcion
        };

        const url = citaId ? '/Artavia_Racing/AdminCitaController?method=update' : '/Artavia_Racing/AdminCitaController?method=save';
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Cita guardada exitosamente.');
                $('#citasTable').DataTable().ajax.reload();
                clearFormCita();
            } else {
                alert('Error al guardar la cita.');
            }
        })
        .catch(error => console.error('Error:', error));
    });
});

// Editar una cita
function editCita(citaId) {
    fetch(`/Artavia_Racing/AdminCitaController?method=get&citaId=${citaId}`)
        .then(response => response.json())
        .then(data => {
            $('#citaId').val(data.citaId);
            $('#fecha').val(data.fechaAgendada);
            $('#hora').val(data.horaAgendada);
            $('#cliente').val(data.credencialId);
            $('#servicio').val(data.servicioId);
            $('#estado').val(data.estadoCitaId);
            $('#descripcion').val(data.descripcion); // Si tienes un campo de descripción
        })
        .catch(error => console.error('Error:', error));
}

// Eliminar una cita
function deleteCita(citaId) {
    fetch(`/Artavia_Racing/AdminCitaController?method=delete&citaId=${citaId}`, {
        method: 'POST'
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Cita eliminada exitosamente.');
            $('#citasTable').DataTable().ajax.reload();
        } else {
            alert('Error al eliminar la cita.');
        }
    })
    .catch(error => console.error('Error:', error));
}

// Limpiar el formulario de citas
function clearFormCita() {
    $('#citaId').val('');
    $('#fecha').val('');
    $('#hora').val('');
    $('#cliente').val('');
    $('#servicio').val('');
    $('#estado').val('');
    $('#descripcion').val(''); // Si tienes un campo de descripción
}