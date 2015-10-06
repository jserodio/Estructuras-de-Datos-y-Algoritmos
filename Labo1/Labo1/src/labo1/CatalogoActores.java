package labo1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class CatalogoActores {
	// atributos
	private HashMap<String, Actor> listaA;
	private static CatalogoActores miCatalogoActores;

	// constructora
	private CatalogoActores() {
		this.listaA = new HashMap<>();
	}

	// getters y setters
	public static CatalogoActores getCatalogoActores() {
		if (miCatalogoActores == null) {
			miCatalogoActores = new CatalogoActores();
		}
		return miCatalogoActores;
	}
	public void anadirActor(Actor unActor){
		if(!this.listaA.containsKey(unActor.getNombre())){
			this.listaA.put(unActor.getNombre(), unActor);
		}
	}


	public void CargarDatosFichero() {
		try {
			Scanner entrada = new Scanner(new FileReader("src/archivo/10-actors.txt"));
			String linea;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				if(linea.trim().length() == 0){
					continue;
				}
				String f[] = linea.split(" ### ");
				ListaActoresPorPelicula lAct = new ListaActoresPorPelicula();
				String actor = f[0];
				System.out.println(actor);
				Actor act= new Actor(actor);
				CatalogoActores.getCatalogoActores().anadirActor(act); //añado el actor, al catalogo
				
				for (int i = 1; i < f.length; i++) {

					if(f[1] !=null){ //si no hay pelicula, pasar a otro actor.
						//----------javi------------------
						String titulo=f[i];
						//añade el actor a la peli actual
						Pelicula p=new Pelicula(titulo);
						CatalogoPelis.getCatalogoPelis().anadirPeli(p);
						CatalogoPelis.getCatalogoPelis().anadirActorAListaDePelis(p, actor);
						//---------------------------------
					//if (!(this.getLista().estaActor(act.getNombre())))
					//	this.la.insercionActor(act);
					}
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
		

	}
}