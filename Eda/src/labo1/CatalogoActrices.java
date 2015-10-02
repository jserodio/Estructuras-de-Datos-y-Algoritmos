package labo1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CatalogoActrices {
	// atributos
	ListaActrices la;
	private static CatalogoActrices miCatalogoActrices;

	// constructora
	private CatalogoActrices() {
		this.la = new ListaActrices();
	}

	// getters y setters
	public static CatalogoActrices getCatalogoActrices() {
		if (miCatalogoActrices == null) {
			miCatalogoActrices = new CatalogoActrices();
		}
		return miCatalogoActrices;
	}

	public ListaActrices getLista() {
		return this.la;
	}

	public void CargarDatosFichero() {
		try {
			Scanner entrada = new Scanner(new FileReader("src/fichero/pelis_actores.txt"));
			String linea;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String f[] = linea.split("\\s\\\\\\s");
				ListaActrices Lact = new ListaActrices();
				String peli = f[0];
				for (int i = 1; i < f.length; i++) {
					Actriz act = new Actriz(f[i]);
					Lact.insercionActriz(act);
					if (!(this.getLista().estaActriz(act.getNombre())))
						this.la.insercionActriz(act);
				}
				CatalogoPelis.getCatalogoPelis().getLista().anadirPeli(new Pelicula(peli, Lact));
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		CatalogoActrices.getCatalogoActrices().getLista().ordenarActores();
		CatalogoPelis.getCatalogoPelis().listaPeliCadaActor();
	}
}