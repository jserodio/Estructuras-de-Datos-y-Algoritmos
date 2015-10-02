package labo1;

public class Actriz implements Comparable<Actriz>{

	private String nombre;
	 private ListaPelis Lp;
	
	public Actriz (String pNombre){
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
	
	
	public int compareTo(Actriz unaActriz) {
		return this.getNombre().compareTo(unaActriz.nombre);
	}
}