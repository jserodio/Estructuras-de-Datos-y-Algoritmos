package labo1Modificado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Actor implements Comparable<Actor>{

	private String nombre;
	private HashMap<String, Pelicula> listaP;
	

	public Actor (String pNombre){
		this.listaP = new HashMap<String,Pelicula>();
		this.nombre=pNombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getTamano(){
		return this.listaP.size();
	}
	
	public HashMap<String, Pelicula> getListaPelis(){
		return this.listaP;
	}
	
	public int compareTo(Actor unaActor) { //sirve para  mirar si un actor es igual  a  uno que introduzcamos nosotros
		return this.getNombre().compareTo(unaActor.nombre);
	}
	
	public void anadirPeli(Pelicula unaPeli) {
		if(!this.listaP.containsKey(unaPeli.getTitulo())){
			this.listaP.put(unaPeli.getTitulo(),unaPeli);
		}
		
	}

	public void eliminarPeli(Pelicula unaPeli) {
		this.listaP.remove(unaPeli.getTitulo(), unaPeli);
	}
	
	public void obtenerPelis(){
		Iterator<Pelicula> itr = listaP.values().iterator();
		boolean sinpelis = true;
		while (itr.hasNext()){
			sinpelis = false;
			Pelicula peli = (Pelicula)itr.next();
			System.out.println(peli.getTitulo());
		}
		if (sinpelis)	System.out.println("No existen peliculas para este actor");
	}
	
	public Pelicula buscarPeli(String unaPelicula){
		return this.listaP.get(unaPelicula);
	}
	
}