import java.util.PriorityQueue;

public class Cine extends JudgeSolver{

	
	private PriorityQueue<Pelicula> p;
	private int nPelis;
	
	public Cine(String string) {
		super(SENTINEL, string);
	}

	private void leerCaso() {
		int hora, min, duracion, total;
		
		nPelis = sc.nextInt();
		p = new PriorityQueue<Pelicula>(nPelis);
		
		for(int i = 0; i < nPelis; i++) {
			String hor[] = sc.next().split(":");
			hora = Integer.parseInt(hor[0]);
			min = Integer.parseInt(hor[1]);
			duracion = sc.nextInt();
			total = (hora*60 + min);
			p.add(new Pelicula(total, duracion + 10));
		}
	}
	
	public int resuelveCaso() {
		int vistas = 1;
		Pelicula pel = p.poll();
		int iniActual = pel.getInicio();
		int durActual = pel.getDuracion();
		int sigHora, sigDur;
		
		while(!p.isEmpty()) {
			pel = p.poll();
			sigHora = pel.getInicio();
			sigDur = pel.getDuracion();
			if((iniActual + durActual) <= sigHora) {
				vistas++;
				iniActual = sigHora;
				durActual = sigDur;
			}
		}
		
		return vistas;
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
