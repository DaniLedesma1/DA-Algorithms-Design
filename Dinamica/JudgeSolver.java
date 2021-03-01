
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class JudgeSolver {

	public static enum TipoSolucion{ QUANTY, SENTINEL};
	protected static BufferedReader in = new BufferedReader( new InputStreamReader( System.in) );
	
	protected static PrintStream out = System.out;
	
	protected static PrintStream err = System.err;
	
	protected static Scanner sc = new Scanner(in);

	protected int numCaso = 0;

	protected boolean DEBUG = false;

	private boolean DOMJUDGE;
	
	public static final TipoSolucion QUANTY = TipoSolucion.QUANTY;
	
	public static final TipoSolucion SENTINEL = TipoSolucion.SENTINEL;
	
	private TipoSolucion solutionType = QUANTY;

	private String fileName = "casos.txt";

	public JudgeSolver(){
		DOMJUDGE = systemIsDomjudge();
	}
	
	public JudgeSolver(TipoSolucion solutionType){
		this.solutionType = solutionType;
		DOMJUDGE = systemIsDomjudge();
	}
	
	public JudgeSolver(TipoSolucion solutionType, String fileName){
		this.DOMJUDGE = systemIsDomjudge();
		this.solutionType = solutionType;
		this.fileName = fileName;
	}
	
	public abstract boolean caseSolver();
	
	public void run() {
		if ( !DOMJUDGE ) { 
			try {
				in = new BufferedReader( new FileReader(this.fileName) );
				sc = new Scanner(in);
			} catch (FileNotFoundException e) {
				err.println("ERROR: Fichero no localizado. LEO DEL TECLADO."); 
			}
		}

		switch (this.solutionType) {
			case QUANTY:
				runQuanty();
				break;
			case SENTINEL:
				runSentinel();
				break;
			default:
				err.println("ERROR: Not correctly defined solutionType");
		}
		
		sc.close();

	}
	
	private void runSentinel() {
		boolean fin;
		do {
			numCaso++;
			fin = caseSolver();
		} while (!fin);		
	}
	
	private void runQuanty() {
		int numCasos =-1; 
		boolean error = false;
		try {
			numCasos = sc.nextInt(); //Integer.parseInt(in.readLine());
		} catch (Exception e) {
			error = true;
		}
		if (error) err.println("ERROR: En la lectura del numero de casos."); 
		else {
			for (int i = 0; i < numCasos && !error; i++) {
				numCaso++;
				error = caseSolver();
			}
			if (error) err.println("ERROR: En la lectura de un caso con el patron cantidad."); 
		}
	}
	
	public boolean isDomJudge() {
		return DOMJUDGE;
	}
	
	public void onDomjudge() {
		DOMJUDGE = true;
	}

	public void offDomjudge() {
		DOMJUDGE = false;
	}

	public void onDebug() {
		DEBUG = true;
	}

	public void offDebug() {
		DEBUG = false;
	}
	
	private static boolean systemIsDomjudge() {
		String domOption = System.getProperty("DOMJUDGE");
		return domOption != null && (domOption.equals("1") || domOption.equals("true"));
	}

}