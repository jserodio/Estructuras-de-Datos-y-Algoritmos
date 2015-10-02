package labo1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaActrices {

	private ArrayList<Actriz> la;
	private Actriz[] listaOrdenada;
	
	public ListaActrices() {
		this.la = new ArrayList<Actriz>();
	}

	public void insercionActriz(Actriz UnaActriz) {
		this.la.add(UnaActriz);
	}

	public void borrarActriz(Actriz unaActriz) {
		this.la.remove(unaActriz);
	}

	public Iterator<Actriz> getIterador() {
		return this.la.iterator();
	}

	public boolean estaActriz(String pNombre) {
		Iterator<Actriz> itr = this.getIterador();
		boolean esta = false;
		Actriz unaActriz = null;
		while (!esta && itr.hasNext()) {
			unaActriz = itr.next();

			if (unaActriz.getNombre() == pNombre) {
				esta = true;
			}
		}
		return esta;
	}

	public Actriz buscarActriz(String pNombre) {
		Iterator<Actriz> itr = this.getIterador();
		boolean enc = false;
		Actriz unaActriz=null;
		while (!enc && itr.hasNext()) {
			unaActriz = itr.next();
			if (unaActriz.getNombre().equals(pNombre)) {
				enc = true;
			}else{
				unaActriz=null;
			}
		}
		return unaActriz;
	}

	public int getTamano() {
		return this.la.size();
	}

	public Actriz EstaEnPos(int pPos) {
		Actriz unaActriz = null;
		if (!this.la.isEmpty()) {
			if (pPos < getTamano() && (pPos >= 0)) {
				unaActriz = this.la.get(pPos);
			}
		}
		return unaActriz;
	}

	public void ordenarActores() {
		listaOrdenada = new Actriz[la.size()];
		listaOrdenada = this.la.toArray(listaOrdenada);
		listaOrdenada= ordenar(listaOrdenada,0,listaOrdenada.length-1);
		this.la = new ArrayList<Actriz>();
		for (int i = 0; i < listaOrdenada.length; i++) {
			System.out.println("ordenada: " + listaOrdenada[i].getNombre());
			la.add(listaOrdenada[i]);
		}
	}

		public Actriz[] ordenar(Actriz[] lista, int inicio, int fin){
			int i, j, central;
			Actriz pivote;
			central=(inicio+fin)/2;
			pivote=lista[central];
			i=inicio;
			j=fin;
			do{
				while (lista[i].compareTo(pivote)<=0 && i<j) i++;
				while (lista[j].compareTo(pivote)>0) j--;
				if(i<=j){
					Actriz tem;
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
		Iterator<Actriz> itr = this.getIterador();
		while (itr.hasNext()){
			Actriz unaActriz = itr.next();
			System.out.println(unaActriz.getNombre());
		}
	}
}