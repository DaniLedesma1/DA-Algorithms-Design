
public class Alimentos implements Comparable<Alimentos>{

	public double valor, peso;
	public double fraccion;
	
	public Alimentos(double p, double v) {
		this.valor = v;
		this.peso = p;
		this.fraccion = (v/p);
	}
	
	public double getv() {
		return this.valor;
	}
	
	public double getp() {
		return this.peso;
	}
	
	public double getf() {
		return this.fraccion;
	}
	
	@Override
	public int compareTo(Alimentos a) {
		if(a.getf() < this.fraccion) {
			return -1;
		}
		else if(a.getf() > this.fraccion) {
			return 1;
		}
		else {
			if(a.getp() > this.peso) {
				return -1;
			}
			else if(a.getp() < this.peso) {
				return 1;
			}
			else {
				if(a.getv() > this.valor) {
					return -1;
				}
				else if(a.getv() < this.valor) {
					return 1;
				}
				else {
					return  0;
				}
			}
		}
	}

}
