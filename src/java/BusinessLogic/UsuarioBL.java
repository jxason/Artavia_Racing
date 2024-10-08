/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IEncryptSHA512BL;
import BusinessLogicInterface.ISessionBL;
import BusinessLogicInterface.IUsuarioBL;
import DataAccess.UsuarioDA;
import DataAccessInterface.IUsuarioDA;
import Entities.Enums.TypeSessions;
import Entities.RequestUsuarioDTO;
import Entities.ResponseDTO;
import Entities.ResponseUsuarioDTO;
import Entities.SessionDTO;
import javax.servlet.http.HttpSession;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar el menu del usuario.
 */
public class UsuarioBL implements IUsuarioBL {
    private IUsuarioDA usuarioDA;

    /**
     * AR-001
     * Autor: Andrés Alvarado Matamoros
     * Constructor que inicializa el objeto de acceso a datos (DAO).
     */
    public UsuarioBL() {
        this.usuarioDA = new UsuarioDA();
    }
     /**
     * AR-001
     * Author: Andrés Alvarado Matamoros
     * Verifica si un usuario existe en la base de datos con las credenciales proporcionadas,
     * invocando el stored procedure `USP_VerificarUsuario`.
     * 
     * @param requestDTO Un objeto RequestUsuarioDTO que contiene el correo
     *                   electrónico y la contraseña del usuario (ya encriptada en SHA-512).
     * @return Un objeto ResponseUsuarioDTO con la información del usuario si existe,
     *         o null si no existe.
     */
    @Override
   public ResponseDTO Verificar(RequestUsuarioDTO requestDTO) {
        ResponseDTO response = new ResponseDTO();
        ISessionBL userSession = new SessionBL(); // Asegúrate de usar una instancia adecuada
        IEncryptSHA512BL encryptSHA512BL = new EncryptSHA512BL();

        // Encriptar la contraseña
        requestDTO.setContrasena(encryptSHA512BL.Encrypt(requestDTO.getContrasena()));

        // Verificar el usuario
        ResponseUsuarioDTO responseUser = usuarioDA.Verificar(requestDTO);
        if (responseUser == null) {
            response.setSuccess(false);
        } else {
            response.setSuccess(true);

            // Crear el objeto SessionDTO
            SessionDTO sessionData = new SessionDTO(
                responseUser.getCredencialId(),
                requestDTO.getCorreoElectronico(),
                responseUser.getRolId(),
                requestDTO.getContrasena(),
                TypeSessions.SESSION_USER
            );

            // Obtener la sesión HTTP del DTO
            HttpSession httpSession = requestDTO.getHttpSession();

            // Guardar la información del usuario en la sesión HTTP
            userSession.Save(httpSession, sessionData);
        }

        return response;
    }
    
}
