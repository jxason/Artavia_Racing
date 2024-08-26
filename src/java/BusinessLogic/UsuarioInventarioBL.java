/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IUsuarioInventarioBL;
import DataAccess.GaleriaProductoDA;
import DataAccess.UsuarioInventarioDA;
import DataAccessInterface.IGaleriaProductoDA;
import DataAccessInterface.IUsuarioInventarioDA;
import Entities.InventarioProductosDTO;
import Entities.ProductosImagenesDTO;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author fidelitas
 */
public class UsuarioInventarioBL implements IUsuarioInventarioBL{
    IUsuarioInventarioDA usuarioInventarioDA;
    IGaleriaProductoDA galeriaProductoDA;
    public UsuarioInventarioBL()
    {
        usuarioInventarioDA= new UsuarioInventarioDA();
        galeriaProductoDA = new GaleriaProductoDA();
    }
   /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener el html del inventario que estará viendo el usuario. 
    * @return retorna un html con el menu  del inventario que estará viendo el usuario. 
    */
    @Override
    public InventarioProductosDTO Get() {
        // Asignar el valor devuelto por el método
        InventarioProductosDTO responseInventarioProductos = usuarioInventarioDA.Get();

        // Verificar si el HTML no es nulo y no está vacío después de recortar espacios en blanco
        String htmlInventario = responseInventarioProductos.getHtmlInventarioProductos();
        if (htmlInventario != null && !htmlInventario.trim().isEmpty()) {
            // Obtener la lista de productos con imágenes
            List<ProductosImagenesDTO> productList = galeriaProductoDA.GetAll();

            // Verificar si la lista no es nula y tiene al menos un elemento
            if (productList != null && !productList.isEmpty()) {
                // Reemplazar los placeholders con las imágenes
                for (ProductosImagenesDTO producto : productList) {
                    htmlInventario = htmlInventario.replaceAll(
                        Pattern.quote(producto.getPlaceHolderName()), 
                        producto.getImagen()
                    );
                }                
                // Actualizar el HTML en la respuesta
                responseInventarioProductos.setHtmlInventarioProductos(htmlInventario);
            }
        }

        return responseInventarioProductos;
    }

    
}
