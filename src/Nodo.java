import java.util.ArrayList;
import java.util.HashMap;

public class Nodo {
	
	public int id;
	//public double distanciaMin = Double.POSITIVE_INFINITY;
	public ArrayList<Vizinho> vizinhos;
	public HashMap<Integer, Integer> IdDistancias;
	public int[] distancias;
	
	public Nodo(int id) {
		this.id = id;
		vizinhos = new ArrayList<Vizinho>();
	}
	
	public void AddVizinho(Vizinho vizinho) {
		vizinhos.add(vizinho);	
	}
	
	public HashMap<Integer, Integer> CompletarDistancias(int count) {
		IdDistancias = new HashMap<Integer, Integer>();
		for (int i = 0; i < count; i++) {
			IdDistancias.put(i, Integer.MAX_VALUE);
		}
		
		return IdDistancias;
	}

	public void AddVizinhos(Vizinho[] vizinhos2) {
		for (Vizinho vizinho : vizinhos2) {
			this.AddVizinho(vizinho);
		}
	}
} 