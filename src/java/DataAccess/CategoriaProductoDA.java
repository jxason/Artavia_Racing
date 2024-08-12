/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.ICategoriaProductoDA;
import Entities.CategoriaProductoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Class encargada de administrar las categorias de los productos
 */
public class CategoriaProductoDA extends BaseConnectionDA implements ICategoriaProductoDA {
    private static final Logger logger = Logger.getLogger(CountryDA.class.getName());
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda las categorias de los productos
    * @return 
    */
    @Override
    public List<CategoriaProductoDTO> GetAll() {
          List<CategoriaProductoDTO> lista = new ArrayList<>();

        try {
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            callableStatements = connections.prepareCall("{call USP_ObtenerCategoriaProducto(?)}");
            callableStatements.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            callableStatements.execute();

            resultSets = (ResultSet) callableStatements.getObject(1);
            while (resultSets.next()) {
                CategoriaProductoDTO dto = new CategoriaProductoDTO();
                dto.setCodigoCategoriaProducto(resultSets.getInt("CATEGORIAPRODUCTOID"));
                dto.setCategoriaProducto(resultSets.getString("NOMBRE"));
                lista.add(dto);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching countries", e);
        } finally {
            closeResources();
        }

        return lista;
    }    
}
