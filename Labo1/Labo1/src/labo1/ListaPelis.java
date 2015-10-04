package labo1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPelis {

	private ArrayList<Pelicula> Lpe;

	public ListaPelis() {
		this.Lpe = new ArrayList<Pelicula>();
	}

	public Iterator<Pelicula> getIterador() {
		return this.Lpe.iterator();
	}

	public int getTamano() {
		return this.Lpe.size();
	}

	public void anadirPeli(Pelicula unaPeli) {
		this.Lpe.add(unaPeli);
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
