/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessInterface;

import Entities.ProductoRequestDTO;
import Entities.ProductoResponseDTO;
import java.util.List;

 

/**
 * AR-007
 * Author: Andrés Alvarado Matamoros
 * Interfaz encargada de definir los métodos de acceso a datos para la tabla PRODUCTO.
 */
public interface IProductoDA {

    /**
     * AR-008
     * Author: Andrés Alvarado Matamoros
     * Metodo encargado de guardar un producto en la base de datos.
     * @param producto ProductoRequestDTO
     */
     boolean Save(ProductoRequestDTO producto);

    /**
     * AR-009
     * Author: Andrés Alvarado Matamoros
     * Metodo encargado de obtener un producto por su ID.
     * @param productoId int
     * @return ProductoResponseDTO
     */
    ProductoResponseDTO Get(int productoId);

    /**
     * AR-010
     * Author: Andrés Alvarado Matamoros
     * Metodo encargado de obtener todos los productos.
     * @return List<ProductoResponseDTO>
     */
    List<ProductoResponseDTO> GetAll();

    /**
     * AR-011
     * Author: Andrés Alvarado Matamoros
     * Metodo encargado de actualizar un producto.
     * @param producto ProductoRequestDTO
     */
    boolean Update(ProductoRequestDTO producto);

    /**
     * AR-012
     * Author: Andrés Alvarado Matamoros
     * Metodo encargado de eliminar un producto por su ID.
     * @param productoId int
     */
    boolean Delete(int productoId);
}