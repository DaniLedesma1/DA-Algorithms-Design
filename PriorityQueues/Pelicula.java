
public class Pelicula implements Comparable<Pelicula>{

	
	private int ini, dur;
	
	
	public Pelicula(int inicio, int duracion) {
		this.ini = inicio;
		this.dur = duracion;
	}
	
	public int getInicio() {
		return this.ini;
	}
	
	public int getDuracion() {
		return this.dur;
	}
	
	@Override
	public int compareTo(Pelicula p) {
		if(p.getInicio() > this.ini) {
			return -1;
		}
		else if(p.getInicio() < this.ini){
			return 1;
		}
		else {
			return 0;
		}
	}

}
