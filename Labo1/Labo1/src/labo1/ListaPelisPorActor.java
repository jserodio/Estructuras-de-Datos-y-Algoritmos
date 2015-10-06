package labo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListaPelisPorActor {
	
	private HashMap<String, Pelicula> LPeliculas;

	public ListaPelisPorActor() {
		// TODO Auto-generated constructor stub
		LPeliculas = new HashMap();
	}
	

	public Iterator<Entry<String, Pelicula>> getIterador() {//nos permitira iterar y recorrer el hashmap
		return this.LPeliculas.entrySet().iterator();
	}

	public int getTamano() {
		return this.LPeliculas.size();
	}

	public void anadirPeli(Pelicula unaPeli) {
		if(!this.LPeliculas.containsKey(unaPeli.getTitulo())){
			this.LPeliculas.put(unaPeli.getTitulo(),unaPeli);
		}
		
	}

	public void eliminarPeli(Pelicula unaPeli) {
		this.LPeliculas.remove(unaPeli.getTitulo(), unaPeli);
	}

	public Pelicula buscarPeli(String pTitulo) {
		boolean enc = false;
		Pelicula unaPelicula = null;
		Iterator<Entry<String, Pelicula>> itr = this.getIterador();
		while (!enc && itr.hasNext()) {
			unaPelicula = (Pelicula) itr.next();
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
		Iterator<Entry<String, Pelicula>> itr = this.getIterador();
		while (itr.hasNext()){
			Pelicula peli = (Pelicula)itr.next();
			System.out.println(peli.getTitulo());
		}
	}

	public Pelicula EstaEnPos(int pPos) {
		Pelicula unaPelicula = null;
		if (!this.LPeliculas.isEmpty()) {
			if (pPos < getTamano() && (pPos >= 0)) {
				unaPelicula = this.LPeliculas.get(pPos);
			}
		}
		return unaPelicula;
	}
}
