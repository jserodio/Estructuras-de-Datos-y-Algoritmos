package labo4;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;

import labo1.Actor;
import labo1.CatalogoActores;
import labo1.Pelicula;
import labo1.Stopwatch;

public class GraphHash {

	// grafo
		HashMap<String, ArrayList<String>> g = new HashMap<String, ArrayList<String>>();

		public void crearGrafo(){
//	       Los nodos son nombres de actores y títulos de películas
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
	
	private static Scanner sc = new Scanner(System.in);
	
	private GraphHash(){}
	
	public static void MainMenu() throws FileNotFoundException, UnsupportedEncodingException{
		 boolean salir = false; 
	     while(!salir){ 
		     System.out.println("Menu:\n");
		     System.out.println("1- Cargar lista de actores.\n");
		     System.out.println("2- Calcular el grado de relaciones de dos actores.\n");
		     System.out.println("3- Calcular el grado de centralidad.\n");
		     System.out.println("4- EXIT");
		     int resp = sc.nextInt(); 
			     switch(resp){ 
				     case(1):
				    	 CatalogoActores.getCatalogoActores().CargarDatosFichero();
				     break;
				     
				     case (2):
				    	 RelationDegree();
				     break;
				     
				     case(3):
				    	 calculateCentrality(0);
				     break;  
				     case(4):
				    	sc.close();
				     	salir = true;
				     break;
				     
				     default:
				    	 System.out.println("Solo valores del 1 al 4.\n");
				     break;
			     }
	     }             
	}
	
	private static int CalculateRelation(Actress firstActr, Actress secondActr, int opt){
		boolean related = false;
		String firstActressName = firstActr.getName();
		String secondActressName = secondActr.getName();
		HashMap<String, String> relationPath = new HashMap<String, String>();
		Actress currActr = null;
		ActressList actrList = new ActressList();
		//First we are going to check if those actresses are related with an intermediate actress (3 way relationship)
		//Create a support structure in order to add the pending elements (Elements that has not been reviewed yet)
		Queue<Actress> pending = new LinkedList<Actress>();
		Iterator<Actress> itActr = secondActr.getCoStarsList().getIterator();
		while (itActr.hasNext()){
			//Add all the Actresses to the pending queue
			currActr = itActr.next();
			pending.add(currActr);
			relationPath.put(currActr.getName(), secondActr.getName());
		}
		//So in this point we have added the second's actress co-stars to the pending list
		//Now we are going to iterate through each co-star list of the second actress in order to add the co-stars to the pending list
		//We iterate until the queue is empty
		//This implementation keeps it simple
		String actrName = null;
		while (!pending.isEmpty() && !related){
			//Gets the first pending Actress
			currActr = pending.poll();
			actrName = currActr.getName();
			//If the pending Actress name matches with the first actress name then
			if (actrName.equals(firstActressName)){
				//they are related
				related = true;
				}else{
					//If that actress has not been reviewed or revised
					if (!actrList.exists(currActr.getName())){
						//adds the current actress to the reviewed list
						actrList.addActress(currActr);
						//Gets an Iterator to iterate through each co-star of that actress
						itActr = currActr.getCoStarsList().getIterator();
						//Adds all its co-stars to the auxiliar pending queue if they haven't been revised
						while (itActr.hasNext()){
							currActr = itActr.next();
							if (!actrList.exists(currActr.getName())){
								if (!relationPath.containsKey(currActr.getName()))
									relationPath.put(currActr.getName(), actrName);
								pending.add(currActr);
							}
						}	
					}
				}
			}
		//If the actresses are related
		int iterationN = 0;
		if (related){
			//If the option parameter is equal to 0
			if (opt == 0){
				//Retrieves the distance that exists between the first actress and the second one
				//It uses back-pointers with an auxiliar data structure (HashMap)
				//Builds the path from the last actress to the first one
				String path = relationPath.get(firstActressName);
				while (!path.equals(secondActressName)){
					path = relationPath.get(path);
					iterationN++;
				}
			}
			if (opt == 1){
				//Gets all the actresses that participated on the calculated relation path
				String path = relationPath.get(firstActressName);
				Actress actr = ActressDB.getInstance().searchByName(path);
				actr.incrementCentrality();
				while (!path.equals(secondActressName)){
					path = relationPath.get(path);
					actr = ActressDB.getInstance().searchByName(path);
					actr.incrementCentrality();
				}
			}
		}
		return iterationN;
	}
}