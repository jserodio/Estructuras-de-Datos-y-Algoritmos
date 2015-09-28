package ladEda;

import java.util.ArrayList;


public class ListaPeliculas {
	
	private ArrayList<Pelicula> lp;
	
	
	public ListaPeliculas(){
		
		this.lp=new ArrayList<Pelicula>();
	}
	
	
	public void anadirPelicula(Pelicula pPelicula){
		
		this.lp.add(pPelicula);
	}
	
	
	
	
	
	
	
}

