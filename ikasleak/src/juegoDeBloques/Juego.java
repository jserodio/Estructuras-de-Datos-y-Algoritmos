package juegoDeBloques;

import java.util.Random;
import java.util.Stack;

public class Juego {

	public static int NUMCOLUMNAS = 7;
	public static int NUMFILAS = 3;
	
	Stack<Bloque>[] tablero; // Array de pilas
	@SuppressWarnings("unchecked")	
	

	public Juego(){ 
		// Constructor
		tablero = (Stack<Bloque>[]) new Stack[NUMCOLUMNAS];
		
		// Creo el tablero
		for (int i=0; i<NUMCOLUMNAS; i++){
			// Lleno el tablero con tantas pilas como columnas quiero.
			tablero[i] = new Stack<Bloque>(); // Creo pila que contiene Bloque
			Bloque b = new Bloque(); // Creo un bloque llamado b
			for (int j=0; j<NUMFILAS; j++){
				// Llenamos cada fila de bloques, añadiendolas a la pila.
				int elige = new Random().nextInt(Direccion.values().length); // Elijo random si dcha o izquierda.
				b.direccion =  Direccion.values()[elige]; // Asigno random IZQUIERDA o DERECHA.
				b.puntos = new Random().nextInt(5 - 1) + 1; // Asigno puntos por romper el bloque. Entre 1 y 5 ptos.
				b.salto = new Random().nextInt(6 - 0) + 0; // Asigno el tamaño del salto que dará. Entre 0 y 6 saltos.
				tablero[i].push(b); // Añado el bloque a la pila.
			}	
		}
	}
	
	public int jugar(){
	/*
	 *  Pre			El juego ha sido inicializado (se han generado los bloques de inicio)
	 *  Post		Se ha jugado una partida, en la que la bola empieza cayendo encima de la columna de en medio.
	 *	@return		Si se gana devuelve puntos. Si se pierde -1.
	 */		
		final int GAMEOVER = -1;
		final int WIN = 0;

		int status = 1;
		int puntuacion = 0; // 0 pts ¯\(°_o)/¯
		
		int cont=NUMCOLUMNAS/2; // Contador para el bucle while.
		
		while(status != GAMEOVER && status != WIN){
			// Recorre el bucle si no ha ganado ni ha perdido.
			
			if(tablero[cont].isEmpty()){
				// TODO: arreglar el ArrayIndexOutOfBoundsException.
				// Si la pila actual es vacia (ha saltado fuera), entonces pierde la partida.
				status = GAMEOVER;
			}
			else{
				Bloque actual = tablero[cont].peek();
				if (actual==null){
					// Accede al bloque de la cima de la pila. Si es null ha ganado la partida.
				 	status = WIN;
				 }else{
					 puntuacion += actual.puntos;
					 if (actual.direccion == Direccion.IZQUIERDA){
						 // Salta a la pila de la izquierda, n veces. (salto = n)
						 for (int i=0; i<actual.salto; i++)
							 cont--;
					 }else{
						 // Salta a la pila de la derecha
						 for (int i=0; i<actual.salto; i++)
							 cont++;
					 }
				 }
			}
		}
		if (status == GAMEOVER){
			return -1;
		}else{
			return puntuacion;
		}
		
	}

}
