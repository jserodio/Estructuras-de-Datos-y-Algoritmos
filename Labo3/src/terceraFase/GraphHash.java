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
	HashMap<String, ArrayList<String>> g;
	
	public void crearGrafo(HashMap<String, Actor> listaA){
		// Pre: la lista nunca está vacia
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películas
		
		Iterator<Entry<String, Actor>> iterador = listaA.entrySet().iterator();
		
		while (iterador.hasNext()){ // n
			// Por cada actor
			Entry<String, Actor> actor = iterador.next();
			// Comprobar si ya existe el nodo.
			if (!g.containsKey(actor.getKey())) // Si no esta creado el nodo, lo crea.
				g.put(actor.getKey(), CatalogoPelis.getCatalogoPelis().getListaPelis(actor.getKey())); // n
			
			Iterator<String> it = CatalogoPelis.getCatalogoPelis().getListaPelis(actor.getKey()).iterator();
			while (it.hasNext()){ // n
				// Por cada peli
				String peli = it.next();
				if(!g.containsKey(peli)){
					g.put(peli, CatalogoActores.getCatalogoActores().getArrayListaActores(peli));; // n
				}
					
			}
			System.out.println(actor);
		} // coste total del metodo completo: N ( n + N ( n )) = n(n+n^2) -> o(n^3)
		
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
		
		
		return false;
	}
	
}
