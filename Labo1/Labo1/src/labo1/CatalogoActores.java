package labo1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CatalogoActores {
	// atributos
	ListaActores la;
	private static CatalogoActores miCatalogoActores;

	// constructora
	private CatalogoActores() {
		this.la = new ListaActores();
	}

	// getters y setters
	public static CatalogoActores getCatalogoActores() {
		if (miCatalogoActores == null) {
			miCatalogoActores = new CatalogoActores();
		}
		return miCatalogoActores;
	}

	public ListaActores getLista() {
		return this.la;
	}

	public void CargarDatosFichero() {
		try {
			Scanner entrada = new Scanner(new FileReader("src/archivo/actors-movies-2015-2016"));
			String linea;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String f[] = linea.split("");
				ListaActores Lact = new ListaActores();
				String peli = f[0];
				for (int i = 1; i < f.length; i++) {
					Actor act = new Actor(f[i]);
					Lact.insercionActor(act);
					if (!(this.getLista().estaActor(act.getNombre())))
						this.la.insercionActor(act);
				}
				CatalogoPelis.getCatalogoPelis().getLista().anadirPeli(new Pelicula(peli, Lact));
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		CatalogoActores.getCatalogoActores().getLista().ordenarActores();
		CatalogoPelis.getCatalogoPelis().listaPeliCadaActor();
	}
}