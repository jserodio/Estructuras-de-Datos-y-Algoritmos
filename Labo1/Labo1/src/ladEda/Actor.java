package ladEda;

public class Actor {
	
	private String nombre;
	private ListaPeliculas lp;
	
	
	public Actor(String nombre, ListaPeliculas lp) {
		this.nombre = nombre;
		this.lp = new ListaPeliculas();
	}
	
	

	public String getNombre(){
		return this.nombre;
	}
	
	public ListaPeliculas getListaPelis(){
		
		return this.lp;
	}
	
	//puede hacer falta recoger el tamaño de la ListaPeliculas en algun momento
	
	
	
	

}
