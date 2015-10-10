package labo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

public class Menu {

	static boolean decision; //true será que si, false que no.
	static Actor unActor = null;
	static String pNombre;
	static int num;
	static Pelicula pPeli;
	static float donaciones;
	
	public static void main(String[] args) throws IOException {
		//bienvenida
		System.out.println("¡Bienvenido usuario! Cargando datos...");
		//cargamos los datos
		Stopwatch timer = new Stopwatch();
		CatalogoActores.getCatalogoActores().CargarDatosFichero();
		System.out.println(timer.elapsedTime()	); 
		
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
					//llamo al método buscarActor en CatalogoActores.java
					//si lo encuentra devuelve true, y si no, false.
					if (CatalogoActores.getCatalogoActores().estaActor(pNombre)){
						System.out.println(pNombre + " esta en la lista.");
						decision=false;
					} else {
						System.out.println("El actor " + pNombre + " no está.");
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
					Actor unActor = new Actor(pNombre);
					//Si puede añadir entra al if, si no puede añadir devuelve false entonces hace Else
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
					if (CatalogoActores.getCatalogoActores().eliminarActor(unActor)) { 
						System.out.println("El actor se ha eliminado");
						decision=false;
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
					//busca si esta
					if (CatalogoActores.getCatalogoActores().estaActor(pNombre)){
						//devuelve pelis2
						CatalogoPelis.getCatalogoPelis().listaPeliCadaActor(pNombre);
						decision=false;
					}else{
						//no esta el actor, no devuelve pelis
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
				do {
					System.out.println("Introduzca el nombre de la pelicula:");
					pNombre = br.readLine();
					//busca si esta la peli
					if (CatalogoPelis.getCatalogoPelis().existePelicula(pNombre)){
						//devuelve actores
						CatalogoActores.getCatalogoActores().listaActorCadaPeli(pNombre);
						decision=false;
					}else{
						//no esta la peli, no devuelve actores
						System.out.println("La peli que buscas no esta, o es incorrecta.");
						System.out.println("Desea volver a intentarlo? Si o No?");
						if (br.readLine().toUpperCase().equals("SI")){//recojo la decisión, si es verdad, repito el bucle
							decision=true;
						}else{
							decision=false;
						}
					}	
				}  while(decision);
				break;
				
			case 6: //Obtener una lista de actores ordenada
				System.out.println("Se va a ordenar la lista.");
				Stopwatch time = new Stopwatch();
				CatalogoActores.getCatalogoActores().ordenarActores();
				System.out.println(time.elapsedTime());
				break;

			case 7: //Hacer una donacion a una pelicula 
				System.out.println("Introduzca el nombre de la pelicula:");
				pNombre = br.readLine();
				System.out.println("Introduzca la cantidad deseada:");
				donaciones = Float.parseFloat(br.readLine());
				pPeli =CatalogoPelis.getCatalogoPelis().buscarPeli(pNombre);
				pPeli.anadirDonaciones(donaciones);
				System.out.println("La pelicula " + pPeli.getTitulo() + " tiene " + pPeli.getDonaciones() + " euros recaudados.");
				//																				<---------------------PENDIENTE
				break;
		
			case 8: //Guardar datos de peliculas a un archivo
				PrintWriter writer = new PrintWriter("src/archivo/copiaLista2.txt");
				Iterator<Actor> it = CatalogoActores.getCatalogoActores().getListaActores().values().iterator();
				while (it.hasNext()) {
					Actor UnActor = it.next();
					String linea = UnActor.getNombre();
					Iterator<Pelicula> itr = UnActor.getListaPelis().values().iterator();
					while (itr.hasNext()) { //Posibilidad de sacar este while fuera y optimizar. ? idea.
						linea = linea + " ### " + itr.next().getTitulo();
					}
					writer.println(linea);
				}
				writer.close();			
				System.out.println("Se ha guardado el nuevo catalogo en un txt.");
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