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
		grafo.estanConectados("Neff, Warren", "McKechnie, Lee");
	}

}
