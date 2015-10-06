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
	public void  listaPeliCadaActor(String unaPelicula){ //
		
		Pelicula peli = CatalogoPelis.getCatalogoPelis().buscarPeli(unaPelicula);
			if (peli!= null){
				peli.getLista();
			} else System.out.println("La pelicula introducida no existe");
	}

	private Pelicula buscarPeli(String unaPelicula){
		
		return CatalogoPelis.getCatalogoPelis().listaP.get(unaPelicula);
		
	}
	public void anadirActorAListaDePelis(Pelicula pPeli, String pActor){
		// TODO Auto-generated method stub
		/*1. Se busca la peli
		 * 2. Te metes dentro	
		 * 3. Una vez dentro a�ades con un .add el actor creando el actor
		 * */
		
		
		
		/*Actor actor=new Actor(pActor);
		Iterator itr = this.iteradorPelis();
		while(itr.hasNext())
		{
			//MiraR si existe la peli, si no existe se a�ade
			if(!existePelicula(pPeli))
			{
				this.listaP.put(key, value)
				//se a�ade
				
			}
			
				
			}*/
			
		}
		

		public boolean existePelicula(Pelicula pPeli){
			if (this.listaP.containsKey(pPeli)){
				return true;
			}else{
				return false;
			}
			
		}
}