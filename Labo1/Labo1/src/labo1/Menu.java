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

	static Actor unActor = null;
	static String pNombre;
	static int num;

	public static void main(String[] args) throws IOException {
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
		System.out.println("> Opcion 9- salir del menu. ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Linea = br.readLine();
		num = Integer.parseInt(Linea);

		while (num != 0) {

			switch (num) {

			case 1:
				System.out.println("Introduzca un nombre a buscar:");
				pNombre = br.readLine();
				unActor = CatalogoActores.getCatalogoActores().la
						.buscarActor(pNombre);
				// System.out.println(unActor.getNombre()); prueba
				if (unActor == null) {
					System.out.println("El actor "+pNombre+" no está."); // ME HE QUEDADO AQUIII
				} else {
					System.out.println(unActor.getNombre()
							+ " esta en la lista.");
				}
				break;

			case 2:
				System.out.println("Introduce Actor a insertar:");
				pNombre = br.readLine();
				unActor = new Actor(pNombre);
				if (CatalogoActores.getCatalogoActores().getLista()
						.estaActor(pNombre)) {
					System.out.println("El actor ya esta introducido.");
				} else {
					System.out.println("Se va a insertar el actor " + pNombre);
					CatalogoActores.getCatalogoActores().getLista()
							.insercionActor(unActor);
				}
				break;

			case 3:
				System.out.println("introduce un actor a borrar");
				pNombre = br.readLine();
				unActor = CatalogoActores.getCatalogoActores().getLista()
						.buscarActor(pNombre);
				if (unActor != null) {
					System.out.println("el actor esta y se va a borrar");
					CatalogoActores.getCatalogoActores().getLista()
							.borrarActor(unActor);
				} else {
					System.out.println("el actor " + pNombre + " no esta");
				}
				break;

			case 4:

				System.out
						.println("Introduce un actor para saber su numero de peliculas:");
				pNombre = br.readLine();
				unActor = CatalogoActores.getCatalogoActores().getLista()
						.buscarActor(pNombre);
				if (unActor == null) {
					System.out.println("El actor que buscas no esta.");
				} else {
					int peliculas = unActor.devolverNumPelis();
					System.out.println("El actor que buscas tiene " + peliculas
							+ " pelicula(s).");
				}

				break;
				
			case 5: {
				PrintWriter writer = new PrintWriter(
						"src/fichero/copiaLista2.txt");
				Iterator<Actor> it = CatalogoActores.getCatalogoActores()
						.getLista().getIterador();
				while (it.hasNext()) {
					Actor UnActor = it.next();
					String linea = UnActor.getNombre();
					Iterator<Pelicula> itr = UnActor.getListaPelis()
							.getIterador();
					while (itr.hasNext()) {
						linea = linea + " \\ " + itr.next().getTitulo();
					}
					writer.println(linea);
				}
				writer.close();

			}
				System.out.println("Se a guardar el nuevo catalogo en un txt.");
				break;
			case 6:
				System.out.println("Se va a ordenar la lista.");
				CatalogoActores.getCatalogoActores().la.ordenarActores();
				break;

			case 7:
				System.out.println("El programa se ha cerrado, adios :)");
				num = 0;
				System.exit(num);
			}

		}
	}
}