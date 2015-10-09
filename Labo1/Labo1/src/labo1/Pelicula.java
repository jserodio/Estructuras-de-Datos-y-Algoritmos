package labo1;

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
			System.out.println("La cantidad añadida no es correcta.");
		}
	}

	public float getDonaciones(){
		return this.donaciones;
	}
		
}