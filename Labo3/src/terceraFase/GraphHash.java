package terceraFase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import labo1.*;

public class GraphHash {

	HashMap<String, ArrayList<String>> g;
	
	public void crearGrafo(HashMap<String, Actor> listaA){
		// Pre: la lista nunca está vacia
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películas
		Iterator<Entry<String, Actor>> iterador = listaA.entrySet().iterator();
		while (iterador.hasNext()){
			Entry<String, Actor> actor = iterador.next();
			// leemos cada actor
			g.put(actor.getKey(), CatalogoPelis.getCatalogoPelis().getListaPelis(actor.getKey() ));
			// mirar metodo obtenerpelis, dentro de getListaPelis.
			System.out.println(actor);
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
	
	public boolean estanConectados(String a1, String a2)
            // COMPLETAR CÓDIGO
}
