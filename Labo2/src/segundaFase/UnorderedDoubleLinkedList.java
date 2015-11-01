package segundaFase;

import segundaFase.Node;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	Node<T> elemento;
	
	public void addToFront(T elem) {
	// añade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> añadido = new Node<T>(elem);
		Node<T> primero=first;
		if (this.isEmpty()){
			first = añadido;
		}else{
			añadido.next=primero;
			
		}
		count++;
	}

	public void addToRear(T elem) {
	// añade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		elemento = new Node<T>(elem);
		if (isEmpty()) { // miro a ver si esta la lista vacia y si es asi meto el dato
			first = elemento; //añado el elemento y listo
			elemento.next = null; //apunto a null aunque tal vez sea irrelevante
			last = elemento; //hago que el puntero last tambien apunte al nuevo elemento ya que solo hay ese
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
