import java.util.ArrayList;
import java.util.PriorityQueue;

public class Supervivencia extends JudgeSolver{

	public int maxPeso;
	public int nAlimentos;
	PriorityQueue<Alimentos> a;
	ArrayList<Double> pesos;
	ArrayList<Double> valores;
	public Supervivencia(String s) {
		super(SENTINEL, s);
	}
	
	
	public void leerCaso() {
		maxPeso = sc.nextInt();
		nAlimentos = sc.nextInt();
		a = new PriorityQueue<Alimentos>(nAlimentos);
		pesos = new ArrayList<Double>();
		valores = new ArrayList<Double>();
		
		for(int i = 0; i < nAlimentos; i++) {
			pesos.add(sc.nextDouble());
		}
		for(int i = 0; i < nAlimentos; i++) {
			valores.add(sc.nextDouble());
		}
		for(int i = 0; i < nAlimentos; i++) {
			a.add(new Alimentos(pesos.get(i), valores.get(i)));
		}
		
		
	}
	

	public void resuelveCaso() {
		double acum = 0;
		double aux, aux2;
		Alimentos b;
		double maxValor = 0, aux3;
	
		while(acum < maxPeso) {
			if((a.peek().getp() + acum) <= maxPeso) {
				acum += a.peek().getp();
				maxValor += a.peek().getv();
				b = a.poll();
				a.add(new Alimentos(b.getp(), b.getv()/2));
			}
			else {
				aux = maxPeso - acum;
				aux2 = aux*a.peek().getv();
				aux3 = aux2/a.peek().getp();
				acum = maxPeso;
				maxValor += aux3;
			}
		}
		System.out.println(maxValor);
		
	}
	
	
	@Override
	public boolean caseSolver() {
		try {
			leerCaso();
			resuelveCaso();
			return false;
		}catch(Exception e) {
			return  true;
		}
	}
}
