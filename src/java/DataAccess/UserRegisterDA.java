/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.IUserRegisterDA;
import Entities.ClienteDTO;
import java.sql.Date;
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

            // Configurar parámetros para CLIENTE
            callableStatements.setString(1,clienteDTO.getCredencialId()); // p_credencial_id
            callableStatements.setInt(2, clienteDTO.getRolId());             // p_rol_id
            callableStatements.setString(3, clienteDTO.getNombre()); // p_nombre
            callableStatements.setString(4,clienteDTO.getPrimerApellido());    // p_primer_apellido
            callableStatements.setString(5, clienteDTO.getSegundoApellido());   // p_segundo_apellido
            callableStatements.setDate(6, clienteDTO.getFechaNacimiento()); // p_fecha_nacimiento
            callableStatements.setString(7,clienteDTO.getNumeroTelefono());    // p_numero_telefono
            callableStatements.setInt(8, clienteDTO.getCategoriaTelefonoId());              // p_categoria_telefono_id
            callableStatements.setInt(9, clienteDTO.getNumeroExtension());              // p_numero_extension
            callableStatements.setString(10, clienteDTO.getDescripcionTelefono());          // p_descripcion
            callableStatements.setInt(11, clienteDTO.getCodigoPais());             // p_codigo_pais
            callableStatements.setInt(12, clienteDTO.getCodigoEstado());             // p_codigo_estado
            callableStatements.setInt(13, clienteDTO.getCodigoCondado());            // p_codigo_condado
            callableStatements.setInt(14, clienteDTO.getCodigoDistrito());             // p_codigo_distrito
            callableStatements.setString(15, clienteDTO.getDescripcionDireccion()); // p_descripcion_direccion
            callableStatements.setString(16, clienteDTO.getCorreoElectronico()); // p_correo_electronico
            callableStatements.setString(17, clienteDTO.getContrasena()); // p_contrasena
            callableStatements.setInt(18, clienteDTO.getEsContrasenaTemporal());             // p_es_contrasena_temporal

            // Ejecutar el procedimiento almacenado
            callableStatements.execute();
            isRegistered = true;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
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
