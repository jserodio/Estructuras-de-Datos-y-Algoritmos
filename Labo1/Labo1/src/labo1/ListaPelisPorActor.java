package labo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListaPelisPorActor {
	
	private HashMap <String, Pelicula> listaPelisPorActor;

	public ListaPelisPorActor() {
		this.listaPelisPorActor =new HashMap<String,Pelicula>();
	}

	public Iterator<Entry<String, Pelicula>> getIterador() {
		return this.listaPelisPorActor.entrySet().iterator();
	}

	public int getTamano() {
		return this.listaPelisPorActor.size();
	}

	public void anadirPeli(Pelicula peli){
		if(!this.listaPelisPorActor.containsKey(peli.getTitulo())){
			this.listaPelisPorActor.put(peli.getTitulo(), peli);	
			}
	}


	public void eliminarPeli(Pelicula unaPeli) {
		this.Lpe.remove(unaPeli);
	}

	public Pelicula buscarPeli(String pTitulo) {
		boolean enc = false;
		Pelicula unaPelicula = null;
		Iterator<Pelicula> itr = this.getIterador();
		while (!enc && itr.hasNext()) {
			unaPelicula = itr.next();
			if (pTitulo == unaPelicula.getTitulo()) {
				enc = true;
			}
		}
		if(!enc){
			System.out.println("no esta pelicula");
		}
		return unaPelicula;
	}
	
	public void imprimirLista(){
		Iterator<Pelicula> itr = this.getIterador();
		while (itr.hasNext()){
			Pelicula peli = itr.next();
			System.out.println(peli.getTitulo());
		}
	}

	public Pelicula EstaEnPos(int pPos) {
		Pelicula unaPelicula = null;
		if (!this.Lpe.isEmpty()) {
			if (pPos < getTamano() && (pPos >= 0)) {
				unaPelicula = this.Lpe.get(pPos);
			}
		}
		return unaPelicula;
	}
}
