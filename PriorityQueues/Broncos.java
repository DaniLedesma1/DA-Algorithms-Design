import java.util.Collections;
import java.util.PriorityQueue;

public class Broncos extends JudgeSolver{

	private int nPartidos;
	private PriorityQueue<Integer> rivales;
	private PriorityQueue<Integer> broncos;
	
	public Broncos(String s) {
		super(SENTINEL, s);
	}
	
	private void leerCaso() {
		int p;
	
		nPartidos = sc.nextInt();
		rivales = new PriorityQueue<Integer>(nPartidos);
		broncos = new PriorityQueue<Integer>(nPartidos, Collections.reverseOrder());
		for(int i = 0; i < nPartidos; i++) {
			p = sc.nextInt();
			rivales.add(p);
			
		}
		for(int i = 0; i < nPartidos; i++) {
			p = sc.nextInt();
			broncos.add(p);
			
		}
	}
	
	public int resuelveCaso() {
		int maxdif = 0;
		int partRivales, partBroncos;
		for(int i = 0; i < nPartidos; i++) {
			partRivales = rivales.poll();
			partBroncos = broncos.poll();
			if(partBroncos > partRivales) {
				maxdif += partBroncos - partRivales;
			}
		}
		return maxdif;
	}
	
	
	@Override
	public boolean caseSolver() {
		
		try {
			leerCaso();
			System.out.println(resuelveCaso());
			return false;
		}catch(Exception e) {
			return true;
		}
	}

	
}
