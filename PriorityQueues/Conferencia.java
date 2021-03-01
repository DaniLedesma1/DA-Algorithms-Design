
public class Conferencia implements Comparable<Conferencia>{

	private int horaIni;
	private int horaFin;
	
	
	public Conferencia(int horaIni, int horaFin) {
		this.horaIni = horaIni;
		this.horaFin = horaFin;
	}

	public int getHoraIni() {
		return this.horaIni;
	}
	
	public int getHoraFin() {
		return this.horaFin;
	}

	@Override
	public int compareTo(Conferencia o) {
		
		if(o.getHoraIni() > this.horaIni) {
			return -1;
		}
		else if(o.getHoraIni() == this.horaIni) {
			if(o.getHoraFin() > this.horaFin) {
				return -1;
			}
			else if(o.getHoraFin() == this.horaFin) {
				return 0;
			}
			else {
				return 1;
			}
		}	
		else {
			return 1;
		}
		
	}
}