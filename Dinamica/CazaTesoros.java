import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class CazaTesoros extends JudgeSolver{
	
	
	private int t, nTesoros;
	private int nobjetos = 0;
	private ArrayList<Cofre> c;
	private int[][] m;
	private Vector<Integer> tiem, bot;
	private Vector<Integer> resulttiem, resultbot;
	public CazaTesoros(String s) {
		super(SENTINEL, s);
	}
	
	private void leerCaso() {
		int aux1, aux2;
		t = sc.nextInt();
		nTesoros = sc.nextInt();
		c = new ArrayList<Cofre>(nTesoros);
		c.add((new Cofre(0,0)));
		tiem = new Vector<Integer>(nTesoros);
		bot = new Vector<Integer>(nTesoros);
		resulttiem = new Vector<Integer>(nTesoros);
		resultbot = new Vector<Integer>(nTesoros);
		
		
		for(int i = 0; i < nTesoros; i++) {
			aux1 = sc.nextInt();
			aux2 = sc.nextInt();
			c.add(new Cofre(aux1*3, aux2));
			tiem.add(aux1*3);
			bot.add(aux2);
		}
		Collections.sort(c);
	}
	
	
	private void CasoBase() {
		for(int i = 0; i < nTesoros+1; i++) {
			m[i][0] = 0;
			for(int j = 0; j < t; j++) {
				m[0][j] = 0;
			}
		}
	}
	private void resuelveCaso() {
		m = new int[nTesoros+1][t+1];
		CasoBase();
		for(int i = 1; i < nTesoros+1; i++) {
			for(int j = 1; j < t+1; j++) {
				if(c.get(i).gett() > j) {
					m[i][j] = m[i-1][j];
				}
				else {
					m[i][j] = Integer.max(m[i-1][j], (m[i-1][j-c.get(i).gett()] + c.get(i).getb()));
				}
			}
		}
		System.out.println(m[nTesoros][t]);
		
	}
	
	private void calculoResto() {
		int j = t;
		for(int i = nTesoros; i >= 1; i--) {
			
			if(m[i][j] != m[i-1][j]) {
				nobjetos++;
				resulttiem.add(c.get(i).gett());
				resultbot.add(c.get(i).getb());
				j = j - c.get(i).gett();
			}
			
		}
		System.out.println(nobjetos);
	}
	
	private void queobjetos() {
		
		boolean encontrado = false;
		int j = 0;
		
		for(int i = 0; i < tiem.size(); i++) {
			if(encontrado) {
				i =0;
				encontrado = false;
			}
			if(nobjetos == 0) {
				return;
			}
			j = 0;
			while(j < resulttiem.size() && !encontrado) {
				if((tiem.get(i) == resulttiem.get(j)) && (bot.get(i) == resultbot.get(j))) {
					System.out.println(tiem.get(i)/3 + " " + bot.get(i));
					nobjetos--;
					resulttiem.remove(j);
					resultbot.remove(j);
					encontrado = true;
				}
				else {
					j++;
				}
			}
		}
		
		
		
	}
	
	
	@Override
	public boolean caseSolver() {
		try {
			leerCaso();
			resuelveCaso();
			calculoResto();
			
			queobjetos();
			System.out.println("----");
			return false;
		}catch(Exception e) {
			return  true;
		}
	}
}
