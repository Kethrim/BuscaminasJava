/**
 * Clase que prepara el Buscaminas
 * @author Kethrim Trad
 * @version Primera version, 2018
 */
import java.util.Scanner;
public class preBuscaminas{
    private int filas;
    private int columnas;
    public String usuario;
    private int opcion;
    private Tablero t = null;

    /**
     * Método que imprime el menú principal del juego
     *
     */
    
    public void menu(){
	System.out.println( "    ╔═══════════════════════════════════════════════════════════════════╗\n"+
		   "    ║\t                                                             \t║\n"+
		   "    ║\t\t\tBienvenido a Buscaminas.                        ║\n"+
		   "    ║\t¿Qué desea hacer? Escribe el número de la opción que elijas.   \t║\n"+
		   "    ║\t                                                            \t║\n"+
		   "    ║\t1.Jugar una partida nueva.                                      ║\n"+
		   "    ║\t2.Jugar una partida guardada.                              \t║\n"+
		   "    ║\t3.Salir.                                                     \t║\n"+
			     "    ╚═══════════════════════════════════════════════════════════════════╝");	    
    
	}
    /**
     * Método que imprime las opciones para jugar Buscaminas
     */
    private void menuBuscaminas(){       
	System.out.println( "¿Qué deseas hacer?" +"\n1.Ver una celda\n2.Marcar una celda.\n3.Desmarcar una celda.\n4.Guardar partida.\n5.Salir.");
    }
    
    /**
     * Método que obtiene el nombre del usuario.
     * @return nombre del usuario.
     */
    private String obtenerNombre(){
	return usuario;
    }

    
    /*
     * Método que interactua con el usuario para poder jugar Buscaminas.
     * @param opcion -opción decidida por el usuario
     * @return True para seguir, False para parar de jugar.
     */
        
    private boolean jugar(int op){
	opcion = op;
	boolean bandera = true,bandera2= true;
	Scanner scan = new Scanner(System.in);
	    switch(opcion){
	    case 1:	    
		do {	   
		    scan = new Scanner(System.in);
		    int x=0;
		    int y=0;
		    try {		
			System.out.println("Ingresa la celda que quieres ver sin espacios.Ejemplo: 3,4");
			String coordenada = scan.nextLine();	
			String [] arreglo = coordenada.split(",");
			y = Integer.parseInt(arreglo[0]);
			x = Integer.parseInt(arreglo[1]);		
		    } catch(Exception e){}
		    if (x!=0 && y!=0){
			if (x>=0 && y>=0){
			    if (x<= t.obtenerFilas() && y<= t.obtenerColumnas()){
				if (!t.celdaMarcada(x,y)){
				    t.revelarCelda(x,y);
				    bandera2=false;
				    if (t.celdasNoVistas() == t.obtenerBombas()){
					//t.verTodo();
					System.out.println(t);
					System.out.println("\t¡Ganaste, felicidades! 🏆");
					bandera2 = false;
					bandera = false;
				    }				    
				} else {
				System.out.println("\t\tPrimero desmarca la celda.");
				bandera2 = false;				
				}
				
				if (t.perdio()){
				    System.out.println(t);
				    System.out.println("\t\t¡Perdiste 😞!");
				    bandera2 = false;
				    bandera = false;
				}
			    } else {
				System.out.println("\tIngresa de nuevo la celda.");
			    
				
			    }
			} else {
			    System.out.println("\tNo existen las celdas negativas.");
			}
		    } else {
			System.out.println("\t\tIngresa de nuevo la celda.");
		    }
		} while (bandera2);
		break;		    
	    case 2:
		bandera2= true;
		do {	   
		    scan = new Scanner(System.in);
		    int x=0;
		    int y=0;
		    try {		
			System.out.println("Ingresa la celda que quieres marcar sin espacios.Ejemplo: 3,4");
			String coordenada = scan.nextLine();	
			String [] arreglo = coordenada.split(",");
			y = Integer.parseInt(arreglo[0]);
			x = Integer.parseInt(arreglo[1]);		
		    } catch(Exception e){}
		    if (x!=0 && y!=0){
			if (x>=0 && y>=0){		   
			    t.marcarCelda(x,y);
			    bandera2=false;			   
			}
			else {
			    System.out.println("\tNo existen las celdas negativas.");
			}
		    } else {
			System.out.println("\t\tIngresa de nuevo la celda.");
		    }
		} while (bandera2);
		
		break;
	    case 3:
		bandera2 = true;
		do {	   
		    scan = new Scanner(System.in);
		    int x=0;
		    int y=0;
		    try {		
			System.out.println("Ingresa la celda que quieres desmarcar sin espacios.Ejemplo: 3,4");
			String coordenada = scan.nextLine();	
			String [] arreglo = coordenada.split(",");
			y = Integer.parseInt(arreglo[0]);
			x = Integer.parseInt(arreglo[1]);		
		    } catch(Exception e){}
		    if (x!=0 && y!=0){
			if (x>=0 && y>=0){		   
			    t.desmarcar(x,y);
			    bandera2=false;
			}
			else {
			    System.out.println("\tNo existen las celdas negativas.");
			}
		    } else {
			System.out.println("\t\tIngresa de nuevo la celda.");
		    }
		} while (bandera2);
		
		break;
	    }
	    return bandera;
    }

    
    /**
     * Método que lee una opción del menú para interactuar con el usuario.
     */
    public void menu2(Tablero mio){
	t = mio;
	boolean bandera = true, bandera2 = true;
	Scanner scan = null;	
	while (bandera){
	    scan = new Scanner(System.in);
	    try {
		System.out.println(t);
		menuBuscaminas();
		opcion =0;
		try {
		    opcion = scan.nextInt();
		} catch (java.util.InputMismatchException e){
		    throw new datosIncorrectos("Dato incorrecto.");
		}
		if (opcion >0 && opcion <5){		   
		    if (opcion == 4){
			int a = t.obtenerFilas();
			int b = t.obtenerColumnas();
			int c = t.obtenerBombas();
			System.out.print("Ingresa el nombre del archivo con el que deseas guardar tu juego(incluye la terminación): ");
			String arch = scan.next();
			guardarTablero tab = new guardarTablero(arch,t);
			System.out.print("Ingresa un código de guardado:");
			String cod = scan.next();
			String n =obtenerNombre();
			guardarDatos z = new guardarDatos(cod,n,a,b,c);
			
			bandera = false;
		    } else {
			bandera  = jugar(opcion);	
		    }		    
		} else {
		    if (opcion == 5){
			bandera = false;
		    }		     	    		     
		    
		    if (opcion>5 || opcion<1){
			System.out.println("\tEsa opción no existe. Ingresa una de las opciones que se muestran.");
		     }
		}		
	    } catch (datosIncorrectos e){
		System.out.println(e.getMessage());
	    }
	}
    }
    
    /*
     * Método que obtiene las filas que el usuario elige.
     * @return número de filas del tablero.
     */
    private int obtenerFilas(){
	return filas;
    }

    /*
     * Método que obtiene el número de columnas que el usuario elige.
     * @return número de columnas del tablero.
     */

    private int  obtenerColumnas(){
	return columnas;
    }

    /**
     * Método que valida el número de filas que el usuario escoge.
     * @return número de filas que el usuario escoge.
     */
    public int paraFilas(){
        filas = 0;
	Scanner scan = null;
	boolean bandera = true;
	
	do {	   
	    scan = new Scanner(System.in);
	    try {		
		System.out.print("¿De qué tamaño será tu tablero? \nPrimeramente ingresa el número de filas: ");	
		try {
		    filas = scan.nextInt();
		} catch(java.util.InputMismatchException e){
		    throw new datosIncorrectos("\tEse tipo de dato no está perimitido.");
		}
		if (filas < 80){
		    if (filas<0 || filas<8 ){
			System.out.println("\tEl buscaminas no puede tener menos de 8 filas.");
			
			if (filas <0){
			    throw new datosNegativos("\tNo existen buscaminas con valores negativos.");
			}
		    }else {		    		    
			bandera = false;
		    }
		} else {
		    if (filas >= 80){
			System.out.println("\tNo se aceptan más de 80 filas.");
		    }
		}
	    }catch (datosIncorrectos e){
		System.out.println(e.getMessage());
	    } catch (datosNegativos e){
		System.out.println(e.getMessage());	    
	    }
	} while (bandera);
	return filas;
    }

    /**
     * Método que valida el número de columnas que el usuario escoge.
     * @return número de columnas que el usuario escoge.
     */
    public int paraColumnas(){
        columnas = 0;
	Scanner scan = null;
	boolean bandera = true;
	do {	   
	    scan = new Scanner(System.in);
	    try {				
		System.out.print("Ahora ingresa el número de columnas: ");
		try {
		    columnas = scan.nextInt();
		} catch(java.util.InputMismatchException e){
		    throw new datosIncorrectos("\tEse tipo de dato no está perimitido.");
		}
		if (columnas < 80){
		    if ( columnas<0 || columnas<8){
			System.out.println("\tEl buscaminas no puede tener menos de 8 columnas.");
			
			if (columnas<0){
			    throw new datosNegativos("\tNo existen buscaminas con valores negativos.");
			}
		    }else {		    		    
			bandera = false;
		    }
		} else {
		    if (columnas >= 80)
			System.out.println("No se aceptan más de 80 columnas.");
		}
	    } catch (datosIncorrectos e){
		System.out.println(e.getMessage());
	    } catch (datosNegativos e){
		System.out.println(e.getMessage());	    
	    }
	} while (bandera);
	return columnas;
    }

    
    /**
     * Método que valida el número de bombas que el usuario escoge.
     * @return número de bombas que el usuario escoge.
     */
    	    
    public int paraBombas(){
	int bombas = 0;
	Scanner scan = null;
	boolean bandera = true;
	do {
	    scan = new Scanner(System.in);
	    try {
		    System.out.print("Ingresa el número de bombas que deseas en el buscaminas: ");
		    try {
			bombas = scan.nextInt();
		    } catch (java.util.InputMismatchException e){
			throw new datosIncorrectos ("\tEse tipo de dato no está perimitido.");
		    }

		    if (bombas>(((obtenerFilas()*obtenerColumnas())/4)*3) || bombas<0 ){
			System.out.println("\tNo esta permitido tener esa cantidad de bombas en el buscaminas.");
			
			if (bombas<0){
			    throw new datosNegativos("\tNo existen buscaminas con valores negativos.");
			}
		    } else {
			System.out.println("Se colocaron las bombas de manera exitosa.");					
			bandera = false;
		    }		   
	    } catch (datosIncorrectos e){
		System.out.println(e.getMessage());
	    } catch (datosNegativos e){
		System.out.println(e.getMessage());
	    }	    
	} while (bandera);
	return bombas;
    }
    
}
