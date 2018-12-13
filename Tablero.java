/**
 * Clase de apoyo para el Buscaminas
 * @author Kethrim Trad
 * @version Primera version, 2018
 */

import java.util.Random;
public class Tablero implements java.io.Serializable{
    protected celda [][] tablero;
    protected int bombas;
    protected int filas;
    protected int columnas;
    private boolean perder;

    /**
     * Método constructor de un tablero.
     * @param fila -número de filas del tablero.
     * @param columna -número de columnas del tablero.
     * @param bomba -número de bombas del tablero.
     */
    public Tablero (int fila, int columna,int bomba){
	filas = fila;
	columnas = columna;
	tablero = new celda [filas][columnas];
	bombas = bomba;

	for (int i=0; i< tablero.length; i++){
	    for (int j=0; j< tablero[0].length; j++){
		tablero[i][j] = new celda();
	    }
	}

	this.colocarBombas(bombas);
    }
    
    /*
     * Método que coloca las bombas de manera alatoria en el tablero
     * @param bomba -número de bombas a colocar.
     */
    
    private void colocarBombas(int bomba){
	bombas = bomba;
	Random random = new Random();
	int i =0;
	boolean bandera = true;

	while (bandera){	    
	int bombasFilas = random.nextInt(tablero.length-1);
	int bombasColumnas = random.nextInt(tablero[0].length-1);
	
	    if (!(tablero [bombasFilas] [bombasColumnas] instanceof celdaMinada)){
		tablero [bombasFilas] [bombasColumnas] = new celdaMinada();
		i+=1;
		obtenerValidaciones(bombasFilas, bombasColumnas);
	    }

	    if (i == bombas){
		bandera = false;
	    }
	}
    }

    /*
     * Método que obtiene las validaciones para obtener el número de minas alrededor de una celda
     * @param x -la coordenada x de la celda.
     * @param y -la coordenada y de la celda.
     */

    private void obtenerValidaciones (int x, int y){

	if ((x-1)>=0){
	    if ((y-1)>=0){
		if (!(tablero [x-1] [y-1] instanceof celdaMinada)){
		    tablero[x-1] [y-1].contarMinas();
		}		
	    }

	    if (!(tablero [x-1] [y] instanceof celdaMinada)){
		tablero[x-1] [y].contarMinas();
	    }

	    if ((y+1)<(obtenerColumnas())){
		if (!(tablero [x-1] [y+1] instanceof celdaMinada)){
		    tablero [x-1] [y+1].contarMinas();
		} 
	    }
	}


	if ((y-1)>=0){
	    if (!(tablero [x] [y-1] instanceof celdaMinada)){
		tablero[x] [y-1].contarMinas();
	    }
	}

	if ((y+1) < (obtenerColumnas())){
	    if (!(tablero [x] [y+1] instanceof celdaMinada)){
		 tablero[x] [y+1].contarMinas();
	    }
	}

	if ((x+1)>=0){
	   if ((y-1)>=0){
		if (!(tablero [x+1] [y-1] instanceof celdaMinada)){
		    tablero[x+1] [y-1].contarMinas();
		}		
	    }

	    if (!(tablero [x+1] [y] instanceof celdaMinada)){
		tablero[x+1] [y].contarMinas();
	    }

	    if ((y+1)<(obtenerColumnas())){
		if (!(tablero [x+1] [y+1] instanceof celdaMinada)){
		    tablero [x+1] [y+1].contarMinas();
		} 
	    }
	}	
    }

    /*
     * Método que explota todas las bombas del tablero
     */
    private void explotarTodo(){
	
	for (int i=0; i<obtenerFilas()-1; i++){
	    for (int j=0; j<obtenerColumnas(); j++){
		if (tablero[i] [j] instanceof celdaMinada){
		    ((celdaMinada)tablero [i] [j]).explotar();
		    
		}
	    }
	}	 
    }

    /**
     * Método que muestra todas las casillas sin bombas del tablero
     */
    public void verTodo(){
	int k=0;
	for (int i=0; i<obtenerFilas()-1; i++){
	    for (int j=0; j<obtenerColumnas(); j++){
		if (!(tablero [i] [j] instanceof celdaMinada)){
		    if (tablero [i] [j].obtenerContado() == 0){
			tablero [i] [j].verCelda();
		    }			
		}
	    }
	}
    }

    /**
     * Método que regresa el número de celdas que no han sido reveladas.
     * @return el número de celdas sin ser reveladas.
     */

    public int celdasNoVistas(){
	int c = 0;

	for(int i=0; i< this.obtenerFilas(); i++){
	    for (int j=0; j< this.obtenerColumnas(); j++){
		if (!tablero [i] [j].celdaVista()){
		    c+=1;
		}
	    }
	}

	return c;
    }
    
    /**
     * Método para obtener el número de filas del tablero
     * @return número de filas
     */
    public int obtenerFilas(){
	return filas;
    }

    /**
     * Método para obtener el número de columnas del tablero
     * @return número de columnas
     */

    public int obtenerColumnas(){
	return columnas;
    }

    /**
     * Método para obtener e número de bombas del tablero
     * @return número de bombas
     */
    public int obtenerBombas(){
	return bombas;
    }

    /**
     * Método para revelar una celda
     * @param x -la coordenada x de la celda.
     * @param y -la coordenada y de la celda.
     */
    
    public void revelarCelda(int x, int y){		 
	if (!(tablero[x-1] [y-1] instanceof celdaMinada)){
	    if (tablero[x-1] [y-1].obtenerContado() == 0){
		this.cerosAlrededor(x-1,y-1);		
	    } else {
		tablero [x-1] [y-1].verCelda();
	    }
	} else {
	    
	    ((celdaMinada)tablero [x-1] [y-1]).explotar();
	    this.explotarTodo();
	    perder = true;
	}
    }
    
    /**
     * Método para marcar una celda
     * @param x -la coordenada x de la celda.
     * @param y -la coordenada y de la celda.
     */
    
    public void marcarCelda(int x, int y){
	if (!(tablero[x-1][y-1].celdaVista())){
	    tablero [x-1][y-1].marcar();
	} else {
	    System.out.println("No se puede marcar una celda que ya ha sido vista.");
	}
   }

    /**
     * Método para saber si una celda está marcada
     * @param x -la coordenada x de la celda.
     * @param y -la coordenada y de la celda.
     * @return True si la celda está marcada, False de lo contrario
     */

    public boolean celdaMarcada(int x,int y){
	return tablero[x-1][y-1].estaMarcada();
    }

    /**
     * Método para desmarcar una celda
     * @param x -la coordenada x de la celda.
     * @param y -la coordenada y de la celda.
     */
    public void desmarcar(int x, int y){
	if (tablero [x-1][y-1].estaMarcada()){
	    tablero [x-1][y-1].desmarcar();
	} else {
	    System.out.println("La celda no puede desmarcarse si no ha sido marcada previamente.");
	}
	
    }

    /**
     * Método para saber si el usuario perdió el juego
     * @return True si el usuario perdió, False si no perdió
     */

    public boolean perdio(){
	return this.perder;
    }

    /*
     * Método para obtener las celdas con ceros alrededor de una celda mediante la división del tablero en cuatro duadrantes
     * @param x -la coordenada x de la celda.
     * @param y -la coordenada y de la celda.
     */

    private void cerosAlrededor(int x, int y){
		
	if (tablero [x][y].obtenerContado() == 0){
	    tablero [x] [y].verCelda();	
	    // cuadrantes superiores
	    if 	(x<(this.obtenerFilas()/2)){
		// cuadrante izquierdo
		if (y< (this.obtenerColumnas()/2) && x<(this.obtenerFilas()/2)){	
		    if ((y+1)<this.obtenerColumnas()){
			this.cerosAlrededor(x,y+1);
		    }      
		    if ((x+1)< this.obtenerFilas()){
			this.cerosAlrededor(x+1,y);
		    }
		    
		    // cuadrante derecho
		} else {
		    if(y>(this.obtenerColumnas()/2) && x<(this.obtenerFilas()/2)){
			
			if ((x+1)< this.obtenerFilas()){
			    this.cerosAlrededor(x+1,y);
			}
			
			if ((y-1)>=0){
			    this.cerosAlrededor(x,y-1);
			}
		    }
		}
	    }
	    // cuadrantes inferiores
	    
	    else {
		// cuadrante derecho
		if (y < (this.obtenerColumnas()/2) && x>(this.obtenerFilas()/2)){
		    if ((x-1)>=0){
			this.cerosAlrededor(x-1,y);
		    }
		    
		    if ((y+1)< this.obtenerColumnas()){
			this.cerosAlrededor(x,y+1);
		    } 
		} else {
		    if (y> (this.obtenerColumnas()/2) && x> (this.obtenerFilas()/2)){
			// cuadrante izquierdo
			if ((y-1)>=0){
			    this.cerosAlrededor(x,y-1);
			}
			
			if ((x-1)>=0){
			    this.cerosAlrededor(x-1,y);
			}
		    }
		}
		
	    }
	}
    }

    
    /**
     * Método para imprimir el tablero
     * @return formato del tablero
     */
    public String toString(){
	String c= "|  ";
	for (int i=0; i< obtenerFilas(); i++){
	    for (int j=0; j < obtenerColumnas(); j++){
		c += tablero[i] [j]+"  |  ";
	    }
	    c+="\n\n|  ";
	}

	return c+"\b\b\b ";	    
    }
}
