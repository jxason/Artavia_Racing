package BusinessLogicInterface;

/**
 * FI-001
 * Author: Andrés Alvarado Matamoros
 * Interfaz encargada de administrar la enciptación utilizando Sha-512.
 */
public interface IEncryptSHA512BL {
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de encriptar cualquier cadena de texto a sha 512
    * @param text Aqui viene la una cadena string no convertida a sha 512 
    * @return Retorna una cadena de string convertida al formato Sha 512
    */
   String Encrypt(String text);
    
}
