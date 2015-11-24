package juegoDeBloques;

public class PruebaPartida {

	public static void main(String[] args) {
		Juego partida = new Juego();
		
		int puntos = partida.jugar();
		
		if (puntos == -1){
			System.out.println("Mala suerte. Game Over.");
		}else{
			System.out.println("Enhorabuena! Puntuacion total: " + puntos);
		}
	}

}
