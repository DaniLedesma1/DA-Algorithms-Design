import java.util.PriorityQueue;
import java.util.Vector;

public class Planificador extends JudgeSolver{
	
	private int nConferencias;
	private PriorityQueue<Conferencia> c;
	
	public Planificador(String s) {
		super(SENTINEL, s);
	}

	private void leerCaso() {
		int horaini, horafin;
		nConferencias = sc.nextInt();
		c = new PriorityQueue<Conferencia>(nConferencias);
		
		for(int i = 0; i < nConferencias; i++) {
			horaini = sc.nextInt();
			horafin = sc.nextInt();
			c.add(new Conferencia(horaini, horafin));
		}
	}
	
	
	public int resuelveCaso() {
		int nsalas = 1;
		int ini, fin, index = 0;
		Vector<Integer> v = new Vector<Integer>(nConferencias);
		Conferencia con, con2;
		con = c.poll();
		ini = con.getHoraIni();
		fin = con.getHoraFin();
		v.add(fin);
		
		while(!c.isEmpty()) {
			con2 = c.poll();
			if(!haysalalibre(v, con2.getHoraIni(), index)) {
				nsalas++;
				v.add(con2.getHoraFin());
			}
			else {
				for(int i = 0; i < index; i++) {
					v.remove(i);
				}
				ini = con2.getHoraIni();
				fin = con2.getHoraFin();
			}
		}
		return nsalas;
	}
	
	
	public boolean haysalalibre(Vector<Integer> v, int ini, int index) {
		boolean hay = false;
		int cont = 0;
		while(cont < v.size() && (hay == false)) {
		
			if(ini >= v.get(cont)) {
				hay = true;
				index = cont;
			}else {
				cont++;
			}
		}
		return hay;
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
