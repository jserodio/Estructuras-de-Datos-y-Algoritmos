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
			Stack<String> sinExaminar = new Stack<String>(); //hacemos la pila con la que vamos a trabajar
			HashSet<String> visitados = new HashSet<String>(); //creamos un HashSet en el cual estaran los actores ya visitados
			sinExaminar.push(a1); // hacemos push a la pila y ponemos el actor en lo alto de esta
			boolean enc = false; // creamos un booleano para cuando encontremos el actor no siga dando vueltas de mas
			
			while(!sinExaminar.isEmpty() && !enc){ // entramos en el bucle
				String act= sinExaminar.pop(); // sacamos el primer elemento de la pila y lo borramos
				if(act.equals(a2)){ //verificamos a ver si el elemento de lo alto de la pila es el que estamos buscando
					enc=true; // si es asi, enc = true y acabamos;
				}
				ArrayList<String> lPa1= g.get(act); // cogemos los values del actor del HashMap que hemos hecho antes a la hora de hacer crearGrafo
				for(int i = 0; i<lPa1.size();i++){ // recorremos las peliculas una por una
					ArrayList<String> lAp1 = g.get(lPa1.get(i)); // cogemos los values de la pelicula del HashMap que hemos hecho antes con lo del grafo
					for(int j = 0 ; j<lAp1.size();j++){ // recorremos los actores uno por uno
						String actor = lAp1.get(j); // recogemos el actor en una variable
						if (!visitados.contains(actor)){ // verificamos si esta en la lista de visitados y en caso de no estar hacemos 
							sinExaminar.push(actor); // Lo ponemos en el top de la pila
							visitados.add(actor); //Lo añadimos a visitados
						}
					}
				}
				
			
			}
			return enc;
		}
}