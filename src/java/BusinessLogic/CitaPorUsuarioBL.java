/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.ICitaPorUsuarioBL;
import DataAccess.CitaPorUsuarioDA;
import DataAccessInterface.ICitaPorUsuarioDA;
import Entities.ResponseCitaPorUsuarioDTO;
import java.util.List;

/**
 *
 * @author: Horacio Porras
 */
public class CitaPorUsuarioBL implements ICitaPorUsuarioBL {

    ICitaPorUsuarioDA citaPorUsuarioDA;

    public CitaPorUsuarioBL() {
        citaPorUsuarioDA = new CitaPorUsuarioDA();
    }

    @Override
    public List<ResponseCitaPorUsuarioDTO> GetBy(String cedulaUsuario) {
        return citaPorUsuarioDA.GetBy(cedulaUsuario);
    }

}
