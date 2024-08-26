/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.ITelefonoBL;
import DataAccess.TelefonoDA;
import DataAccessInterface.ITelefonoDA;
import Entities.TipoTelefonoDTO;
import java.util.List;

/**
 * AR-001
 * Autor: José Andrés Alvarado Matamoros
 * Clase encargada de administrar la información de los tipos de teléfono.
 */
public class TelefonoBL implements ITelefonoBL{
    ITelefonoDA  telefonoDA;
    public TelefonoBL()
    {
        telefonoDA= new TelefonoDA();
    }
    /**
     * AR-001
     * Autor: José Andrés Alvarado Matamoros
     * Método encargado de obtener todos los tipos de teléfono desde la base de datos.
     * @return Lista de TipoTelefonoDTO con la información de los tipos de teléfono.
     */
    @Override
    public List<TipoTelefonoDTO> GetAll() {
        return telefonoDA.GetAll();        
    }    
}
