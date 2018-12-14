/**
 * Clase que muestra los datos de un usuario de Buscaminas previamente guardados.
 * @author Kethrim Trad
 * @version Primera versión, 2018.
 * @see datos
 */

import java.util.*;
import java.io.*;
public class mostrarDatos{

    /**
     * Método constructor que imprime los datos del usuario guardados en un archivo.
     * @param String con el nombre del archivo
     */
    public datos mostrarDat(String arch){
	ObjectInputStream lector = null;
	datos obj = null;
	try {
	    lector = new ObjectInputStream(new FileInputStream(arch));	     
	    obj = (datos) lector.readObject();
	}catch (EOFException e){
	} catch (ClassNotFoundException e){
	} catch (IOException e){
	} finally {
	    if (lector != null){
		try { lector.close();} catch (IOException e) { }
	    } else {
		System.out.println("\tEl archivo en el que \"guardaste\" tus datos no existe.");

	    }
	}

	return obj;
    }
}
