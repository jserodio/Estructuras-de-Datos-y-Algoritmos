package labo1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	
	public void ordenarActores() {
		//este metodo ordena el hashmap de actores e imprime los resultados
		//pre: el hashmap "listaA" no está ordenado
		//post: se imprime por pantalla el resultado de la lista de actores ordenada.
		SortedSet<String> sortedSet = new TreeSet<String>(listaA.keySet());
		//Utilizo treeSet para crear un sorted set (una lista ordenada, de la key)
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
//		//pre: Contiene al menos un actor
//		//post: Imprime la lista de los actores.
//		Iterator<Actor> itr = listaA.values().iterator();
//		while (itr.hasNext()){
//			Actor actor = (Actor)itr.next();
//			System.out.println(actor.getNombre());
//		}
//	}
	
	public void CargarDatosFichero() {
		//Cargamos los datos del fichero
		//pre: Archivo contiene datos. Existe al menos un actor y una pelicula.
		//post: Se cargan los datos del fichero en:
		//		"Catalogo de Actores"
		//		"Catalogo de Peliculas"
		//		"Catalogo de Actores dada una Pelicula"
		//		"Catologo de Peliculas dado un Actor"
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
				Actor act= new Actor(actor);//una instancia del objeto Actor por cada nombre.
				CatalogoActores.getCatalogoActores().anadirActor(act); //añado el actor, al catalogo
				for (int i = 1; i < f.length; i++) {				
					String titulo=f[i];
					Pelicula p=CatalogoPelis.getCatalogoPelis().anadirPeli(titulo);//añade la pelicula al catalogo en caso de no estar cargado anteriormente
					act.anadirPeli(p);//añadimos la pelicula a la listapelis del actor
					p.anadirActor(act);//añade actor actual, a la lista de actores, de la pelicula dada
				}
			}
			entrada.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> getArrayListaActores(String pPeli) {
		//este metodo nos dira para una pelicula dada, la lista de actores que participan en ella
		Pelicula pelicula = CatalogoPelis.getCatalogoPelis().buscarPeli(pPeli);
			if (pelicula!= null){
				ArrayList<String> actores = pelicula.getActores();
				return actores;
			}else{
				return null;
			}
	}

	public int cuantosHay(){
		return listaA.size();
	}
}