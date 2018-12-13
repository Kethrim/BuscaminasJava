/**
 * Clase para jugar Buscaminas
 * @author Kethrim Trad
 * @version Primera version, 2018
 */
import java.util.Scanner;
public class Buscaminas{
    private static Tablero t = null;      
    public static void main(String [] args){
	Scanner scan = null, datos = null;
	boolean bandera = true;
	int opcion=0;
	preBuscaminas mio = new preBuscaminas();
	while(bandera){
	    scan = new Scanner(System.in);
	    try {
		mio.menu();		
		try {
		    opcion = scan.nextInt();
		} catch (java.util.InputMismatchException e){
		    throw new datosIncorrectos ("Ese tipo de dato no está permitido");
		}
		switch(opcion){
		case 1:
		    datos = new Scanner(System.in);
		    int f =0;
		    int c =0;
		    int b =0;	      
		    System.out.print("Ingresa tu nombre: ");
		    String nombre = datos.next();
		    mio.usuario = nombre;
		    
		    f = mio.paraFilas();
		    c = mio.paraColumnas();
		    b = mio.paraBombas();
		    
		    System.out.println("\tSe guardaron "+f+" filas, "+c+" columnas y "+b+" bombas.");	
		    t = new Tablero(f,c,b);
		    if (t != null){			
		        mio.menu2(t);
			
		    } else {
			System.out.println("El tablero NO se creo.");
		    }		    
		    break;		
		case 2:
		    System.out.print("Ingresa el nombre del archivo con el que guardaste tu partida: ");
		    String arch = scan.next();
		    System.out.print("Ingresa tu código de guardado: ");
		    String cod = scan.next();		    
		    mostrarTablero tab = new mostrarTablero();		
		    mostrarDatos data = new mostrarDatos();
		    t = tab.mostrarTab(arch);
		    datos y = data.mostrarDat(cod);
		    if (t != null){
			if (y != null){
			    System.out.println(y);
			    mio.menu2(t);
			}
		    }
			break;
		default:
		    System.out.println("Esa opción no existe.");
		    break;
		case 3:
		    System.out.println("Hasta pronto.");
		    bandera = false;
		}
	    } catch (datosIncorrectos e){
		System.out.println("\tEse tipo de dato no está perimitido.");
	    }
	}	
    }    
}
