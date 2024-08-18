package BusinessLogic;

import DataAccess.ProductoDA;
import DataAccessInterface.IProductoDA;
import Entities.ProductoRequestDTO;
import Entities.ProductoResponseDTO;
import java.util.List;

/**
 * AR-010
 * Autor: Andrés Alvarado Matamoros
 * Clase encargada de implementar la lógica de negocio para la gestión de productos.
 */
public class ProductoBL implements IProductoBL {

    private final IProductoDA productoDA;

    /**
     * AR-011
     * Autor: Andrés Alvarado Matamoros
     * Constructor que inicializa el acceso a datos de productos.
     */
    public ProductoBL() {
        productoDA = new ProductoDA();
    }

    /**
     * AR-012
     * Autor: Andrés Alvarado Matamoros
     * Implementación del método para guardar un nuevo producto.
     * @param producto ProductoRequestDTO con la información del producto.
     * @return 
     */
    @Override
    public boolean Save(ProductoRequestDTO producto) {
       return productoDA.Save(producto);
    }

    /**
     * AR-013
     * Autor: Andrés Alvarado Matamoros
     * Implementación del método para obtener un producto por su ID.
     * @param productoId ID del producto.
     * @return ProductoResponseDTO con la información del producto.
     */
    @Override
    public ProductoResponseDTO Get(int productoId) {
        return productoDA.Get(productoId);
    }

    /**
     * AR-014
     * Autor: Andrés Alvarado Matamoros
     * Implementación del método para obtener todos los productos.
     * @return Lista de ProductoResponseDTO con la información de todos los productos.
     */
    @Override
    public List<ProductoResponseDTO> GetAll() {
        return productoDA.GetAll();
    }

    /**
     * AR-015
     * Autor: Andrés Alvarado Matamoros
     * Implementación del método para actualizar un producto existente.
     * @param producto ProductoRequestDTO con la información del producto.
     * @return 
     */
    @Override
    public boolean Update(ProductoRequestDTO producto) {
       return productoDA.Update(producto);
    }

    /**
     * AR-016
     * Autor: Andrés Alvarado Matamoros
     * Implementación del método para eliminar un producto por su ID.
     * @param productoId ID del producto a eliminar.
     * @return 
     */
    @Override
    public boolean Delete(int productoId) {
        return productoDA.Delete(productoId);
    }
}
