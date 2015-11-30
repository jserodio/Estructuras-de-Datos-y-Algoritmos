package terceraFase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
			HashSet<String> visitados = new HashSet<String>();
			sinExaminar.push(a1);
			boolean enc = false;
			
			while(!sinExaminar.isEmpty() && !enc){
				String act= sinExaminar.pop();
				if(act.equals(a2)){
					enc=true;
				}
				ArrayList<String> lPa1= g.get(act);
				for(int i = 0; i<lPa1.size();i++){
					ArrayList<String> lAp1 = g.get(lPa1.get(i));
					for(int j = 0 ; j<lAp1.size();j++){
						String actor = lAp1.get(j);
						if (!visitados.contains(actor)){
							sinExaminar.push(actor);
							visitados.add(actor);
						}
					}
				}
				
			
			}
			System.out.println(enc);
			return enc;
		}
	}

			
