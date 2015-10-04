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
			Scanner entrada = new Scanner(new FileReader("src/archivo/10-actors.txt"));
			String linea;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String f[] = linea.split(" ### ");
				ListaActores lAct = new ListaActores(); 
				String actor = f[0];
				Actor act= new Actor(actor);
				CatalogoActores.getCatalogoActores().getLista().insercionActor(act); //añado el actor, al catalogo
				for (int i = 1; i < f.length; i++) {
					Pelicula peli =new Pelicula(f[i], lAct);
					act.getListaPelis().anadirPeli(peli);// añado para el actor actual, cada pelicula que tenga
					peli.getLista().insercionActor(act);//añado, para cada pelicula, el actor que actua.
					CatalogoPelis.getCatalogoPelis().getLista().anadirPeli(peli);// añado al catalogo la pelicula actual.
					//if (!(this.getLista().estaActor(act.getNombre())))
					//	this.la.insercionActor(act);
					
				}
				//act.getListaPelis().imprimirLista();
				//lAct.imprimirLista();
				//lP.imprimirLista();
				//CatalogoPelis.getCatalogoPelis().getLista().anadirPeli(peli, lAct);
			}
			
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//CatalogoActores.getCatalogoActrices().getLista().ordenarActores();
		//CatalogoPelis.getCatalogoPelis().listaPeliCadaActor();
	

		//CatalogoActores.getCatalogoActores().getLista().ordenarActores();
		CatalogoPelis.getCatalogoPelis().listaPeliCadaActor();
		

	}
}