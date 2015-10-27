package labo1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class CatalogoActores {
	// atributos
	private HashMap<String, Actor> listaA;
	private static CatalogoActores miCatalogoActores;

	// constructora
	private CatalogoActores() {
		this.listaA = new HashMap<String, Actor>();
	}

	// getters y setters
	public static CatalogoActores getCatalogoActores() {
		if (miCatalogoActores == null) {
			miCatalogoActores = new CatalogoActores();
		}
		return miCatalogoActores;
	}
	
	public HashMap<String,Actor> getListaActores(){
		return this.listaA;
	}
	
	
	public boolean estaActor(String pActor) {

		//Si encuentra un actor con ese nombre, verdad; si no, mentiro!
		if(this.listaA.containsKey(pActor)) return true; else return false;

	}
	
	public Actor buscarActor(String pNombre){
		return CatalogoActores.getCatalogoActores().listaA.get(pNombre);
	}
	
	public boolean anadirActor(Actor unActor){

		//Si encuentra NO encuentra el actor, a�adelo
		if(! estaActor(unActor.getNombre()) ){
			this.listaA.put(unActor.getNombre(), unActor);
			//retorna verdad que se ha a�adido correctamente
			return true;
		}else{
			//retorna falso si ya exist�a el actor!
			return false;
		}
	}

	public boolean eliminarActor(Actor unActor) {
		//si est� el actor lo borras
		if(estaActor(unActor.getNombre())){
			this.listaA.remove(unActor);
			return true;
		}else{
			return false;
		}
	}
	
	public void ordenarActores() {
		//Utilizo treeSet para crear un sorted set (una lista ordenada, de la key)
		SortedSet<String> sortedSet = new TreeSet<String>(listaA.keySet());
		Iterator<String> itrOrdenada = sortedSet.iterator();
		while (itrOrdenada.hasNext()){
			String actor = itrOrdenada.next(); // apunta al primero
			System.out.println(actor);
		}
	}
	
	public void  listaActorCadaPeli(String unaPelicula){ 
		//este metodo nos dira para una pelicula dada, la lista de actores que participan en ella
		Pelicula peli = CatalogoPelis.getCatalogoPelis().buscarPeli(unaPelicula);
			if (peli!= null){
				peli.obtenerActores();
			} else System.out.println("La pelicula introducida no existe");
	}
	
//	public void listaActores(){
//		//muestra la lista de actores
//		Iterator<Actor> itr = listaA.values().iterator();
//		while (itr.hasNext()){
//			Actor actor = (Actor)itr.next();
//			System.out.println(actor.getNombre());
//		}
//	}
	
	public void CargarDatosFichero() {
		//Cargamos los datos del fichero
		//pre:
		//post
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
				Actor act= new Actor(actor);
				CatalogoActores.getCatalogoActores().anadirActor(act); //a�ado el actor, al catalogo
				for (int i = 1; i < f.length; i++) {				
					String titulo=f[i];
					Pelicula p=CatalogoPelis.getCatalogoPelis().anadirPeli(titulo);//a�ade la pelicula al catalogo en caso de no estar cargado anteriormente
					act.anadirPeli(p);//a�adimos la pelicula a la listapelis del actor
					p.anadirActor(act);//a�ade actor actual, a la lista de actores, de la pelicula dada
				}
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