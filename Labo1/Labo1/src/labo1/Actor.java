package labo1;

public class Actor implements Comparable<Actor>{

	private String nombre;
	 private ListaPelis Lp;
	
	public Actor (String pNombre){
		this.Lp = new ListaPelis();
		this.nombre=pNombre;
	}
	
	public void setListaPeli(ListaPelis lp){
		this.Lp = lp;
	}
	
	public ListaPelis getListaPelis(){
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