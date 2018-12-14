/**
 * Clase para crear celdas minadas (principal para el buscaminas).
 * @author Kethrim Guadalupe Trad Mateos
 * @version Primera 2018
 * @see celda
 */

public class celdaMinada extends celda implements java.io.Serializable{
    protected boolean explotar;
    private int bombas;

    /**
     * Método constructor de una celda minada/con bombas.
     */
    public celdaMinada(){
	super.minar();
	explotar = false;
    }

    /**
     * Método para explotar las bombas.
     */

    public void explotar(){
	this.explotar = true;
    }

    /**
     * Método para imprimir las celdas minadas.
     * @return String con una bomba si la celda fue vista, con un "me gusta" si no lo fue.
     */

    public String toString(){
	if (explotar){
	    return "💣";
	} else {
	    if (!estaMarcada()){
		return "❓";
	    } else {
		return "🚩";
	    }
	}
    }
}
