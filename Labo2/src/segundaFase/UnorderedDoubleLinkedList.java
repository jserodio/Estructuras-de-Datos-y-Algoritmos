package segundaFase;

import segundaFase.Node;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> a�adido = new Node<T>(elem);
		Node<T> primero=first;
		if (this.isEmpty()){
			first = a�adido;
		}else{
			a�adido.next=primero;
			
		}
		count++;
	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

	}
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
	}

}
