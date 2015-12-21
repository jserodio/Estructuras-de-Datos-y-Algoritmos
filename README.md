# Estructuras-de-Datos-y-Algoritmos
Proyectos varios de la universidad.

Creemos que merece destacar nuestro trabajo invertido en la universidad, de forma que a su vez, podamos contribuir y subir código de la forma más rápida, cómoda y reutilizable posible.

public class Stopwatch { 

    private final long start;

   /** Create a stopwatch object. */
    public Stopwatch() {
        start = System.currentTimeMillis();
    } 

   /**
     * Return elapsed time (in seconds) since this object was created.
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
} 
