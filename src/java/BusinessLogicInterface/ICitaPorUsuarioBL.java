/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;

import Entities.ResponseCitaPorUsuarioDTO;
import java.util.List;

/**
 *
 * @author horac
 */
public interface ICitaPorUsuarioBL {
    List<ResponseCitaPorUsuarioDTO> GetBy(String cedulaUsuario);
}
