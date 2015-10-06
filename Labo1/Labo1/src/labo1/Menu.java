package labo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

public class Menu {

	static ListaPelisPorActor peliculas;
	static boolean decision; //true será que si, false que no.
	static Actor unActor = null;
	static String pNombre;
	static int num;

	public static void main(String[] args) throws IOException {
		//bienvenida
		System.out.println("¡Bienvenido usuario! Cargando datos...");
		//cargamos los datos
		CatalogoActores.getCatalogoActores().CargarDatosFichero();
		
		do { //repetimos el bucle si (num != 0) 
		//imprimir por pantalla el menu de usuario
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
				do{
					System.out.println("Introduzca un nombre a buscar:");
					pNombre = br.readLine();
					unActor = new Actor(pNombre);
					//llamo al método buscarActor en CatalogoActores.java
					//si lo encuentra devuelve true, y si no, false.
					if (CatalogoActores.getCatalogoActores().buscarActor(unActor)){
						System.out.println(unActor.getNombre() + " esta en la lista.");
						decision=false;
					} else {
						System.out.println("El actor " + unActor.getNombre() + " no está.");
						System.out.println("Desea volver a intentarlo? Si o No?");
						if (br.readLine().toUpperCase().equals("SI")){//recojo la decisión, si es verdad, repito el bucle
							decision=true;
						}else{
							decision=false;
						}
					}
				}while(decision);
				break;

			case 2: //Insertar actor/actriz
				do{
					System.out.println("Introduce el nombre del actor:");
					pNombre = br.readLine();
					unActor = new Actor(pNombre);
					if (CatalogoActores.getCatalogoActores().anadirActor(unActor)){
						System.out.println("El Actor ha sido introducido correctamente!");
						decision=false;
					}else{
						System.out.println("Este actor ya existe.");
						System.out.println("Desea volver a intentarlo? Si o No?");
						if (br.readLine().toUpperCase().equals("SI")){//recojo la decisión, si es verdad, repito el bucle
							decision=true;
						}else{
							decision=false;
						}
					}
				} while(decision);
				break;

			case 3: //Borrar un actor/actriz
				do{
					System.out.println("introduce un actor a borrar");
					pNombre = br.readLine();
					unActor = new Actor(pNombre);
					//si encuentra el actor a borrar
					if (CatalogoActores.getCatalogoActores().buscarActor(unActor)) {
						System.out.println("El actor se ha eliminado");
						//falta crear metodo ELIMINAR ACTOR
						CatalogoActores.getCatalogoActores().eliminarActor(unActor);
					} else {
						//si no encuentra el actor, decide!!
						System.out.println("el actor " + pNombre + " no esta");
						System.out.println("Desea volver a intentarlo? Si o No?");
						if (br.readLine().toUpperCase().equals("SI")){//recojo la decisión, si es verdad, repito el bucle
							decision=true;
						}else{
							decision=false;
						}
					}
				}while(decision);
				break;

			case 4: //Mostrar peliculas de un actor/actriz
				
				do {
					System.out.println("Introduzca el nombre del actor:");
					pNombre = br.readLine();
					unActor = new Actor(pNombre);
					//busca si esta
					if (CatalogoActores.getCatalogoActores().buscarActor(unActor)){
						peliculas = new ListaPelisPorActor();
						// el actor que buscas tiene blablablabla peliculas....?
						peliculas.imprimirLista();
						decision=false;
					}else{
						//no esta
						System.out.println("El actor que buscas no esta, o es incorrecto.");
						System.out.println("Desea volver a intentarlo? Si o No?");
						if (br.readLine().toUpperCase().equals("SI")){//recojo la decisión, si es verdad, repito el bucle
							decision=true;
						}else{
							decision=false;
						}
					}
						
				}  while(decision);
					
				break;
				
			case 5: //Mostrar reparto de una pelicula
				System.out.println("Introduzca el nombre de la pelicula:");
				pNombre = br.readLine();
				//reparto = CatalogoPelis.getCatalogoPelis();
				//???? reparto = CatalogoPelis.getCatalogoPelis().listaPeliCadaActor();
				CatalogoPelis.getCatalogoPelis().
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
				PrintWriter writer = new PrintWriter("src/archivo/copiaLista2.txt");
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