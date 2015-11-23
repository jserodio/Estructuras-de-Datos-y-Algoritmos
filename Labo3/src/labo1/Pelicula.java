package labo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Pelicula {

	private String titulo;
	private HashMap<String, Actor> listaA;
	private float donaciones;

	public Pelicula(String pTitulo) {
		this.listaA = new HashMap<String, Actor>();
		this.titulo = pTitulo;
		this.donaciones = 0;
	}

	public String getTitulo() {
		return this.titulo;
	}
	/*public ListaActoresPorPelicula getLista(){
		return this.;
	}*/
	
	public void anadirActor(Actor unActor) {
		if(!this.listaA.containsKey(unActor)){
			this.listaA.put(unActor.getNombre(),unActor);
		}
		
	}
	
	public void eliminarActor(Actor unActor) {
		this.listaA.remove(unActor.getNombre(), unActor);
	}
	

	public void obtenerActores(){
		//Esto es el metodo para mostrar todos los actores de la pelicula
		Iterator<Actor> itr = listaA.values().iterator();
		while (itr.hasNext()){
			Actor actor = (Actor)itr.next();
			System.out.println(actor.getNombre());
		}
	}
	
	public void anadirDonaciones(float dDinero){
		if (dDinero>=0){
		this.donaciones = this.donaciones + dDinero;
		} else {
			System.out.println("La cantidad a�adida no es correcta.");
		}
	}

	public float getDonaciones(){
		return this.donaciones;
	}

	public ArrayList<String> getActores() {
		// precondiciones: lista no vacia
		// postcondiciones: devuelve un arraylist de los Values de un hashmap.
		// Convertir valores HashMap a ArrayList
		// coste lineal
		ArrayList<String> listaActores = new ArrayList<String>(this.listaA.keySet());
		return listaActores;

	}
		
}