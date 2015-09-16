package EsSeparable;

public class Separable{

    public Separable() { } // Constructora

    public int esSeparable1(int[] tabla) {
    	int izq, der;
    	
        for (int i = 0; i < tabla.length; i++){
        	izq = 0;
        	for (int k = 0; k < i; k++) izq = izq + tabla[k];
      
        	der = 0;
        	for (int k = i; k < tabla.length; k++) der = der + tabla[k];
        	
        	if (izq == der) return i;
        }
        return 0;
    }
    
    public int esSeparable2(int[] tabla) {
    	int izq, der,i,resul;
    	//der es el total acumulado de la suma desde la posicion en la que estamos hacia la derecha
    	//izq es el total acumulado que suma desde el principio del array hasta la posicion en la que estamos
    	izq=0;	
    	der=0;//inicializo con el siguiente contenido
    	i = 0;//tabla[1] sería el segundo
    	resul=0;
    	for (int j = 0; j<tabla.length;j++){
    		resul = resul + tabla[i]; //recorro todo el array y sumo todos sus numeros
    	}
    	
    	while (izq%der!=0 && i != tabla.length){	
    		izq = izq + tabla[i]; //En la izquierda sumo el valor de la posicion actual a los valores anteriores.
    		der = resul-izq; // En la derecha meto el valor total de la tabla, restandole lo que he obtenido en la posicion i, que he añadido a izq
    		i++;
    	}
        return i;
    } 
}
