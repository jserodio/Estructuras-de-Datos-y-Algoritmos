package labo1;

public class Pelicula {

	private String titulo;
	private ListaActoresPorPelicula la = new ListaActoresPorPelicula();

	public Pelicula(String pTitulo) {
		this.titulo = pTitulo;
	
	}

	public String getTitulo() {
		return this.titulo;

	}
	public void getLista(){
		la.imprimirLista();
	}
}