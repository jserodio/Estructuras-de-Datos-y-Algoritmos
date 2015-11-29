package terceraFase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import labo1.*;



public class GraphHash {
	// grafo
	HashMap<String, ArrayList<String>> g = new HashMap<String, ArrayList<String>>();

	public void crearGrafo(){
//       Los nodos son nombres de actores y títulos de películas
		CatalogoActores listaA = CatalogoActores.getCatalogoActores(); //cogemos el catalogo de actores
		Iterator<Actor> itr = listaA.getListaActores().values().iterator();//creamos el iterador para la lista de actores
		while(itr.hasNext()){//recorremos la lista de actores
			Actor a1 = itr.next();//un actor
			if(!g.containsKey(a1.getNombre())){//si el hashmap que hemos creado no contiene al actor......
				g.put(a1.getNombre(), a1.getNombrePelis());//...... lo introducimos.
			}
			ArrayList<Pelicula> l1 = a1.getPelis();//para cada actor, cogemos su lista de peliculas y las metemos en el array.
			for(int j=0;j<l1.size();j++){//recorremos la lista que acabamos de crear
				if(!g.containsKey(l1.get(j).getTitulo())){//si no esta la pelicula en  la lista.....
					g.put(l1.get(j).getTitulo(),l1.get(j).getActores());//.....la añadimos
				}
			}
		print();
		 																																				
		}
	}
		
		public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	public boolean estanConectados(String a1, String a2){
		// COMPLETAR CÓDIGO*/
		return false;
	}

            
//	public CatalogoActores obtenerColegas(Actor unActor){
//		
//		TreeSet<Actor> tree = new TreeSet<Actor>();
//		for (int a = 0; a < CatalogoActores.getCatalogoActores().getListaActores().size(); a++) {   //recorre todos los actores
//			Actor act = CatalogoActores.getCatalogoActores().getListaActores().get(unActor); // esta mal creo
//			for (int p = 0; p < act.getListaPelis().size(); p++) {   //recorre las pelis de actor actual
//				Pelicula peli = act.getListaPelis().get(peli);//esta mal creo
//				for (int ap = 0; ap < peli.getActores().size(); ap++) {    // recorre los actores de la peli del actor actual
//					Actor comparar=peli.getLista().EstaEnPos(ap); //no se que poner para que funcione con el hashmap
//					if(!this.equals(comparar) && !tree.contains(act) && !this.equals(act) && peli.getActores().contains() { //no se que meter aqui
//							this.getListaColegas().insercionActriz(act);   //si esta le metemos en listaColegas
//							tree.add(act);
//		return null;
//	}
}
			
