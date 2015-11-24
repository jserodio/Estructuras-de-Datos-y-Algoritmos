package terceraFase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import labo1.*;

public class GraphHash {

	static HashMap<String, ArrayList<String>> g;
	
	public static void crearGrafo(CatalogoActores listaA){
		// Pre: la lista nunca está vacia
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películasç
		
		listaA.devolverActorEnPos(1);
		
		/*for(int i=0; i<listaA.cuantosHay(); i++){ 
			Actor a1 = listaA.devolverActorEnPos(i); 
			if(!g.containsKey(a1)){
				g.put(a1.getNombre(), a1.getNombresPelis());  
				ArrayList<Pelicula> l = a1.getPelis();
				for(int j=0;j<l.size();j++){ 
					if(!g.containsKey(l.get(j))){
						g.put(l.get(j).getTitulo(), l.get(j).getNombresActores());
					}
				}
			}
		}*/
	}

	/*public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}

	
	public boolean estanConectados(String a1, String a2)
            // COMPLETAR CÓDIGO*/
}
