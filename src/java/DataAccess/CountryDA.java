package DataAccess;

import DataAccessInterface.ICountryDA;
import Entities.CountryDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar información del País.
 */
public class CountryDA extends BaseConnectionDA implements ICountryDA {
    private static final Logger logger = Logger.getLogger(CountryDA.class.getName());

    @Override
    public List<CountryDTO> GetAll() {
        List<CountryDTO> lista = new ArrayList<>();

        try {
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }

            callableStatements = connections.prepareCall("{call USP_SeleccionarPaises(?)}");
            callableStatements.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            callableStatements.execute();

            resultSets = (ResultSet) callableStatements.getObject(1);
            while (resultSets.next()) {
                CountryDTO dto = new CountryDTO();
                dto.setCodigoPais(resultSets.getInt("CODIGOPAIS"));
                dto.setNombrePais(resultSets.getString("NOMBRE"));
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
