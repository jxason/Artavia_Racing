/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.ITelefonoDA;
import Entities.TipoTelefonoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase encargada de administrar la información de los tipos de teléfono.
 */
public class TelefonoDA extends BaseConnectionDA implements ITelefonoDA{

     /**
     * AR-001
     * Autor: José Andrés Alvarado Matamoros
     * Método encargado de obtener todos los tipos de teléfono desde la base de datos.
     * @return Lista de TipoTelefonoDTO con la información de los tipos de teléfono.
     */
    @Override
    public List<TipoTelefonoDTO> GetAll() {
         List<TipoTelefonoDTO> lista = new ArrayList<>();
        
        try {
            connections = conectionDA.Get();
            if (connections == null) {
                throw new SQLException("Failed to establish connection");
            }
            
            callableStatements = connections.prepareCall("{call USP_SeleccionarTipoTelefono(?)}");
            callableStatements.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callableStatements.execute();
            
              // Obtener el cursor de resultados
            resultSets = (ResultSet) callableStatements.getObject(1);
            
            while (resultSets.next()) {
                TipoTelefonoDTO dto = new TipoTelefonoDTO();
                dto.setCategoriaTelefonoId(resultSets.getInt("CATEGORIATELEFONOID"));
                dto.setTipoTelefono(resultSets.getString("TIPOTELEFONO"));
                lista.add(dto);
            }
        } catch (SQLException e) {           
        } finally {
            closeResources();
        }
        
        return lista;
    }
    
}
