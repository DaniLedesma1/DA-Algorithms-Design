import java.util.Collections;
import java.util.PriorityQueue;

public class Telesilla extends JudgeSolver{

	
	private PriorityQueue<Integer> ascendente;
	private PriorityQueue<Integer> descendente;
	private int nPersonas;
	private int maxPeso;
	
	
	public Telesilla(String string) {
		super(SENTINEL, string);
	}
	
	
	private void leerCaso() {
		int p;
		maxPeso = sc.nextInt();
		nPersonas = sc.nextInt();
		
		ascendente = new PriorityQueue<Integer>(nPersonas);
		descendente = new PriorityQueue<Integer>(nPersonas, Collections.reverseOrder());
		
		for(int i = 0; i < nPersonas; i++) {
			p = sc.nextInt();
			ascendente.add(p);
			descendente.add(p);
		}
	}
	
	public int resuelveCaso() {
		
		int nSillas = 0;
		int cont = 0;
		if(nPersonas == 0) {
			return 0;
		}
		else if(nPersonas == 1) {
			return 1;
		}
		else {
			if((nPersonas % 2) != 0) {
				nSillas++;
				cont++;
				ascendente.remove(descendente.peek());
				descendente.poll();
			}
			while(cont < nPersonas) {
				if((ascendente.peek() + descendente.peek()) > maxPeso) {
					nSillas ++;
					cont++;
					descendente.poll();
				}
				else {
					nSillas++;
					cont += 2;
					descendente.poll();
					ascendente.poll();
				}
			}
		}
		return nSillas;
	}

	

	@Override
	public boolean caseSolver() {
		try {
			leerCaso();
			System.out.println(resuelveCaso());
			return false;
		}
		catch(Exception e) {
			return true;
		}
		
	}

	

}
