package DataAccess;

import DataAccessInterface.IProductoDA;
import Entities.ProductoRequestDTO;
import Entities.ProductoResponseDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * AR-004
 * Autor: Andrés Alvarado Matamoros
 * Clase encargada de administrar la información de los productos.
 */
public class ProductoDA extends BaseConnectionDA implements IProductoDA {

    /**
     * AR-005
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de guardar un nuevo producto en la base de datos.
     * @param producto ProductoRequestDTO con la información del producto.
     * @return true si el producto fue guardado exitosamente, false si ocurrió un error.
     */
    @Override
    public boolean Save(ProductoRequestDTO producto) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_InsertarProducto(?, ?, ?, ?, ?, ?, ?, ?, ?)}");            
            callableStatements.setInt(1, producto.getCategoriaProductoId());
            callableStatements.setString(2, producto.getNombre());
            callableStatements.setString(3, producto.getDescripcion());
            callableStatements.setDouble(4, producto.getPrecioUnitario());
            callableStatements.setInt(5, producto.getCantidad());
            callableStatements.setString(6, producto.getEditadoPor());
            callableStatements.setInt(7, producto.getHabilitado());
            callableStatements.setDate(8, new java.sql.Date(producto.getFechaCreacion().getTime()));
            callableStatements.setBytes(9, producto.getImagen());
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

    /**
     * AR-006
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de obtener un producto por su ID.
     * @param productoId ID del producto.
     * @return ProductoResponseDTO con la información del producto, o null si no se encuentra.
     */
    @Override
    public ProductoResponseDTO Get(int productoId) {
        ProductoResponseDTO producto = null;

        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_ObtenerProducto(?, ?)}");
            callableStatements.setInt(1, productoId);
            callableStatements.registerOutParameter(2, java.sql.Types.REF_CURSOR);
            callableStatements.execute();

            try (ResultSet resultSet = (ResultSet) callableStatements.getObject(2)) {
                if (resultSet.next()) {
                    producto = mapToProductoResponseDTO(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return producto;
    }

    /**
     * AR-007
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de obtener todos los productos.
     * @return Lista de ProductoResponseDTO con la información de todos los productos.
     */
    @Override
    public List<ProductoResponseDTO> GetAll() {
        List<ProductoResponseDTO> lista = new ArrayList<>();

        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_ObtenerTodosProductos(?)}");
            callableStatements.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            callableStatements.execute();

            try (ResultSet resultSet = (ResultSet) callableStatements.getObject(1)) {
                while (resultSet.next()) {
                    lista.add(mapToProductoResponseDTO(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return lista;
    }

    /**
     * AR-008
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de actualizar un producto existente en la base de datos.
     * @param producto ProductoRequestDTO con la información del producto.
     * @return true si el producto fue actualizado exitosamente, false si ocurrió un error.
     */
    @Override
    public boolean Update(ProductoRequestDTO producto) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_ActualizarProducto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callableStatements.setInt(1, producto.getProductoId());
            callableStatements.setInt(2, producto.getCategoriaProductoId());
            callableStatements.setString(3, producto.getNombre());
            callableStatements.setString(4, producto.getDescripcion());
            callableStatements.setDouble(5, producto.getPrecioUnitario());
            callableStatements.setInt(6, producto.getCantidad());
            callableStatements.setString(7, producto.getEditadoPor());
            callableStatements.setInt(8, producto.getHabilitado());
            callableStatements.setDate(9, new java.sql.Date(producto.getFechaCreacion().getTime()));
            callableStatements.setBytes(10, producto.getImagen());
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

    /**
     * AR-009
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de eliminar un producto por su ID.
     * @param productoId ID del producto a eliminar.
     * @return true si el producto fue eliminado exitosamente, false si ocurrió un error.
     */
    @Override
    public boolean Delete(int productoId) {
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_EliminarProducto(?)}");
            callableStatements.setInt(1, productoId);
            callableStatements.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

    /**
     * AR-004
     * Autor: Andrés Alvarado Matamoros
     * Método privado para mapear un ResultSet a un ProductoResponseDTO.
     * @param rs ResultSet
     * @return ProductoResponseDTO
     * @throws SQLException si ocurre un error en la base de datos.
     */
    private ProductoResponseDTO mapToProductoResponseDTO(ResultSet rs) throws SQLException {
    ProductoResponseDTO producto = new ProductoResponseDTO();
    producto.setProductoId(rs.getInt("PRODUCTOID"));
    producto.setCategoriaProductoId(rs.getInt("CATEGORIAPRODUCTOID"));
    producto.setNombre(rs.getString("NOMBRE"));
    producto.setDescripcion(rs.getString("DESCRIPCION"));
    producto.setPrecioUnitario(rs.getDouble("PRECIOUNITARIO"));
    producto.setCantidad(rs.getInt("CANTIDAD"));
    producto.setEditadoPor(rs.getString("EDITADOPOR"));
    producto.setHabilitado(rs.getInt("HABILITADO"));
    producto.setFechaCreacion(rs.getDate("FECHACREACION"));

    byte[] imagenBytes = rs.getBytes("IMAGEN");
    if (imagenBytes != null) {
        String imagenBase64 = Base64.getEncoder().encodeToString(imagenBytes);
        producto.setImagen(imagenBase64);
    } else {
        producto.setImagen(null);
    }

    return producto;
}
}
