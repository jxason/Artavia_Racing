$(document).ready(function() {
    cargarCategoriaProductos();
});
/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 *  Función para cargar la lista de categorias por  producto.
 */
function cargarCategoriaProductos() 
{
    $.ajax({
        url: '/Artavia_Racing/CategoriaProductoController',
        type: 'GET',
        data: { action: 'getCategoriasProducto' },
        success: function(response) {
            const categoriaSelect = document.getElementById('codigoCategoriaProducto');
            categoriaSelect.innerHTML = ''; // Limpiar el contenido existente

            // Agregar opción por defecto
            const defaultOption = document.createElement('option');
            defaultOption.value = '';
            defaultOption.textContent = 'Seleccione una categoria.';
            categoriaSelect.appendChild(defaultOption);

            // Agregar nuevas opciones
            response.forEach(function(categoria) {
                const option = document.createElement('option');
                option.value = categoria.CodigoCategoriaProducto; 
                option.textContent = categoria.CategoriaProducto;
                categoriaSelect.appendChild(option);
            });
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar las categorias:', error);
            alert('Hubo un error al cargar la lista de categorias.');
        }
    });
}