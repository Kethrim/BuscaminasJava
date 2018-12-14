/**
 * Clase para mostrar un tablero previamente guardado.
 * @author Kethrim Trad
 * @version Primera version, 2018
 */

import java.util.*;
import java.io.*;
public class mostrarTablero{

    /**
     * Método que regresa el tablero previamente guardado en un archivo.
     * @param String con el nombre del documento en el que se guardó el tablero.
     * @return Tablero. 
     */
    public Tablero mostrarTab(String arch){
	ObjectInputStream lector = null;
	Tablero obj = null;

	try {
	    lector = new ObjectInputStream(new FileInputStream(arch));	    
	    obj = (Tablero) lector.readObject();			    
	}catch (EOFException e){
	} catch (ClassNotFoundException e){
	} catch (IOException e){
	} finally {
	    if (lector != null){
		try { lector.close();} catch (IOException e) { }
	    } else {
		System.out.println("\tEl archivo en el que \"guardaste\" tu partida no existe.");

	    }
	}

	return obj;
    }
}
