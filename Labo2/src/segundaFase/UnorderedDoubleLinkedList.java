package segundaFase;

import segundaFase.Node;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	Node<T> elemento;
	
	public void addToFront(T elem) {
	// añade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
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
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
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
		// ¡COMPLETAR OPCIONAL!
	}

}
