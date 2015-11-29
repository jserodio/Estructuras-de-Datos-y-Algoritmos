package terceraFase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

import labo1.*;

public class GraphHash {
	// grafo
	HashMap<String, ArrayList<String>> g = new HashMap<String, ArrayList<String>>();

	public void crearGrafo(){
//       Los nodos son nombres de actores y títulos de películas
		CatalogoActores listaA = CatalogoActores.getCatalogoActores();
		Iterator<Actor> itr = listaA.getListaActores().values().iterator();
		while(itr.hasNext()){
			Actor a1 = itr.next();
			if(!g.containsKey(a1.getNombre())){
				g.put(a1.getNombre(), a1.getNombrePelis());
			}
			ArrayList<Pelicula> l1 = a1.getPelis();
			for(int j=0;j<l1.size();j++){
				if(!g.containsKey(l1.get(j).getTitulo())){
					g.put(l1.get(j).getTitulo(),l1.get(j).getActores());
				}
			}
		 
		}
		print();
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
		
		Stack<String> sinExaminar = new Stack<String>();
		sinExaminar.push(a1);
		boolean enc = false;
		Boolean[] visitados = new Boolean[g.size()];
		//System.out.println("-------------------------" + g.size() + "--------------");
		int i = 0;
		Iterator<String> it = g.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			visitados[i] = false;
			i++;
		}
	//	int posa1 = buscar(a1);
	//	visitados[posa1] = true;
		/*while(!sinExaminar.isEmpty() && !enc){
		
		}*/
		return false;
	}
	
	public int buscar(String a1){
		int i=0;
		boolean enc = false;
		Iterator<Entry<String, ArrayList<String>>> it = g.entrySet().iterator();
		while(it.hasNext() && !enc){
			if(g.entrySet().iterator().next().getKey().equals(a1)){
				enc = true;
			} else i++;
		}
		return i;
	}
            
}
