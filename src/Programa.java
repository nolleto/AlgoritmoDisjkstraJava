import java.util.ArrayList;


public class Programa {

	public static void main(String[] args) {
	
		Nodo v0 = new Nodo(0);
		Nodo v1 = new Nodo(1);
		Nodo v2 = new Nodo(2);
		Nodo v3 = new Nodo(3);
		Nodo v4 = new Nodo(4);
		Nodo v5 = new Nodo(5);
		Nodo v6 = new Nodo(6);
		Nodo v7 = new Nodo(7);
		
		
		v0.AddVizinhos(new Vizinho[] {
				new Vizinho(v5, 1),
				new Vizinho(v2, 1)
		});
		v1.AddVizinhos(new Vizinho[] {
				new Vizinho(v0, 1)
		});
		v2.AddVizinhos(new Vizinho[] {
				new Vizinho(v1, 1),
				new Vizinho(v3, 1)
		});
		v3.AddVizinhos(new Vizinho[] {
				new Vizinho(v0, 1)
		});
		v4.AddVizinhos(new Vizinho[] {
				new Vizinho(v2, 1)
		});
		v5.AddVizinhos(new Vizinho[] {
				new Vizinho(v6, 1),
				new Vizinho(v7, 1)
		});
		v6.AddVizinhos(new Vizinho[] {
				new Vizinho(v4, 1)
		});
		v7.AddVizinhos(new Vizinho[] {
				new Vizinho(v4, 1)
		});
		
		Nodo[] nodos = new Nodo[] {
				v0,v1,v2,v3,v4,v5,v6,v7
		};
		
		GerarDistancias(nodos);
		GerarGraficoLIINDU(nodos);
	}

	private static void GerarGraficoLIINDU(Nodo[] nodos) {
		for (Nodo nodo : nodos) {
			System.out.format("%1$2s %2$2s %3$2s %4$2s %5$2s %6$2s %7$2s %8$2s", nodo.distancias[0], nodo.distancias[1], nodo.distancias[2], nodo.distancias[3], nodo.distancias[4], nodo.distancias[5], nodo.distancias[6], nodo.distancias[7]);
			System.out.println("");
			System.out.println("--------------------------------");
		}
	}
	
	private static void GerarDistancias(Nodo[] nodos) {
		int count = nodos.length;
		for (Nodo nodo : nodos) {
			ArrayList<Integer> analisados = new ArrayList<Integer>();
			//HashMap<Integer, Integer> dist = nodo.CompletarDistancias(count);
			int[] dist = GerarDistancias(count);
			
			dist[nodo.id] = 0;
			analisados.add(nodo.id);
			
			Analise(nodos, nodo, dist, analisados, 0);
			nodo.distancias = dist;
		}
	}
	
	private static int[] GerarDistancias(int count) {
		int[] dist = new int[count];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		return dist;
	}
	
	private static void Analise(Nodo[] nodos, Nodo nodo, int[] dist, ArrayList<Integer> analisados, int acumulador) {
		DistVizinhos(nodo, dist, acumulador);
		int menor = MenorIndex(dist, analisados);
		analisados.add(menor);
		
		if (nodos.length > analisados.size()) {
			Analise(nodos, nodos[menor], dist, analisados, acumulador + 1);
		}
	}
	
	private static void DistVizinhos(Nodo nodo, int[] dist, int acumulador){
		for (Vizinho v : nodo.vizinhos) {
			//nodo.IdDistancias.put(v.nodo.id, v.distancia);
			if (dist[v.nodo.id] > (v.distancia + acumulador)) {
				dist[v.nodo.id] = v.distancia + acumulador;
			}
		}
	}
	
	private static int MenorIndex(int[] dist, ArrayList<Integer> analisados) {
		int md = Integer.MAX_VALUE;
		int mi = -1;
		for (int i = 0; i < dist.length; i++) {
			int d = dist[i];
			if (!analisados.contains(i) && md > d) {
				md = d;
				mi = i;
			}
		}
		return mi;
	}
	
	
	
	
}