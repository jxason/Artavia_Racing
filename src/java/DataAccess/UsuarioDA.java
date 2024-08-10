/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import DataAccessInterface.IUsuarioDA;
import Entities.RequestUsuarioDTO;
import Entities.ResponseUsuarioDTO;
import java.sql.SQLException;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar el menu del usuario.
 */
public class UsuarioDA extends BaseConnectionDA implements IUsuarioDA
{
    /**
     * AR-001
     * Autor: Andrés Alvarado Matamoros
     * Método encargado de verificar si un usuario existe en la base de datos con las credenciales proporcionadas.
     * 
     * @param requestDTO Un objeto RequestUsuarioDTO que contiene el correo electrónico y la contraseña del usuario.
     * @return Un objeto ResponseUsuarioDTO con la información del usuario si existe, o null si no existe.
     */
    @Override
    public ResponseUsuarioDTO Verificar(RequestUsuarioDTO requestDTO) {
        ResponseUsuarioDTO responseDTO = null;

        try {
            connections = conectionDA.Get();
            callableStatements = connections.prepareCall("{call USP_VerificarUsuario(?, ?, ?, ?)}");

            // Asigna los parámetros de entrada
            callableStatements.setString(1, requestDTO.getCorreoElectronico());
            callableStatements.setString(2, requestDTO.getContrasena());

            // Registra los parámetros de salida
            callableStatements.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatements.registerOutParameter(4, java.sql.Types.NUMERIC);

            // Ejecuta el procedimiento almacenado
            callableStatements.execute();

            // Verifica si el stored procedure devolvió valores
            String credencialId = callableStatements.getString(3);
            int rolId = callableStatements.getInt(4);

            if (credencialId != null) {
                responseDTO = new ResponseUsuarioDTO();
                responseDTO.setCredencialId(credencialId);
                responseDTO.setRolId(rolId);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones de SQL
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones generales
        } finally {
            closeResources(); // Uso del método heredado para cerrar los recursos
        }
        return responseDTO;
    }   
}
