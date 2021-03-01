
public class Cofre implements Comparable<Cofre>{

	private int botin;
	private int tiempo;
	
	public Cofre(int tiempo, int botin) {
		this.tiempo = tiempo;
		this.botin = botin;
	}
	
	public int gett() {
		return this.tiempo;
	}
	
	public int getb() {
		return this.botin;
	}
   
	@Override
	public int compareTo(Cofre o) {
		if(o.gett() > this.tiempo) {
			return -1;
		}
		else if(o.gett() < this.tiempo) {
			return 1;
		}
		else {
			if(o.getb() > this.botin) {
				return 1;
			}
			else if(o.getb() < this.botin) {
				return -1;
			}
			else {
				return 0;
			}
		}

	}

}
