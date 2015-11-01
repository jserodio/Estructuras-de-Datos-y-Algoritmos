package segundaFase;

import segundaFase.Node;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	Node<T> elemento;
	
	public void addToFront(T elem) {
	// añade un elemento al comienzo
		// Precondicion: ninguna
		// Postcondicion: añade un elemento nuevo al principio
		// Coste: o(C). Constante
		elemento = new Node<T>(elem);
		if (this.isEmpty()){ // Si lista vacia
			first = elemento; // puntero first será elemento
		}else{
			first.prev=elemento; //el puntero previo al first actual, apunta el nuevo elemento
			elemento.next=first; // el puntero next de elemento, apuntará a first (que será segundo)
			first=elemento; // el nuevo first será mi elemento
		}
		count++;
	}

	public void addToRear(T elem) {
	// añade un elemento al final 
		// Precondicion: ninguna
		// Postcondicion: añade un elemento al final
		// Coste: o(C). Constante
		elemento = new Node<T>(elem);
		if (isEmpty()) { // miro a ver si esta la lista vacia y si es asi meto el dato
			first = elemento; //añado el elemento y listo
		} else {
			last.next = elemento; //Apunto con el next del last al nuevo nodo
			elemento.prev = last; //Apunto con el prev del nuevo nodo a last
			last = elemento; //Hago que el puntero last apunte al nuevo nodo
		}
		count++;//sumo al contador el nuevo nodo
	}
	
	public void addAfter(T elem, T target) {
	// Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista
	// Precondicion: La lista no puede estar vacia.
	// Postcondicion: El nuevo elemento queda insertado después del target. Si no lo encuentra
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
