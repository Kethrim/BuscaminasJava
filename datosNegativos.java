/**
 * Clase de apoyo para evitar que el usuario ingrese datos negativos en el tablero.
 * @author Kethrim Trad.
 */
import java.lang.NegativeArraySizeException;
public class datosNegativos extends NegativeArraySizeException{

    /**
     * Método constructor de la clase padre NegativeArrayException.
     */

    public datosNegativos(){
	super();
    }

     /**
     * Método constructor de la clase padre NegativeArrayException que imprime un mensaje.
     * @param String con el mensaje que se desea imprimir.
     */
    
    public datosNegativos(String mensaje){
	super(mensaje);
    }
}
