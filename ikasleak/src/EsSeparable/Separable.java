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
    	//resul es el resultado de sumar todo el contenido de cada posición del array
    	
    	izq=0;	//inicializo izq
    	der=1;//inicializo der a 1 ya que si lo hago a 0 me da error aritmetico al dividir 0/0
    	i = 0;
    	resul=0;
    	
    	for (int j: tabla){
    		resul = resul + j; //recorro todo el array y sumo todos sus numeros
    	}
    	System.out.println("--- I n i c i a - L o o p ---");
    	while ((izq-der)!=0 && i != tabla.length){	
    		izq = izq + tabla[i]; //En la izquierda sumo el valor de la posicion actual a los valores anteriores.
    		der = resul-izq; // En la derecha meto el valor total de la tabla, restandole lo que he obtenido en la posicion i, que he añadido a izq
    		i++;
    		System.out.println("---");
    		System.out.println("interacion nº: "+ i+1);
    		System.out.println("izquierda: "+ izq);
    		System.out.println("derecha: "+ der);
    		System.out.println("resultado: "+ resul);
    	}
    	System.out.println("---");
    	System.out.println("--- F i n - D e l - L o o p ---");
        return i;
    } 
}
