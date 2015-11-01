package segundaFase;

import segundaFase.Node;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	Node<T> elemento;
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		// Precondicion: ninguna
		// Postcondicion: a�ade un elemento nuevo al principio
		// Coste: o(C). Constante
		elemento = new Node<T>(elem);
		if (this.isEmpty()){ // Si lista vacia
			first = elemento; // puntero first ser� elemento
		}else{
			first.prev=elemento; //el puntero previo al first actual, apunta el nuevo elemento
			elemento.next=first; // el puntero next de elemento, apuntar� a first (que ser� segundo)
			first=elemento; // el nuevo first ser� mi elemento
		}
		count++;
	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		// Precondicion: ninguna
		// Postcondicion: a�ade un elemento al final
		// Coste: o(C). Constante
		elemento = new Node<T>(elem);
		if (isEmpty()) { // miro a ver si esta la lista vacia y si es asi meto el dato
			first = elemento; //a�ado el elemento y listo
		} else {
			last.next = elemento; //Apunto con el next del last al nuevo nodo
			elemento.prev = last; //Apunto con el prev del nuevo nodo a last
			last = elemento; //Hago que el puntero last apunte al nuevo nodo
		}
		count++;//sumo al contador el nuevo nodo
	}
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
	// Precondicion: La lista no puede estar vacia.
	// Postcondicion: El nuevo elemento queda insertado despu�s del target. Si no lo encuentra
	//				  , no lo inserta.
	// Coste: o(n). Lineal
		elemento = new Node<T>(elem);
		Node<T> current = first;
			
		while((current != null) && !target.equals(current.data))
			current = current.next; // Avanzamos
		
		if (current != null){
			// Si current no es null, ha encontrado el target
			elemento.prev = current; // Puntero previo de elemento, apunta a current.
			elemento.next = current.next.next; // Puntero siguiente a elemento, apunta al de delante.
			current.next = elemento; // El nodo anterior apunta, al nodo siguiente
			count++; //sumo al contador el nuevo nodo
		}
		
	}

}
