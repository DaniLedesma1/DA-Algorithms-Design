import java.util.ArrayList;

public class Diana extends JudgeSolver{
	
	
	private int puntuacion, nDianas;
	private ArrayList<Integer> d;
	private int[][] m;
	private int INFINITO = -1;
	
	
	public Diana(String s) {
		super(SENTINEL, s);
	}
	
	private void leerCaso() {
		puntuacion = sc.nextInt();
		nDianas = sc.nextInt();
		d = new ArrayList<Integer>(nDianas);
		
		d.add(0);
		
		
		for(int i = 0; i < nDianas; i++) {
			d.add(sc.nextInt());		
		}
	}
	
	
	private void CasoBase() {
		for(int i = 0; i < nDianas+1; i++) {
			m[i][0] = 0;
			for(int j = 1; j < puntuacion+1; j++) {
				m[0][j] = INFINITO;
			}
		}
	}
	
	private void resuelveCaso() {
		m = new int[nDianas+1][puntuacion+1];
		CasoBase();
		for(int i = 1; i < nDianas+1; i++) {
			for(int j = 1; j < puntuacion+1; j++) {
				if(d.get(i) > j) {
					m[i][j] = m[i-1][j];
				}
				else {
					m[i][j] = Integer.min(m[i-1][j], (m[i][j-d.get(i)] + 1));
				}
			}
		}
		if(m[nDianas][puntuacion] >= INFINITO) {
			System.out.println("IMPOSIBLE");
		}
		else {
			System.out.print(m[nDianas][puntuacion] + ":");
		}
		
	}
	
	private void calculoDianas() {
		
		int i = d.size()-1;
		int j = puntuacion;
		while(j > 0 && i > 0) {
			
			if( d.get(i) < j && m[i][j] == m[i][j-d.get(i)]+1) {
				
				System.out.print(" " + d.get(i));
				j = j - d.get(i);
			}
			else {
				if(j - d.get(i) == 0) {
					
					System.out.print(" " + d.get(i));
					j = j - d.get(i);
				}
				i--;
			}	
		}
		System.out.println();
	}
	
	
	
	
	@Override
	public boolean caseSolver() {
		try {
			leerCaso();
			resuelveCaso();
			calculoDianas();
			return false;
		}catch(Exception e) {
			return  true;
		}
	}
}

