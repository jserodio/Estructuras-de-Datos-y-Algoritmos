package labo1;

import java.util.HashMap;
import java.util.Iterator;

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
		
		Pelicula peli = Lpe.buscarPeli(unaPelicula);
			if (peli!= null){
				peli.getLista();
			} else System.out.println("La pelicula introducida no existe");
	}
		
		/*for (int i=0; i<this.Lpe.getTamano(); i++){
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
				//se añade
				
			}
			
				
			}
			
		}
		
		
}