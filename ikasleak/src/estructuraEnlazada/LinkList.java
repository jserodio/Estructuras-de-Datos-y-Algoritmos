package estructuraEnlazada;

public class LinkList {
	private Link first; //referencia a nodo distinguido
	
	public LinkList(){ //constructor
		first = null;
	}
	
	public boolean isEmpty(){
		
	}
	
	public void insertFirst(Persona p){
		
	}
	
	public Persona deleteFirst(){
		if isEmpty() return null;
		else if first.next == null{
			Persona p = first.data;
			first = null;
			return p;
		}
		else{
			Persona p = first.data;
			first = first.next;
			return p;
		}
	}
	
	public void displayList(){
		Link aux; //no hay que hacer new Link.
		aux = first;
		while aux != null{
			aux.data.print();
			aux.next;
		}	
	}
	
	public Persona find(int key){
		Link aux=first;
		
		while ((aux != null)&&(enc==false)){
			if aux.data.equals(p){ //el equals!!!!!!!!
				enc=true;
			}else aux = aux.next;
		}
		
		if enc return aux.data;
		else return null;
	}
	
	public Persona delete(int key){
		Link aux=first;
		
		while ((aux != null) && (enc==false)){
			if aux.data.equals(p){ //el equals !!!!!!
				enc = true;
			}else {
				ant = aux;
				aux = aux.next;
			}
		}
		
		if !enc return null;
		else {
			Persona p = aux.data;
			if (ant == null){
				first = first.next;
			}else if aux.next==null{
				ant.next=null;
			}else ant.next=aux.next;
			return p;
		}
	}
}

