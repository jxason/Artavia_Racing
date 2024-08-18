/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.ProductosImagenesDTO;
import java.util.List;

/**
 * AR-001
 * Autor: Andrés Alvarado Matamoros
 * Clase encargada de administrar la información de las imagenes del inventario de productos.
 */
public interface IGaleriaProductoDA {
     /**
     * AR-001
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de obtener todas las images del inventario de los productos.
     * @return Lista de ProductosImagenesDTO con la información de  las images del inventario de los productos.
     */    
    List<ProductosImagenesDTO> GetAll();
}
