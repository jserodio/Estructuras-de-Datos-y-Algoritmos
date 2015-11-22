package terceraFase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import labo1.Actor;
import labo1.CatalogoPelis;

public class Graph {
	HashMap<String, Integer> th; // String es la key, Integer es el índice del ArrayList al que se referencia.
      String[] keys;
      ArrayList<Integer>[] adjList; // adjList[1] = [1 , 2 , 3 , 4]
	
	public void crearGrafo(HashMap<String, Actor> lActores){
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películas
		
		Iterator<Entry<String, Actor>> iterador = lActores.entrySet().iterator();
		for (int i = 0; i<lActores.size(); i++){
			Entry<String, Actor> actor = iterador.next();
			// leemos cada actor
			th.put(actor.getKey(), i ); // llenamos el th
			// después de añadir la fila de hashmap (perro-0; gato-1)
			// Paso 2: llenar “keys”
			keys = new String[th.size()];
			for (int i = 0; i < actor.getValue().; i++)
			
						
		}
         
		for (String k: th.keySet()) keys[th.get(k)] = k;

            // Paso 3: llenar “adjList”
            // COMPLETAR CÓDIGO
	}
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean estanConectados(String a1, String a2){
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean enc = false;
		boolean[] examinados = new boolean[th.size()];

                 // COMPLETAR CÓDIGO
		
		return enc;

	}
}
