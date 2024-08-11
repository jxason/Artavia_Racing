/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessLogicInterface.ICategoriaProductoBL;
import DataAccess.CategoriaProductoDA;
import DataAccessInterface.ICategoriaProductoDA;
import Entities.CategoriaProductoDTO;
import java.util.List;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar las categorias de los productos
 */
public class CategoriaProductoBL implements ICategoriaProductoBL{
    ICategoriaProductoDA categoriaProductoDA;
    
    public CategoriaProductoBL()
    {
        categoriaProductoDA = new CategoriaProductoDA();
    }
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda las categorias de los productos
    * @return 
    */
    @Override
    public List<CategoriaProductoDTO> GetAll() {
       return categoriaProductoDA.GetAll();
    }
    
}
