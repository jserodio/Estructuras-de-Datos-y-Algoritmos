package estructuraEnlazada;

public class Link {
	public Persona data; //datos en el nodo
	public Link next; //siguiente nodo en la estructura
	
	public Link (Persona p){ //constructora
		data = p;
		next = null;
	}
}