/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicInterface;
 
import Entities.CategoriaProductoDTO;
import java.util.List;

/**
 * AR-001
 * Author: Andrés Alvarado Matamoros
 * Interface encargada de administrar las categorias de los productos
 */
public interface ICategoriaProductoBL {
    /**
    * AR-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de obtener toda las categorias de los productos
    * @return 
    */
    List<CategoriaProductoDTO> GetAll();    
}
