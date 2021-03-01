
public class Agujeros extends JudgeSolver{

	private int nAgujeros;
	private int longitud;
	
	public Agujeros(String s) {
		super(SENTINEL, s);
	}
	
	
	public int resuelveCaso(){
		
		int nParches = 1;
		int sigAgujero;
		int distActual = 0;
		nAgujeros = sc.nextInt();
		longitud = sc.nextInt();
		
		if(nAgujeros == 0) {
			return 0;
		}
		else if(nAgujeros == 1) {
			sc.nextLine();
			sc.nextLine();
			return 1;
		}
		else {
			distActual = sc.nextInt();
			for(int i = 1; i < nAgujeros; i++) {
				sigAgujero = sc.nextInt();
				if((distActual + longitud) < sigAgujero) {
					nParches++;
					distActual = sigAgujero;
				}
			}
		}
		
		
		return nParches;
	}
	
	@Override
	public boolean caseSolver() {
		try {
			System.out.println(resuelveCaso());
			return false;
		}
		catch(Exception e) {
			return true;
		}
	}

}
