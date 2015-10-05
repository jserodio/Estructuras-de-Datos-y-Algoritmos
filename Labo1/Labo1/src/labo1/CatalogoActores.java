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
				String[] f = linea.split(" ### ");
				ListaActoresPorPelicula lAct = null; 
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
						//---------------------------------
						
						
						String nombrePeliAux= f[i];
						Pelicula peli =new Pelicula(nombrePeliAux, lAct);
						System.out.println(peli);
						act.getListaPelis().anadirPeli(peli);// añado para el actor actual, cada pelicula que tenga
						peli.getLista().insercionActor(act);//añado, para cada pelicula, el actor que actua.
						CatalogoPelis.getCatalogoPelis().getLista().anadirPeli(peli);// añado al catalogo la pelicula actual.
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
		CatalogoPelis.getCatalogoPelis().listaPeliCadaActor();
		

	}
}