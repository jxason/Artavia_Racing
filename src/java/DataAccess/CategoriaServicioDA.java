/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DataAccess;

import DataAccessInterface.ICategoriaServicioDA;
import Entities.CategoriaServicioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AR-003
 * @Author: Horacio Porras Marín 
 * Clase encargada de administrar los servicios
 */
public class CategoriaServicioDA extends BaseConnectionDA implements ICategoriaServicioDA {
    private static final Logger logger = Logger.getLogger(CategoriaServicioDA.class.getName());

    @Override
    public List<CategoriaServicioDTO> GetAll() {
        List<CategoriaServicioDTO> lista = new ArrayList<>();
        try {
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            callableStatements = connections.prepareCall("{call USP_ObtenerCategoriaServicio(?)}");
            callableStatements.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callableStatements.execute();

            resultSets = (ResultSet) callableStatements.getObject(1);
            while (resultSets.next()) {
                CategoriaServicioDTO dto = new CategoriaServicioDTO();
                dto.setCodigoCategoriaServicio(resultSets.getInt("CATEGORIASERVICIOID"));
                dto.setCategoriaServicio(resultSets.getString("NOMBRE"));
                lista.add(dto);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching service categories" + e.getMessage(), e);
        } finally {
            closeResources();
        }
        return lista;
    }

}
