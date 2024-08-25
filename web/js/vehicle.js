$(document).ready(function() {
    // Inicializar DataTables
    $('#vehicleTable').DataTable({
        "ajax": {
            "url": "/Artavia_Racing/VehicleController?method=getAll",
            "dataSrc": "vehicles"
        },
        "columns": [
            { "data": "placaVehiculoID" },
            { "data": "vin" },
            { "data": "marca" },
            { "data": "modelo" },
            { "data": "ano" },
            { "data": "color" },
            { "data": "alDia" },
            {
                "data": "tituloPropiedad",
                "render": function(data) {
                    if (data) {
                        return `<img src="data:image/jpeg;base64,${data}" width="100" height="100" alt="Imagen">`;
                    }
                    return '<p>No disponible</p>';
                }
            },
            {
                "data": null,
                "render": function(data, type, row) {
                    return `
                        <button onclick="editVehicle('${row.placaVehiculoID}')">Editar</button>
                        <button onclick="deleteVehicle('${row.placaVehiculoID}')">Eliminar</button>
                    `;
                }
            }
        ]
    });

    // Manejo del botón guardar
    $('#btnGuardar').on('click', function() {
        const placaVehiculoID = $('#placaVehiculoID').val().trim();
        const vin = $('#vin').val().trim();
        const marca = $('#marca').val().trim();
        const modelo = $('#modelo').val().trim();
        const ano = parseInt($('#ano').val(), 10);
        const color = $('#color').val().trim();
        const alDia = $('#alDia').val();
        const tituloPropiedadFile = $('#tituloPropiedad')[0].files[0];
        const isEditMode = $('#editMode').val() === 'true'; // Verificar el flag de edición

        // Verificar si todos los campos requeridos están presentes
        if (!placaVehiculoID || !vin || !marca || !modelo || !ano || !color || alDia === null) {
            alert('Por favor complete todos los campos obligatorios.');
            return;
        }

        const formData = new FormData();
        formData.append('placaVehiculoID', placaVehiculoID);
        formData.append('vin', vin);
        formData.append('marca', marca);
        formData.append('modelo', modelo);
        formData.append('ano', ano);
        formData.append('color', color);
        formData.append('alDia', alDia);
        if (tituloPropiedadFile) {
            formData.append('tituloPropiedad', tituloPropiedadFile);
        }
        formData.append('editMode', isEditMode);
       
        const url = isEditMode ? '/Artavia_Racing/VehicleController?method=update' : '/Artavia_Racing/VehicleController?method=save';
        fetch(url, {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Vehiculo guardado exitosamente.');
                $('#vehicleTable').DataTable().ajax.reload();                
                clearForm(); // Limpiar el formulario
                $('#editMode').val('false'); // Resetear el flag de edición
            } else {
                alert('Error al guardar el producto.');
            }
        })
        .catch(error => console.error('Error:', error));
    });
});

// Función para editar un vehículo
function editVehicle(placaVehiculoID) {
   fetch(`/Artavia_Racing/VehicleController?method=get&placaVehiculoID=${placaVehiculoID}`)
    .then(response => response.json())
    .then(data => {

        $('#placaVehiculoID').val(data.placaVehiculoID);
        $('#vin').val(data.vin);
        $('#marca').val(data.marca);
        $('#modelo').val(data.modelo);
        $('#ano').val(data.ano);
        $('#color').val(data.color);
        $('#alDia').val(data.alDia);
        $('#editMode').val('true'); // Establecer el flag de edición
    })
    .catch(error => console.error('Error:', error));
}

// Función para eliminar un vehículo
function deleteVehicle(placaVehiculoID) {
    fetch(`/Artavia_Racing/VehicleController?method=delete&placaVehiculoID=${placaVehiculoID}`, {
        method: 'POST'
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Vehiculo eliminado exitosamente.');
            $('#vehicleTable').DataTable().ajax.reload();
        } else {
            alert('Error al eliminar el vehiculo.');
        }
    })
    .catch(error => console.error('Error:', error));
}

// Limpiar el formulario
function clearForm() {
    $('#placaVehiculoID').val('');
    $('#vin').val('');
    $('#marca').val('');
    $('#modelo').val('');
    $('#ano').val('');
    $('#color').val('');
    $('#alDia').val('');
    $('#tituloPropiedad').val(''); // Limpia el archivo de imagen
}
