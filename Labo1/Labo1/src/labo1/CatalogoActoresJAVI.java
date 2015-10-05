package gestionactores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class CatalogoListaActores {

	private HashMap<String, Actor> lista = new HashMap<String, Actor>();
	private static CatalogoListaActores miListaActores;
	private ArrayList<Actor> listaActores = new ArrayList<Actor>();

	private CatalogoListaActores() {

	}

	public static CatalogoListaActores getCatalogoListaActores() {
		if (miListaActores != null) {
			return miListaActores;
		} else {
			return miListaActores = new CatalogoListaActores();
		}
	}

	public Actor obtenerActor(String pNombre) {
		Actor a = null;
		if (this.lista.containsKey(pNombre)) {
			a = this.lista.get(pNombre);
		}
		return a;
	}

	public void borrarActor(Actor a) {
		// si existe el actor lo borra
		if (lista.containsKey(a.getNombre())) {
			lista.remove(a.getNombre());
		}
	}

	public void addActor(Actor a) {

		lista.put(a.getNombre(), a);
	}

	public static void cargarDatos() {
		Stopwatch timer = new Stopwatch();

		String[] datosLinea;
		String nombreActor;

		String linea = null;
		Actor actor = null;
		Pelicula pelicula;
		try {

			try ( // Aqui la ruta
			// Scanner entrada = new Scanner(new FileReader(
			// "docs/listas/lista1M.txt")))
			Scanner entrada = new Scanner(new FileReader(
					"docs/listas/listaactores40000.txt"))) {
				while (entrada.hasNext()) {

					linea = entrada.nextLine();
					// Quito comillas
					// linea= linea.replace("\"", "");

					// si hay lineas en blanco pasa de ellas
					if (linea.trim().length() == 0)
						continue;
					// Cada palabra de "linea" se mete en una posiciÃ³n del
					// Array de strings "datosLinea"
					datosLinea = linea.split("\\s\\\\\\s");
					// se recorre el array de String "datosLinea"

					// Añadimos el primer elemento que es la pelicula
					pelicula = new Pelicula(datosLinea[0]);

					// mete en una posicion la peli y en la otra todo lo demas
					CatalogoListaPeliculas.getCatalogoListaPeliculas()
							.addPelicula(pelicula);

					for (int i = 1; i < datosLinea.length; i++) {
						// Ahora añadimos actores

						nombreActor = datosLinea[i];

						if (!CatalogoListaActores.getCatalogoListaActores()
								.existeActor(nombreActor)) {
							actor = new Actor(nombreActor);
							// Lo agregamos a la MAE
							//
							CatalogoListaActores.getCatalogoListaActores()
									.addActor(actor);
						}

						CatalogoListaActores.getCatalogoListaActores()
								.obtenerActor(nombreActor)
								.addPeliculaActor(pelicula);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(timer.elapsedTime());
	}

	public boolean existeActor(String nombreActor) {
		boolean existe = false;
		if (lista.containsKey(nombreActor)) {
			existe = true;
		}
		return existe;
	}

	/*
	 * private Iterator<Actor> getIterador() { return
	 * this.lista.values().iterator(); }
	 */

	public void guardarArchivo() {

		File f;
		String ruta = "C:/Users/Galder/Desktop/listados guardados/listado.txt";
		f = new File(ruta);
		// Escritura
		try {
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			// Recorro la la lista de actores y escribo en el fichero cada actor
			// con sus peliculas
			for (Entry<String, Actor> miactor : this.lista.entrySet()) {

				wr.write(miactor.getKey());// escribimos en el archivo el
				// nombre del actor
				for (int z = 0; z <= miactor.getValue().numeroPeliculasActor() - 1; z++) {
					wr.append("\t "
							+ miactor.getValue().obtenerPeliculasDeActor(z)
									.getNombre() + "\n"); // escribimos en el
															// archivo cada
															// pelicula
				}
				wr.append("\n ");
			}
			wr.close();
			bw.close();
			System.out.println("Fichero creado satisfactoriamente en " + ruta);
		} catch (IOException e) {
			System.out
					.println("Ocurrio algun error durante la creación del documento.");
		}
	}

	private Iterator<Entry<String, Actor>> getIteradorActores() {
		return lista.entrySet().iterator();
	}

	// Se mira si existe la pelicula en el catalogo de actores
	public boolean borrarPeliculaDelosActores(String nombrePelicula) {
		boolean rdo = false;
		Pelicula p = new Pelicula("");
		Iterator<Entry<String, Actor>> itr = this.getIteradorActores();
		Actor a = new Actor("");
		while (itr.hasNext()) {
			p = null;
			a = itr.next().getValue();
			// obtenemos la pelicula si ha participado sino obtenemos null
			p = a.aParticipadoEnPelicula(nombrePelicula);
			if (p != null) {
				// borramos de ese actor la pelicula
				a.borrarPelicula(p);
				rdo = true;
			}
		}
		return rdo;
	}

	public void imprimirActores() {
		Iterator<Entry<String, Actor>> itr = this.getIteradorActores();
		Actor a = new Actor("");
		while (itr.hasNext()) {
			a = itr.next().getValue();
			System.out.println("Actor: " + a.getNombre());
		}
	}

	public void imprimirActoresDeLaPelicula(String pPelicula) {

		// Comprobamos si existe la pelicula
		if (CatalogoListaPeliculas.getCatalogoListaPeliculas().existePelicula(
				pPelicula)) {

			Pelicula p = new Pelicula("");
			Iterator<Entry<String, Actor>> itr = this.getIteradorActores();
			Actor a = new Actor("");

			while (itr.hasNext()) {
				p = null;
				a = itr.next().getValue();
				// Comprobar si la el actor contiene la pelicula
				p = a.aParticipadoEnPelicula(pPelicula);
				if (p != null) {
					System.out.println("Actor: " + a.getNombre());
				}

			}

		}
	}

	// convierto el hasMap en un ArrayList<Actor>
	private ArrayList<Actor> cargarArrayList() {
		Iterator<Entry<String, Actor>> itr = this.getIteradorActores();
		Actor nuevo = new Actor("");
		while (itr.hasNext()) {
			nuevo = itr.next().getValue();
			this.listaActores.add(nuevo);
		}
		return listaActores;
	}

	public static void quicksort(ArrayList<Actor> A, int izq, int der) {
		// sobre cargo el quickSort con la propia lista, el primer indice y el
		// ultimo indice de esta

		Actor pivote = A.get(izq); // tomamos primer elemento como pivote
		int i = izq; // i realiza la búsqueda de izquierda a derecha
		int j = der; // j realiza la búsqueda de derecha a izquierda
		Actor aux;

		while (i < j) { // mientras no se crucen las búsquedas
			while (A.get(i).compareTo(pivote) <= 0 && i < j)
				i++; // busca elemento mayor que pivote
			while (A.get(j).compareTo(pivote) > 0)
				j--; // busca elemento menor que pivote
			if (i < j) { // si no se han cruzado
				aux = A.get(i); // los intercambia
				A.set(i, A.get(j));
				A.set(j, aux);
			}
		}
		A.set(izq, A.get(j)); // se coloca el pivote en su lugar de forma que
								// tendremos
		A.set(j, pivote); // los menores a su izquierda y los mayores a su
							// derecha
		if (izq < j - 1)
			quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < der)
			quicksort(A, j + 1, der); // ordenamos subarray derecho
	}

	private void ordenarActores() {
		// utilizo el metodo quickSort reescrito para ordenar la lista
		// y la imprimo por pantalla;
		CatalogoListaActores.quicksort(this.listaActores, 0,
				this.listaActores.size() - 1);// //numeros de Elementos real
		Iterator<Actor> itr = this.listaActores.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getNombre());
		}
	}

	public void imprimirOrdenada() {
		this.listaActores = this.cargarArrayList();
		this.ordenarActores();
	}

}
