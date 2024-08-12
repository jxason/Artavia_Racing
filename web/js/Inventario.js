$(document).ready(function() {
    $('#productosTable').DataTable({
        "ajax": {
            "url": "/Artavia_Racing/ProductoController?method=getAll",
            "dataSrc": "products"
        },
        "columns": [
            { "data": "productoId" },
            { "data": "nombre" },
            { "data": "descripcion" },
            { "data": "precioUnitario" },
            { "data": "cantidad" },
            { "data": "editadoPor" },
            { "data": "habilitado" },
            { "data": "fechaCreacion" },
            {
                "data": "imagen",
                "render": function(data, type, row) {
                    // Verifica si la cadena base64 está definida y tiene contenido
                    if (data) {
                        return `<img src="data:image/jpeg;base64,${data}" alt="Imagen" width="50">`;
                    }
                    return '<p>No disponible</p>'; // Mensaje alternativo si 'data' no es válido
                }
            },
            {
                "data": null,
                "render": function(data, type, row) {
                    return `
                        <button onclick="editProduct(${row.productoId})">Editar</button>
                        <button onclick="deleteProduct(${row.productoId})">Eliminar</button>
                    `;
                }
            }
        ]
    });

    // Manejo del botón guardar
    $('#btnGuardar').on('click', function() {
        const productoId = $('#productoId').val();
        const nombre = $('#nombre').val();
        const descripcion = $('#descripcion').val();
        const precioUnitario = parseFloat($('#precioUnitario').val());
        const cantidad = parseInt($('#cantidad').val(), 10);
        const editadoPor = $('#editadoPor').val();
        const habilitado = parseInt($('#habilitado').val(), 10);
        const fechaCreacion = $('#fechaCreacion').val();
        const imagenFile = $('#imagen')[0].files[0];
        const codigoCategoriaProductoId = $('#codigoCategoriaProducto').val();

        const formData = new FormData();
        if (productoId) {
            formData.append('productoId', productoId); // Se asegura de que productoId esté presente
        }
        formData.append('nombre', nombre);
        formData.append('descripcion', descripcion);
        formData.append('precioUnitario', precioUnitario);
        formData.append('cantidad', cantidad);
        formData.append('editadoPor', editadoPor);
        formData.append('habilitado', habilitado);
        formData.append('fechaCreacion', fechaCreacion);
        formData.append('codigoCategoriaProductoId', codigoCategoriaProductoId);
        
        if (imagenFile) {
            formData.append('imagen', imagenFile);
        }

        const url = productoId ? '/Artavia_Racing/ProductoController?method=update' : '/Artavia_Racing/ProductoController?method=save';
        fetch(url, {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Producto guardado exitosamente.');
                $('#productosTable').DataTable().ajax.reload();
                clearForm();
            } else {
                alert('Error al guardar el producto.');
            }
        })
        .catch(error => console.error('Error:', error));
    });
});

// Editar un producto
function editProduct(productoId) {
    fetch(`/Artavia_Racing/ProductoController?method=get&productoId=${productoId}`)
        .then(response => response.json())
        .then(data => {
            $('#productoId').val(data.productoId);
            $('#nombre').val(data.nombre);
            $('#descripcion').val(data.descripcion);
            $('#precioUnitario').val(data.precioUnitario);
            $('#cantidad').val(data.cantidad);
            $('#editadoPor').val(data.editadoPor);
            $('#habilitado').val(data.habilitado);
            $('#fechaCreacion').val(data.fechaCreacion);
            // Carga de imagen aquí si se necesita
        })
        .catch(error => console.error('Error:', error));
}

// Eliminar un producto
function deleteProduct(productoId) {
    fetch(`/Artavia_Racing/ProductoController?method=delete&productoId=${productoId}`, {
        method: 'POST'
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Producto eliminado exitosamente.');
            $('#productosTable').DataTable().ajax.reload();
        } else {
            alert('Error al eliminar el producto.');
        }
    })
    .catch(error => console.error('Error:', error));
}

// Limpiar el formulario
function clearForm() {
    $('#productoId').val('');
    $('#nombre').val('');
    $('#descripcion').val('');
    $('#precioUnitario').val('');
    $('#cantidad').val('');
    $('#editadoPor').val('');
    $('#habilitado').val('1'); // Valor por defecto
    $('#fechaCreacion').val('');
    $('#imagen').val(''); // Limpia el archivo de imagen
}
