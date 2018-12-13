/**
 * Clase de apoyo para evitar que el usuario introduzca datos incorrectos.
 */
import java.util.InputMismatchException;
public class datosIncorrectos extends InputMismatchException{

    /**
     * Método que lanza una excepción del tipo InputMismatchException
     */
    public datosIncorrectos(){
	super();
    }
    
    /**
     * Método que lanza una excepción del tipo InputMismatchException junto con un mensaje.
     * @param String mensaje que imprime junto con la excepción.
     */

    public datosIncorrectos(String mensaje){
	super(mensaje);
    }
}
