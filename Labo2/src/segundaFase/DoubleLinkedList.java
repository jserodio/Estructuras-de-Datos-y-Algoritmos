package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first;
	protected Node<T> last; // apuntador al ultimo
	protected String descr;  // descripción
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
        // Precondición: ninguna
		// Postcondición: devuelve el valor eliminado
		if (isEmpty())
	          return null;
		
		T auxiliar = first.data; // Guardamos el data del primer nodo en el auxiliar
		this.count--; // La lista va a tener un elemento menos.
		
		if (first.next == null){ // Si solo hay 1 elemento
			first = null;
		} else{
			first = first.next; // Hacemos que el primer nodo apunte al segundo
			first.prev = null; // Hacemos que el nuevo primero, que apuntaba al antiguo first, apunte a null (el primero no debe tener previo)
		}
		return auxiliar; // Devolver la información eliminada
	}

	public T removeLast() {
	// Elimina el último elemento de la lista
        // Precondición: ninguna
		// Postcondición: devuelve el valor eliminado
		if (isEmpty())
			return null;
		
		T auxiliar = last.data; // Guardar el data del último nodo
		this.count--; // La lista va a tener un elemento menos
		
		if (last.prev== null){ // Si solo hay 1 elemento
			last = null;
		} else{
			last = last.prev; // El penultimo ahora es el último.
			last.next = null; // El nuevo último apuntará a null.
		}
		return auxiliar;
   }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// Precondición: ninguno
		// Postcondición: devuelve el valor eliminado, que almacenamos en la variable auxiliar
		//				  la estructura tiene un nodo menos. si no encuentra el valor devuelve null
		if (isEmpty())
	          return null;
		
		Node<T> current = first; // Navegamos con el puntero current	
		T auxiliar = null;
		
		while((current != null) && !elem.equals(current.data))
			current = current.next; // Avanzamos
		
		if (current != null){
			// Si current no es null, ha encontrado el elem
			auxiliar = current.data; // Guardamos la referencia
			current.prev.next = current.next; // El nodo anterior apunta, al nodo siguiente
			current.next.prev = current.prev; // El nodo siguiente, apunta al nodo anterior.
			// El nodo actual, desaparece.
		}
		
		return auxiliar;
		
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al último elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		      if (isEmpty())
		          return false;

		      Node<T> current = first;  // Navegamos con el puntero current

		      while ((current != null) && !elem.equals(current.data)) 
		            current = current.next;
		      if (current == null) return false;
                      else return elem.equals(current.data);
		   }

	public T find(T elem) {	
	//Determina si la lista contiene un elemento concreto, y develve su referencia
	//null en caso de que no esté
		// Precondicion: Ninguna
		// Postcondicion: Devuelve su referencia
		if (isEmpty())
	          return null;
		
		Node<T> current = first;
		
		while ((current != null) && !elem.equals(current.data))
			current = current.next;
		if (current == null) return null;
			else	return current.data;
	}

	public boolean isEmpty() 
	//Determina si la lista está vacía
	{ return last == null;};
	
	public int size() 
	//Determina el número de elementos de la lista
	{ return count;};

	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		   private Node<T> actual = first;
		   private int contador = count * 2;
		   public boolean hasNext(){
		   	if(contador!=0){
		   		contador--;
		   		return true;
		   	}else{
		   		return false;
		   	}
		   	}
		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();	
			}else{
				T datos= actual.data;
				actual=actual.next;
				return datos;
			}
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
			
		}
		
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

