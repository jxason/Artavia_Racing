/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 *  Constructor para iniciar las propiedades de una pagina desde js.
 * @returns {Boolean}
 */
$(document).ready(function() {
    CargarInventario();
    // Manejar clic en los botones de categoría
    $(document).on('click', '.filter-button', function() {
        var category = $(this).attr('data-category');
        
        if (category == 'all') {
            $('.product-card').show();  // Muestra todos los productos
        } else {
            $('.product-card').hide();  // Oculta todos los productos
            $('.product-card[data-category="' + category + '"]').show();  // Muestra solo los productos de la categoría seleccionada
        }
    });
});

/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 *  Función para cargar el inventario.
 */
function CargarInventario() {
    $.ajax({
        url: '/Artavia_Racing/UsuarioInventarioController?method=get',
        type: 'GET',
        data: { action: 'get' },
        success: function(response) {
            // Verificar si HtmlInventarioProductos no está vacío ni es null
            if (response.HtmlInventarioProductos && response.HtmlInventarioProductos.trim().length > 0) {
                // Reemplazar el marcador [inventario] con el HTML del inventario
                $('#inventario-container').html(response.HtmlInventarioProductos);
            } else {
                console.warn('No se recibió un HTML de inventario válido.');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar el inventario:', error);
            alert('Hubo un error al cargar el inventario.');
        }
    });
}