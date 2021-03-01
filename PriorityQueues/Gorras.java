
import java.util.PriorityQueue;

public class Gorras extends JudgeSolver{

	private int nPartidos;
	private PriorityQueue<Integer> gorras;
	
	public Gorras(String s) {
		super(SENTINEL, s);
	}
	
	private void leerCaso() {
		int p;
	
		nPartidos = sc.nextInt();
		gorras = new PriorityQueue<Integer>(nPartidos);
		for(int i = 0; i < nPartidos; i++) {
			p = sc.nextInt();
			gorras.add(p);
			
		}
		
	}
	
	public int resuelveCaso() {
		int min = 0, acum;
		Integer p1, p2;
		if(gorras.size() == 1) {
			return 0;
		}
		else {
			while(!((p1 = gorras.poll()) == null) && !((p2= gorras.poll()) == null)) {
				acum = p1 + p2;
				min += acum;
				gorras.add(acum);
			}
			
		}
		return min;
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
