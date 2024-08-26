/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BusinessLogic;

import BusinessLogicInterface.ICategoriaServicioBL;
import DataAccess.CategoriaServicioDA;
import DataAccessInterface.ICategoriaServicioDA;
import Entities.CategoriaServicioDTO;
import java.util.List;

/**
 * AR-003
 * @Author: Horacio Porras Marín
 * Interface encargada de administrar las categorias de servicio
 */
public class CategoriaServicioBL implements ICategoriaServicioBL {
    
    ICategoriaServicioDA categoriaServicioDA;
    
    public CategoriaServicioBL() {
        categoriaServicioDA = new CategoriaServicioDA();
    }
    /**
    * AR-003
    * @Author: Horacio Porras
    * Metodo encargado de obtener todos los servicios
    * @return 
    */
    @Override
    public List<CategoriaServicioDTO> GetAll() {
        return categoriaServicioDA.GetAll();
    }

}
