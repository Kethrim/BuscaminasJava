/**
 * Clase para guardar un Tablero.
 * @author Kethrim Trad
 * @version Primera version, 2018.
 */

import java.util.*;
import java.io.*;
public class guardarTablero{

    /**
     * Método contrsuctor para guardar un Tablero.
     * @param String con el nombre del archivo en el que se guardará el tablero.
     * @param int con el número de filas del tablero.
     * @param int con el número de columnas del tablero.
     * @param int con el número de bombas del tablero.
     */
    public guardarTablero(String archivo, Tablero t){
	ObjectOutputStream escritor = null;
	try{
	    escritor = new ObjectOutputStream (new FileOutputStream(archivo));
	    escritor.writeObject(t);
	}catch (IOException e){
	} finally {
	    if (escritor != null){
	    }else {
		System.out.println("No hay ningun archivo abierto.");
	    }	    
	}	
    }    
}
