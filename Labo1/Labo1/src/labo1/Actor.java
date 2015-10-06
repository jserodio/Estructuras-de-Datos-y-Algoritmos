package labo1;

public class Actor implements Comparable<Actor>{

	private String nombre;
	 private ListaPelisPorActor Lp;
	
	public Actor (String pNombre){ //constructora
		this.Lp = new ListaPelisPorActor();
		this.nombre=pNombre;
	}
	
	
	public ListaPelisPorActor getListaPelis(){
		return this.Lp;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int devolverNumPelis(){
		return getListaPelis().getTamano();
	}
	
	
	public int compareTo(Actor unaActor) { //sirve para  mirar si un actor es igual  a  uno que introduzcamos nosotros
		return this.getNombre().compareTo(unaActor.nombre);
	}
}