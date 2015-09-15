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
    	int izq, der, i;
    	//der es el total acumulado de la suma desde el final del array
    	//izq es el total acumulado que suma desde el principio del array
    	izq = 0;
    	der = 0;
    	i = 0;
    	
    	while (izq != der || i != tabla.length){
    	// Recorrer toda la tabla mientras las sumas no sean iguales
    		izq = izq + tabla[i];
    		//no me funciona por tener valores negativos...
    		der = der + tabla[tabla.length-i];
    		i++;
    	}
        return i;
    } 
}
