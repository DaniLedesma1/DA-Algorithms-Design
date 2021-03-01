import java.util.Collections;
import java.util.PriorityQueue;

public class Invaden extends JudgeSolver{

	 private int nCiudades;
	 private PriorityQueue<Integer> defensa;
	 private PriorityQueue<Integer> ataque;
	 
	 
	 public Invaden(String s) {
		 super(SENTINEL, s);
	 }
	 
	 
	 private void leerCaso() {
		int p;
	
		nCiudades = sc.nextInt();
		defensa = new PriorityQueue<Integer>(nCiudades, Collections.reverseOrder());
		ataque = new PriorityQueue<Integer>(nCiudades, Collections.reverseOrder());
		
		for(int i = 0; i < nCiudades; i++) {
			p = sc.nextInt();
			defensa.add(p);
			
		}
		for(int i = 0; i < nCiudades; i++) {
			p = sc.nextInt();
			ataque.add(p);
			
		}
	}
	 
	 
	public int resuelveCaso() {
		int exitos = 0;
		
		while(!defensa.isEmpty()) {
			if(defensa.peek() > ataque.peek()) {
				defensa.poll();
			}
			else {
				defensa.poll();
				ataque.poll();
				exitos++;
			}
		}
		
		
		return exitos;
	}
	 
	@Override
	public boolean caseSolver() {
		try {
			leerCaso();
			System.out.println(resuelveCaso());
			return false;
		}catch(Exception e){
			return true;
		}
	}

}
