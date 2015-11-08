package terceraFase;

public class GraphHash {

	HashMap<String, ArrayList<String>> g;
	
	public void crearGrafo(ListaActricesActores lActores)
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películas 
           
            // COMPLETAR CÓDIGO

	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	
	public boolean estanConectados(String a1, String a2)
            // COMPLETAR CÓDIGO
}
