package labo1Modificado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import segundaFase.*;

public class CatalogoPelis {
	
	
	//private HashMap<String, Pelicula> listaP;
	private static CatalogoPelis miCatalogoPelis;
	private static DoubleLinkedList<String> listaP;
	
	private CatalogoPelis() {
		//this.listaP = new HashMap<String,Pelicula>();
		CatalogoPelis.listaP = new DoubleLinkedList<String>();
	}

	public static CatalogoPelis getCatalogoPelis() {
		if (miCatalogoPelis == null) {
			miCatalogoPelis = new CatalogoPelis();
		}
		return miCatalogoPelis;
	}

	public boolean existePelicula(String pPeli){
		//if (this.listaP.containsKey(pPeli))	return true; else return false;
		if (CatalogoPelis.listaP.contains(pPeli)) return true; else return false;
	}
	
	public Pelicula buscarPeli(String unaPelicula){
		//return CatalogoPelis.getCatalogoPelis().listaP.get(unaPelicula);
		return CatalogoPelis.getCatalogoPelis().listaP.find(unaPelicula);
	}
	
	public Pelicula anadirPeli(String titulo){
		//añade la pelicula al catalogo en caso de no estar cargado anteriormente
		//pre:
		//post:
		if(CatalogoPelis.getCatalogoPelis().existePelicula(titulo)){
			//Si ya esta cargada esta pelicula con este nombre
			return CatalogoPelis.getCatalogoPelis().buscarPeli(titulo);
		} else{
			Pelicula p=new Pelicula(titulo);
			//this.listaP.put(p.getTitulo(), p);
			CatalogoPelis.listaP.
			return p;
		}
	}
	
	public void  listaPeliCadaActor(String unActor){ //este metodo nos dira para una pelicula dada, la lista de actores que participan en ella
		
		Actor actor = CatalogoActores.getCatalogoActores().buscarActor(unActor);
			if (actor!= null){
				actor.obtenerPelis();
			} else System.out.println("La pelicula introducida no existe");
	}

}