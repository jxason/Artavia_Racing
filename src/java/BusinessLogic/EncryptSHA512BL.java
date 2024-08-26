
package BusinessLogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import BusinessLogicInterface.IEncryptSHA512BL;

/**
 * FI-001
 * Author: Andrés Alvarado Matamoros
 * Clase encargada de administrar la enciptación utilizando Sha-512.
 */
public class EncryptSHA512BL implements IEncryptSHA512BL
{
    /**
    * FI-001
    * Author: Andrés Alvarado Matamoros
    * Metodo encargado de encriptar cualquier cadena de texto a sha 512
    * @param text Aqui viene la una cadena string no convertida a sha 512 
    * @return Retorna una cadena de string convertida al formato Sha 512
    */

    @Override
    public String Encrypt(String text) {
     try {
            // Obtener instancia de MessageDigest para SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // Calcular el hash de la contraseña
            byte[] hash = md.digest(text.getBytes());

            // Convertir el hash de bytes a hexadecimal para visualización
            StringBuilder hexHash = new StringBuilder();
            for (byte b : hash) {
                hexHash.append(String.format("%02x", b));
            }

            // Retornar el hash en formato hexadecimal
            return hexHash.toString();

        } catch (NoSuchAlgorithmException e) {
            // Manejar cualquier excepción de algoritmo no encontrado
             return null; // Devolver null en caso de error
        }
    }
    
}
