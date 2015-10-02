package labo1;

public class CatalogoPelis {
	
	private ListaPelis Lpe;
	private static CatalogoPelis miCatalogoPelis;

	private CatalogoPelis() {
		this.Lpe = new ListaPelis();
	}

	public static CatalogoPelis getCatalogoPelis() {
		if (miCatalogoPelis == null) {
			miCatalogoPelis = new CatalogoPelis();
		}
		return miCatalogoPelis;
	}

	public ListaPelis getLista() {
		return this.Lpe;
	}

	public void  listaPeliCadaActor(){
		Pelicula unaPelicula = null;
		for (int i=0; i<this.Lpe.getTamano(); i++){
			unaPelicula = this.Lpe.EstaEnPos(i);
			for(int j=0; j<unaPelicula.getLista().getTamano() ; j++){
				Actor unaActor=unaPelicula.getLista().EstaEnPos(j);
				if( CatalogoActrices.getCatalogoActrices().getLista().buscarActor(unaActor.getNombre())!=null)
					CatalogoActrices.getCatalogoActrices().getLista().buscarActor(unaActor.getNombre()).getListaPelis().anadirPeli(unaPelicula);
				else{
					unaActor.getListaPelis().anadirPeli(unaPelicula);
					CatalogoActrices.getCatalogoActrices().getLista().insercionActor(unaActor);
				}
			}
		}
	}
}