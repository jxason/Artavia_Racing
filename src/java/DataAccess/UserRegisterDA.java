/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.IUserRegisterDA;
import Entities.ClienteDTO;
import java.sql.SQLException;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar informacion del Estado de los paises.
 */
public class UserRegisterDA extends BaseConnectionDA implements IUserRegisterDA{
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Método encargado de registrar un cliente en el sistema.
    * @param clienteDTO
    * @return 
    */
    @Override
    public boolean Save(ClienteDTO clienteDTO) {
        boolean isRegistered = false;
            try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_RegistrarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            callableStatements.setString(1, clienteDTO.getCredencialId());
            callableStatements.setInt(2, clienteDTO.getRolId());
            callableStatements.setString(3, clienteDTO.getNombre());
            callableStatements.setString(4, clienteDTO.getPrimerApellido());
            callableStatements.setString(5, clienteDTO.getSegundoApellido());
            callableStatements.setDate(6, new java.sql.Date(clienteDTO.getFechaNacimiento().getTime()));
            callableStatements.setString(7, clienteDTO.getNumeroTelefono());
            callableStatements.setInt(8, clienteDTO.getCategoriaTelefonoId());

            // Asigna 0 si clienteDTO.getNumeroExtension() es null
            int numeroExtension = clienteDTO.getNumeroExtension() != null ? clienteDTO.getNumeroExtension() : 0;
            callableStatements.setInt(9, numeroExtension);

            callableStatements.setString(10, clienteDTO.getDescripcionTelefono());
            callableStatements.setInt(11, clienteDTO.getCodigoPais());
            callableStatements.setInt(12, clienteDTO.getCodigoEstado());
            callableStatements.setInt(13, clienteDTO.getCodigoCondado());
            callableStatements.setInt(14, clienteDTO.getCodigoDistrito());
            callableStatements.setString(15, clienteDTO.getDescripcionDireccion());
            callableStatements.setString(16, clienteDTO.getCorreoElectronico());
            callableStatements.setString(17, clienteDTO.getContrasena());
            callableStatements.setInt(18, clienteDTO.getEsContrasenaTemporal());

            callableStatements.execute();
            isRegistered = true;
        } catch (SQLException e) {
            // Manejo de excepciones
        } finally {
            closeResources();
        }
        return isRegistered;
    }
   /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de validar si el usuario con esa cedula se encuentra almacenado en el sistema.
    * @param Cedula
    * @return 
    */    
    @Override
    public String Validate(String Cedula) {
        String Response = "";
        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_VerificarExistenciaUsuario(?, ?)}");
            callableStatements.setString(1, Cedula);
            callableStatements.registerOutParameter(2, java.sql.Types.VARCHAR);            
            callableStatements.execute();
            
            Response = callableStatements.getString(2);
        } catch (SQLException e) {            
        } finally {
            closeResources();
        }
        return Response;
    }  
    
}
