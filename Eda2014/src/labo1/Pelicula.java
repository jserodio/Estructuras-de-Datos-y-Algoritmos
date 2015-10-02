package labo1;

public class Pelicula {

	private String titulo;
	private ListaActrices la;

	public Pelicula(String pTitulo, ListaActrices pLa) {
		this.titulo = pTitulo;
		this.la = pLa;
	}

	public String getTitulo() {
		return this.titulo;

	}
	public ListaActrices getLista(){
		return this.la;
	}
}