package labo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {

	static int peliculas;
	static String reparto;
	static Actor unActor = null;
	static String pNombre;
	static int num;

	public static void main(String[] args) throws IOException {
		
		do { // Repetimos el bucle si (num != 0) 
		
		// Imprimir por pantalla el menu de usuario
		System.out.println("¡Bienvenido usuario! Cargando datos...");
		CatalogoActores.getCatalogoActores().CargarDatosFichero();
		System.out.println("\nIntroduzca la opcion deseada\n");
		System.out.println("> Opcion 1- Buscar actor/actriz");
		System.out.println("> Opcion 2- Insertar actor/actriz");
		System.out.println("> Opcion 3- Borrar un actor/actriz");
		System.out.println("> Opcion 4- Mostrar peliculas de un actor/actriz");
		System.out.println("> Opcion 5- Mostrar reparto de una pelicula");
		System.out.println("> Opcion 6- Obtener una lista de actores ordenada");
		System.out.println("> Opcion 7- Hacer una donacion a una pelicula");
		System.out.println("> Opcion 8- Guardar datos de peliculas a un archivo");
		System.out.println("> Opcion 9- Salir del menu");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Linea = br.readLine();
		num = Integer.parseInt(Linea);
		
			switch (num) {

			case 1: //buscar actor/actriz
				System.out.println("Introduzca un nombre a buscar:");
				pNombre = br.readLine();
				unActor = CatalogoActores.getCatalogoActores().la.buscarActor(pNombre);
				if (unActor == null){
					System.out.println("El actor " + pNombre + " no está.");
				} else {
					System.out.println(unActor.getNombre() + " esta en la lista.");
				}
				break;

			case 2: //Insertar actor/actriz
				System.out.println("Introduce Actor a insertar:");
				pNombre = br.readLine();
				unActor = new Actor(pNombre);
				if (CatalogoActores.getCatalogoActores().getLista().estaActor(pNombre)) {
					System.out.println("El actor ya esta introducido.");
				} else {
					System.out.println("Se va a insertar el actor " + pNombre);
					CatalogoActores.getCatalogoActores().getLista().insercionActor(unActor);
				}
				break;

			case 3: //Borrar un actor/actriz
				System.out.println("introduce un actor a borrar");
				pNombre = br.readLine();
				unActor = CatalogoActores.getCatalogoActores().getLista().buscarActor(pNombre);
				if (unActor != null) {
					System.out.println("el actor esta y se va a borrar");
					CatalogoActores.getCatalogoActores().getLista().borrarActor(unActor);
				} else {
					System.out.println("el actor " + pNombre + " no esta");
				}
				break;

			case 4: //Mostrar peliculas de un actor/actriz
				System.out.println("Introduzca el nombre del actor:");
				pNombre = br.readLine();
				unActor = CatalogoActores.getCatalogoActores().getLista().buscarActor(pNombre);
				if (unActor == null) {
					System.out.println("El actor que buscas no esta.");
				} else {
					peliculas = unActor.devolverNumPelis();
					System.out.println("El actor que buscas tiene " + peliculas	+ " pelicula(s).");
				}
				break;
				
			case 5: //Mostrar reparto de una pelicula
				System.out.println("Introduzca el nombre de la pelicula:");
				pNombre = br.readLine();
				//reparto = CatalogoPelis.getCatalogoPelis();
				//???? reparto = CatalogoPelis.getCatalogoPelis().listaPeliCadaActor();
				//Tengo que mirar como se hacia para que el mismo metodo fuera diferente
				//con diferentes parametros en la entrada... polimorfism? o algo asi?           <---------------------PENDIENTE
				break;
				
			case 6: //Obtener una lista de actores ordenada
				System.out.println("Se va a ordenar la lista.");
				CatalogoActores.getCatalogoActores().la.ordenarActores();
				break;

			case 7: //Hacer una donacion a una pelicula 
				System.out.println("Introduzca el nombre de la pelicula:");
				pNombre = br.readLine();
				//																				<---------------------PENDIENTE
				break;
		
			case 8: //Guardar datos de peliculas a un archivo
				PrintWriter writer = new PrintWriter("src/fichero/copiaLista2.txt");
				Iterator<Actor> it = CatalogoActores.getCatalogoActores().getLista().getIterador();
				while (it.hasNext()) {
					Actor UnActor = it.next();
					String linea = UnActor.getNombre();
					Iterator<Pelicula> itr = UnActor.getListaPelis().getIterador();
					while (itr.hasNext()) { //Posibilidad de sacar este while fuera y optimizar. ? idea.
						linea = linea + " \\ " + itr.next().getTitulo();
					}
					writer.println(linea);
				}
				writer.close();			
				System.out.println("Se a guardar el nuevo catalogo en un txt.");
				break;
				
			case 9: //Salir del menu
				System.out.println("Saliendo del programa... adios! :)");
				System.exit(num);
				break;
			
			default: //Si se confunde
				System.out.println("Hmmm ha introducido un valor correcto?");
				System.out.println("Recuerde! Sólo valores del 1 al 9.");
				break;
			}
			//Fin del switch case
		}while (num != 9);
	}
	//Fin del main
}
//Fin menu.java