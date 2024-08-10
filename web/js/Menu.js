/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 *  Constructor para iniciar las propiedades de una pagina desde js.
 * @returns {Boolean}
 */
$(document).ready(function() {
    CargarMenuPorRol();
});
/*
 *  AR-001
 *  Autor: José Andrés Alvarado Matamoros 
 *  Función para cargar la lista de tipos de telefonos desde el servidor
 */
function CargarMenuPorRol() {
    $.ajax({
        url: '/Artavia_Racing/MenuController',
        type: 'GET',        
        data: { action: 'getMenu' },
        async: false, // Esto hace que la llamada sea sincrónica
        success: function(response) {
           // Verificar si HtmlMenu no está vacío ni es null
            if (response.HtmlMenu && response.HtmlMenu.trim().length > 0) {
                // Reemplazar el marcador [Menu] con el HTML del menú
                $('body').html($('body').html().replace('[Menu]', response.HtmlMenu));
            } else {
                console.warn('No se recibió un HTML de menú válido.');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar el menú:', error);
            alert('Hubo un error al cargar el menú.');
        }
    });
}
