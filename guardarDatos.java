/**
 * Clase para guardar los datos del usuario al jugar Buscaminas.
 * @author Kethrim Trad
 * @version Primera version, 2018.
 * @see datos
 */

import java.util.*;
import java.io.*;
public class guardarDatos{

    /**
     * Método constructor que guarda los datos de un usuario de Buscaminas.
     * @param String con el nombre del archivo en el que se guardarán los datos.
     * @param String con el nombre del usuario.
     * @param int con el número de filas de su tablero.
     * @param int con el número de columnas de su tablero.
     * @param int con el número de bombas de su tablero.
     */
    public guardarDatos(String archivo, String nombre, int f,int c, int n){
	ObjectOutputStream escritor = null;
	try{
	    escritor = new ObjectOutputStream (new FileOutputStream(archivo));
	    escritor.writeObject(new datos(nombre,f,c,n));
	}catch (IOException e){
	} finally {
	    if (escritor != null){
		System.out.println("El archivo se guardó.");
	    }else {
		System.out.println("No hay ningun archivo abierto.");
	    }	    
	}
    }
}
