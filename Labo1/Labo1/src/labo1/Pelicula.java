package labo1;

public class Pelicula {

	private String titulo;
	private ListaActores la;

	public Pelicula(String pTitulo, ListaActores pLa) {
		this.titulo = pTitulo;
		this.la = pLa;
	}

	public String getTitulo() {
		return this.titulo;

	}
	public void getLista(){
		la.imprimirLista();
	}
}