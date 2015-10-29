package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first;
	protected Node<T> last; // apuntador al ultimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
		first = null;
		last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
		// Postcondici�n: devuelve el valor eliminado
		Node<T> auxiliar = first;
		first = first.next; // Hacemos que el primer nodo apunte al segundo
		first.prev = null; // Hacemos que el nuevo primero, que apuntaba al antiguo first, apunte a null (el primero no debe tener previo)
		return auxiliar.data; // Devolver la informaci�n eliminada
	}

	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
		// Postcondici�n: 

   }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// Precondici�n:
		// Postcondici�n: 
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		      if (isEmpty())
		          return false;

		      Node<T> current = first; // Empieza con el segundo elemento

		      while ((current != null) && !elem.equals(current.data)) 
		            current = current.next;
		      if (current == null) return false;
                      else return elem.equals(current.data);
		   }

	public T find(T elem) {
		
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		return elem;
	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return last == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE



	   } // private class
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
