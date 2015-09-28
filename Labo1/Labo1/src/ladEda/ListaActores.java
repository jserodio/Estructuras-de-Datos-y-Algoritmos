package ladEda;

import java.util.ArrayList;

public class ListaActores {

	private ArrayList<Actor> la;
	
	
public ListaActores(){
	
	this.la= new ArrayList<Actor>();
}	
	
	
	public void anadirActor(Actor pActor){
	
		this.la.add(pActor);
	}
}
