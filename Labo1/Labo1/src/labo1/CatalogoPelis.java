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
				peli.getLista();
			} else System.out.println("La pelicula introducida no existe");
	}


	private Pelicula buscarPeli(String unaPelicula){ //permite buscar una pelicula en el hashmap
		boolean enc = false;
		Pelicula peli = null;
		Iterator<Entry<String, Pelicula>> itr = this.getIterador();;
		while (!enc && itr.hasNext()) {
			peli = (Pelicula) itr.next();
			if (unaPelicula == peli.getTitulo()) {
				enc = true;
			}
		}
		if(!enc){
			System.out.println("no esta pelicula");
		}
		return peli;
	}
	//Este metodo de abajo me parece superineficiente	
	/*public void  listaPeliCadaActor(){ //
		Pelicula unaPelicula = null;
		for (int i=0; i<this.Lpe.getTamano(); i++){
			unaPelicula = this.Lpe.EstaEnPos(i);
			for(int j=0; j<unaPelicula.getLista().getTamano() ; j++){
				Actor unaActor=unaPelicula.getLista().EstaEnPos(j);
				if( CatalogoActores.getCatalogoActores().getLista().buscarActor(unaActor.getNombre())!=null)
					CatalogoActores.getCatalogoActores().getLista().buscarActor(unaActor.getNombre()).getListaPelis().anadirPeli(unaPelicula);
				else{
					unaActor.getListaPelis().anadirPeli(unaPelicula);
					CatalogoActores.getCatalogoActores().getLista().insercionActor(unaActor);
				}
			}
		}
	}*/

	public void anadirActorAListaDePelis(Pelicula pPeli, String pActor) {
		// TODO Auto-generated method stub
		/*1. Se busca la peli
		 * 2. Te metes dentro
		 * 3. Una vez dentro añades con un .add el actor creando el actor
		 * */
		Actor actor=new Actor(pActor);
		Iterator itr = this.iteradorPelis();
		while(itr.hasNext())
		{
			//MiraR si existe la peli, si no existe se añade
			if(!existePelicula(pPeli))
			{
				this.listaP.put(key, value)
				//se añade
				
			}
			
				
			}
			
		}
		
		public boolean existePelicula(Pelicula pPeli)
		{ //comprueba que el hashmap contiene la pelicula
			if (this.listaP.containsKey(pPeli)){
				return true;
			}else{
				return false;
			
		}
		
	
	/*private Iterator<Pelicula> iteradorPelis ()
=======
		
	
	private Iterator<Entry<String, Pelicula>> getIterador ()
>>>>>>> branch 'master' of https://github.com/jserodio/Estructuras-de-Datos-y-Algoritmos.git
	{
<<<<<<< HEAD
		return this.listaP.entrySet().iterator();
	}*/
		//return listaP.entrySet().iterator();
	}
}