package labo1;

import java.util.ArrayList;
import java.util.Iterator;

public  class ListaActoresPorPelicula {

	private ArrayList<Actor> la;
	private Actor[] listaOrdenada;
	
	public ListaActoresPorPelicula() { //permite acceder al arraylist (luego sera hashmap)
		this.la = new ArrayList<Actor>();
	}

	public void insercionActor(Actor UnaActor) {
		this.la.add(UnaActor);
	}

	public void borrarActor(Actor unaActor) {
		this.la.remove(unaActor);
	}

	public Iterator<Actor> getIterador() {
		return this.la.iterator();
	}

	public boolean estaActor(String pNombre) { //dice si un actor esta o no
		Iterator<Actor> itr = this.getIterador();
		boolean esta = false;
		Actor unaActor = null;
		while (!esta && itr.hasNext()) {
			unaActor = itr.next();

			if (unaActor.getNombre() == pNombre) {
				esta = true;
			}
		}
		return esta;
	}

	public Actor buscarActor(String pNombre) {
		Iterator<Actor> itr = this.getIterador();
		boolean enc = false;
		Actor unaActor=null;
		while (!enc && itr.hasNext()) {
			unaActor = itr.next();
			if (unaActor.getNombre().equals(pNombre)) {
				enc = true;
			}else{
				unaActor=null;
			}
		}
		return unaActor;
	}

	public int getTamano() { //devuelve el tama�o de la lista
		return this.la.size();
	}

	public Actor EstaEnPos(int pPos) { //nos permite conocer que actor se encuentra en una posicion dada del arraylist
		Actor unaActor = null;
		if (!this.la.isEmpty()) {
			if (pPos < getTamano() && (pPos >= 0)) {
				unaActor = this.la.get(pPos);
			}
		}
		return unaActor;
	}

	public void ordenarActores() {
		listaOrdenada = new Actor[la.size()];
		listaOrdenada = this.la.toArray(listaOrdenada);
		listaOrdenada= ordenar(listaOrdenada,0,listaOrdenada.length-1);
		this.la = new ArrayList<Actor>();
		for (int i = 0; i < listaOrdenada.length; i++) {
			System.out.println("ordenada: " + listaOrdenada[i].getNombre());
			la.add(listaOrdenada[i]);
		}
	}

		public Actor[] ordenar(Actor[] lista, int inicio, int fin){
			int i, j, central;
			Actor pivote;
			central=(inicio+fin)/2;
			pivote=lista[central];
			i=inicio;
			j=fin;
			do{
				while (lista[i].compareTo(pivote)<=0 && i<j) i++;
				while (lista[j].compareTo(pivote)>0) j--;
				if(i<=j){
					Actor tem;
					tem=lista[i];
					lista[i]=lista[j];
					lista[j]=tem;
					i++;
					j--;
				}
			}while(i<=j);
			if(inicio<j)
				ordenar(lista, inicio, j);
			if(i<fin)
				ordenar(lista, i, fin);
			return lista;
		}	
		
	public void imprimirLista(){
		Iterator<Actor> itr = this.getIterador();
		while (itr.hasNext()){
			Actor unaActor = itr.next();
			System.out.println(unaActor.getNombre());
		}
	}
}