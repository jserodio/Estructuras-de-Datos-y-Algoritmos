package labo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CatalogoPelis {
	
	
	private HashMap<String, Pelicula> listaP;
	private static CatalogoPelis miCatalogoPelis;

	private CatalogoPelis() {
		this.listaP = new HashMap<String,Pelicula>();
	}

	public static CatalogoPelis getCatalogoPelis() {
		if (miCatalogoPelis == null) {
			miCatalogoPelis = new CatalogoPelis();
		}
		return miCatalogoPelis;
	}

	public void anadirPeli(Pelicula unaPeli){
		if(!this.listaP.containsKey(unaPeli.getTitulo())){
			this.listaP.put(unaPeli.getTitulo(), unaPeli);
		}
	}
	public void  listaPeliCadaActor(String unaPelicula){ //este metodo nos dira para una pelicula dada, la lista de actores que participan en ella
		
		Pelicula peli = CatalogoPelis.getCatalogoPelis().buscarPeli(unaPelicula);
			if (peli!= null){
				peli.obtenerActores();
			} else System.out.println("La pelicula introducida no existe");
	}

	private Pelicula buscarPeli(String unaPelicula){
		return CatalogoPelis.getCatalogoPelis().listaP.get(unaPelicula);
	}

		public boolean existePelicula(Pelicula pPeli){

				if (this.listaP.containsKey(pPeli)){
				return true;
			}else{
				return false;
			
			}
		}
}