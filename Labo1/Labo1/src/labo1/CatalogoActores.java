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
	
	public boolean estaActor(String pActor) {
		//Si encuentra un actor con ese nombre, verdad; si no, mentiro!
		if(this.listaA.containsKey(pActor)) return true; else return false;
	}
	
	public Actor buscarActor(String pNombre){
		return CatalogoActores.getCatalogoActores().listaA.get(pNombre);
	}
	
	public boolean anadirActor(Actor unActor){
		//Si encuentra NO encuentra el actor, añadelo
		if(! estaActor(unActor.getNombre()) ){
			this.listaA.put(unActor.getNombre(), unActor);
			//retorna verdad que se ha añadido correctamente
			return true;
		}else{
			//retorna falso si ya existía el actor!
			return false;
		}
	}

	public boolean eliminarActor(Actor unActor) {
		//si está el actor lo borras
		if(estaActor(unActor.getNombre())){
			this.listaA.remove(unActor);
			return true;
		}else{
			return false;
		}
	}
	
	public void  listaActorCadaPeli(String unaPelicula){ 
		//este metodo nos dira para una pelicula dada, la lista de actores que participan en ella
		Pelicula peli = CatalogoPelis.getCatalogoPelis().buscarPeli(unaPelicula);
			if (peli!= null){
				peli.obtenerActores();
			} else System.out.println("La pelicula introducida no existe");
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
						act.anadirPeli(p);//añadimos la pelicula a la listapelis del actor
						p.anadirActor(act);
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

	public void ordenarActores() {
		//hay que hacer
		
	}




}