/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.IGaleriaProductoDA;
import Entities.ProductosImagenesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

 
/**
 * AR-001
 * Autor: Andrés Alvarado Matamoros
 * Clase encargada de administrar la información de las imagenes del inventario de productos.
 */
public class GaleriaProductoDA extends BaseConnectionDA implements IGaleriaProductoDA {
  /**
     * AR-001
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de obtener todas las images del inventario de los productos.
     * @return Lista de ProductosImagenesDTO con la información de  las images del inventario de los productos.
     */  
    @Override
    public List<ProductosImagenesDTO> GetAll() {
     List<ProductosImagenesDTO> lista = new ArrayList<>();

        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call SP_Obtener_Imagenes_Activas(?)}");
            callableStatements.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
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
     * AR-004
     * Autor: Andrés Alvarado Matamoros
     * Método privado para mapear un ResultSet a un ProductoResponseDTO.
     * @param rs ResultSet
     * @return ProductoResponseDTO
     * @throws SQLException si ocurre un error en la base de datos.
     */
    private ProductosImagenesDTO mapToProductoResponseDTO(ResultSet rs) throws SQLException 
    {
        ProductosImagenesDTO producto = new ProductosImagenesDTO();
        producto.setPlaceHolderName(rs.getString("PlaceHolderName"));
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
