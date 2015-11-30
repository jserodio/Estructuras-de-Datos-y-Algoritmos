package terceraFase;

import labo1.Actor;
import labo1.CatalogoActores;
import java.util.HashMap;

public class casoPrueba {

	public static void main(String[] args) {
		
		// cargamos los datos del fichero
		CatalogoActores.getCatalogoActores().CargarDatosFichero();
			
		// prueba para crear grafo
		GraphHash grafo = new GraphHash();

		grafo.crearGrafo();
<<<<<<< HEAD
		System.out.println(grafo.estanConectados("Lynn, Sonia", "Gates, Victoria"));
=======
		grafo.estanConectados("Neff, Warren", "McKechnie, Lee");
>>>>>>> branch 'master' of https://github.com/jserodio/Estructuras-de-Datos-y-Algoritmos.git
	}

}
