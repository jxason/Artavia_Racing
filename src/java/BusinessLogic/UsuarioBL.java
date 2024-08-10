/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.IUsuarioBL;
import DataAccess.UsuarioDA;
import DataAccessInterface.IUsuarioDA;
import Entities.RequestUsuarioDTO;
import Entities.ResponseUsuarioDTO;

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
    public ResponseUsuarioDTO Verificar(RequestUsuarioDTO requestDTO) {
                return usuarioDA.Verificar(requestDTO);
    }
    
}
