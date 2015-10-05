package labo1;

public class Actor implements Comparable<Actor>{

	private String nombre;
	 private ListaPelisPorActor Lp;
	
	public Actor (String pNombre){
		this.Lp = new ListaPelisPorActor();
		this.nombre=pNombre;
	}
	
	public void setListaPeli(ListaPelisPorActor lp){
		this.Lp = lp;
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
	
	
	public int compareTo(Actor unaActor) {
		return this.getNombre().compareTo(unaActor.nombre);
	}
}