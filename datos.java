/**
 * Clase para guardar los datos de un usuario de Buscaminas.
 * @author Kethrim Trad
 * @version Primera version, 2018.
 */
import java.util.Scanner;
public class datos implements java.io.Serializable{
    protected String nombre;
    protected int minas;
    protected int filas;
    protected int columnas;

    /**
     * Método constructor para guardar los datos de un usuario de Buscaminas.
     * @param String con el nombre del usuario 
     * @param int con el número de filas del tablero que escoge el usuario
     * @param int con el número de columnas del tablero que escoge el usuario
     * @param int con el número de bombas del tablero que escoge el usuario.
     */

    public datos(String nombre,int filas,int columnas, int minas){
	this.nombre = nombre;
	this.filas = filas;
	this.columnas = columnas;
	this.minas = minas;
    }

    /**
     * Método que regresa el nombre del usuario.
     * @return String con el nombre del usuario.
     */
    public String obtenerNombre(){
	return this.nombre;
    }

    /**
     * Método que regresa el número de filas del tablero que escoge el usuario.
     * @param int con el número de filas del tablero.
     */

    public int obtenerFilas(){
	return this.filas;
    }

     /**
     * Método que regresa el número de columnas del tablero que escoge el usuario.
     * @param int con el número de columnas del tablero.
     */
    
    public int obtenerColumnas(){
	return this.columnas;
    }

     /**
     * Método que regresa el número de minas del tablero que escoge el usuario.
     * @param int con el número de minas del tablero.
     */

    public int obtenerMinas(){
	return this.minas;
    }

     /**
     * Método que imprime los datos del usuario.
     * @param String con los datos del usuario.
     */
    
    public String toString(){
	return "Bienvenid@ "+this.obtenerNombre()+", los datos de tu tablero son: "+this.obtenerFilas()+" filas, "+this.obtenerColumnas()+" columnas y "+this.obtenerMinas()+" minas.";
    }
}
