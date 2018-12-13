/**
 * Clase para crear celdas (principal para el buscaminas).
 * @author Kethrim Guadalupe Trad Mateos
 * @version Primera version, 2018
 */

public class celda implements java.io.Serializable{
    protected boolean mina;
    protected boolean bandera; 
    protected boolean celdaVista;
    protected int i;

    /**
     * Método constructor de celdas.
     */
    public celda(){
	this.mina = false;
	this.celdaVista = false;
    }
    
    /**
     * método para minar celdas.
     */

    protected void minar(){
	this.mina = true;	
    }

    /**
     * Método para marcar una celda.
     */

    public void marcar(){
	this.bandera = true;	
    }

    /**
     * Método para saber si una ceda está marcada.
     * @return True si la celda está marcada, False de lo contrario.
     */
    
    public boolean estaMarcada(){
	return bandera;
    }

    /**
     * Método para desmarcar una celda.
     */

    public void desmarcar(){
	this.bandera = false;
    }
    
    /**
     * Método para saber si la celda tiene mina.
     * @return True si la celda está minada, False de lo contrario.
     */
    public boolean hayMina(){
	return mina;
    }
    
    /**
     * Método para ver una celda.
     */
    
    public void verCelda(){
	if (this.estaMarcada()){
	    this.celdaVista = false;
	} else {
	    this.celdaVista = true;
	}
    }

    public void contarMinas(){
	i+=1;
    }

    public int obtenerContado(){
	return i;
    }

    public boolean celdaVista(){
	return this.celdaVista;
    }
    /**
     * Método para imprimir las celdas.
     * @return String de las celdas
     */

    public String toString(){
	String t= "";
	if (celdaVista){	    
	    if (!estaMarcada()){
		t = "  "+i+"  ";
	    }
	} else {	   
	    if (estaMarcada()){
		t="  🚩 ";
	    } else {
		 t ="  ❓ ";
	    }
	}
	return t;
    }

    public static void main(String [] args){
	celda a = new celda();
	System.out.println(a);
	a.marcar();
	System.out.println(a);	
    }
}
