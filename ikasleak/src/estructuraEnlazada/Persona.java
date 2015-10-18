package estructuraEnlazada;

public class Persona {

	private String name;
	private String dni;
	private Persona next; //acceso a la siguiente persona
	
	public Persona(String pName, String pDni){ //constructora
		name = pName;
		dni = pDni;
		next = null;
	}
	public void setNext(Persona next){ this.next = next;}
	public void print(){
		//escribe todo
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
