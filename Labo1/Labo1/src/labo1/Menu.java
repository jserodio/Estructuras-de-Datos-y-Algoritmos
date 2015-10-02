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

	static Actriz unaActriz = null;
	static String pNombre;
	static int num;

	public static void main(String[] args) throws IOException {
		System.out.println("Se van a cargar los datos, espere un momento.");
		CatalogoActrices.getCatalogoActrices().CargarDatosFichero();
		System.out.println("*****************");
		System.out.println("MENU DEL PROGRAMA:");
		System.out.println("*****************");
		System.out.println("- Opcion 1: busqueda de un actor/actriz");
		System.out.println("- Opcion 2: insertar nuevo actor actriz");
		System.out
				.println("- Opcion 3: devolver numero de peliculas de un actor dado");
		System.out.println("- Opcion 4: borrar actor/actriz");
		System.out.println("- Opcion 5: guardar lista en fichero");
		System.out.println("- Opcion 6: ordenar lista actores/actrices");
		System.out.println("- Opcion 7: salir del menu. ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Linea = br.readLine();
		num = Integer.parseInt(Linea);

		while (num != 0) {

			switch (num) {

			case 1:
				System.out.println("Introduce un nombre a buscar:");
				pNombre = br.readLine();
				unaActriz = CatalogoActrices.getCatalogoActrices().la
						.buscarActriz(pNombre);
				// System.out.println(unaActriz.getNombre()); prueba
				if (unaActriz == null) {
					System.out.println("El actor que buscas no esta.");
				} else {
					System.out.println(unaActriz.getNombre()
							+ " esta en la lista.");
				}
				break;

			case 2:
				System.out.println("Introduce Actriz a insertar:");
				pNombre = br.readLine();
				unaActriz = new Actriz(pNombre);
				if (CatalogoActrices.getCatalogoActrices().getLista()
						.estaActriz(pNombre)) {
					System.out.println("El actor ya esta introducido.");
				} else {
					System.out.println("Se va a insertar el actor " + pNombre);
					CatalogoActrices.getCatalogoActrices().getLista()
							.insercionActriz(unaActriz);
				}
				break;

			case 3:
				System.out
						.println("Introduce un actor para saber su numero de peliculas:");
				pNombre = br.readLine();
				unaActriz = CatalogoActrices.getCatalogoActrices().getLista()
						.buscarActriz(pNombre);
				if (unaActriz == null) {
					System.out.println("El actor que buscas no esta.");
				} else {
					int peliculas = unaActriz.devolverNumPelis();
					System.out.println("El actor que buscas tiene " + peliculas
							+ " pelicula(s).");
				}

				break;

			case 4:
				System.out.println("introduce un actor a borrar");
				pNombre = br.readLine();
				unaActriz = CatalogoActrices.getCatalogoActrices().getLista()
						.buscarActriz(pNombre);
				if (unaActriz != null) {
					System.out.println("el actor esta y se va a borrar");
					CatalogoActrices.getCatalogoActrices().getLista()
							.borrarActriz(unaActriz);
				} else {
					System.out.println("el actor " + pNombre + " no esta");
				}
				break;

			case 5: {
				PrintWriter writer = new PrintWriter(
						"src/fichero/copiaLista2.txt");
				Iterator<Actriz> it = CatalogoActrices.getCatalogoActrices()
						.getLista().getIterador();
				while (it.hasNext()) {
					Actriz UnaActriz = it.next();
					String linea = UnaActriz.getNombre();
					Iterator<Pelicula> itr = UnaActriz.getListaPelis()
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
				CatalogoActrices.getCatalogoActrices().la.ordenarActores();
				break;

			case 7:
				System.out.println("El programa se ha cerrado, adios :)");
				num = 0;
				System.exit(num);
			}
			System.out.println("*****************");
			System.out.println("MENU DEL PROGRAMA:");
			System.out.println("*****************");
			System.out.println("- Opcion 1: busqueda de un actor/actriz");
			System.out.println("- Opcion 2: insertar nuevo actor actriz");
			System.out
					.println("- Opcion 3: devolver numero de peliculas de un actor dado");
			System.out.println("- Opcion 4: borrar actor/actriz");
			System.out.println("- Opcion 5: guardar lista en fichero");
			System.out.println("- Opcion 6: ordenar lista actores/actrices");
			System.out.println("- Opcion 7: salir del menu. ");
			num = Integer.parseInt(br.readLine());
		}
	}
}