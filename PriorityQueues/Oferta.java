import java.util.Collections;
import java.util.PriorityQueue;


public class Oferta extends JudgeSolver{

	private PriorityQueue<Integer> precios;
	private int N;
	
	public Oferta(String string) {
		super(SENTINEL, string);
	}
	
	private void leerCasos() {
		N = sc.nextInt();
		precios = new PriorityQueue<Integer>(N, Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			precios.add(sc.nextInt());
		}
	}
	
	
	public int resuelveCaso() {
		
		int acumulador = 0;
		
		if(N <= 2) {
			return acumulador;
		}
		else {
			while((precios.poll() != null) && (precios.poll() != null)) {
				if(precios.size() > 0) {
					acumulador += precios.poll();
				}
			}
		}
		return acumulador;
	}
	

	@Override
	public boolean caseSolver() {
		try {
			leerCasos();
			System.out.println(resuelveCaso());
			return false;
			
		}catch(Exception e) {
			return true;
		}
		
	}

}
