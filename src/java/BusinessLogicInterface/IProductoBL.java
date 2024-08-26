package BusinessLogic;

import Entities.ProductoRequestDTO;
import Entities.ProductoResponseDTO;
import java.util.List;

/**
 * AR-010
 * Autor: Andrés Alvarado Matamoros
 * Interfaz que define las operaciones de negocio para gestionar productos.
 */
public interface IProductoBL {

    /**
     * AR-011
     * Autor: Andrés Alvarado Matamoros
     * Método para guardar un nuevo producto.
     * @param producto ProductoRequestDTO con la información del producto.
     */
    boolean Save(ProductoRequestDTO producto);

    /**
     * AR-012
     * Autor: Andrés Alvarado Matamoros
     * Método para obtener un producto por su ID.
     * @param productoId ID del producto.
     * @return ProductoResponseDTO con la información del producto.
     */
    ProductoResponseDTO Get(int productoId);

    /**
     * AR-013
     * Autor: Andrés Alvarado Matamoros
     * Método para obtener todos los productos.
     * @return Lista de ProductoResponseDTO con la información de todos los productos.
     */
    List<ProductoResponseDTO> GetAll();

    /**
     * AR-014
     * Autor: Andrés Alvarado Matamoros
     * Método para actualizar un producto existente.
     * @param producto ProductoRequestDTO con la información del producto.
     */
    boolean Update(ProductoRequestDTO producto);

    /**
     * AR-015
     * Autor: Andrés Alvarado Matamoros
     * Método para eliminar un producto por su ID.
     * @param productoId ID del producto a eliminar.
     */
    boolean Delete(int productoId);
}
