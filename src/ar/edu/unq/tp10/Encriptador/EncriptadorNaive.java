package ar.edu.unq.tp10.Encriptador;

public class EncriptadorNaive {

	private IEstrategiaDeEncriptacion estrategiaE;
	private IEstrategiaDeDesencriptacion estrategiaD;
	
	public EncriptadorNaive(IEstrategiaDeEncriptacion estrategiaE, IEstrategiaDeDesencriptacion estrategiaD) {
		this.estrategiaE = estrategiaE;
		this.estrategiaD = estrategiaD;
	}
	
	public void setEstrategiaDeEncriptacion(IEstrategiaDeEncriptacion estrategiaE) {
		this.estrategiaE = estrategiaE;
	}
	
	public void setEstrategiaDeDesencriptacion(IEstrategiaDeDesencriptacion estrategiaD) {
		this.estrategiaD = estrategiaD;
	}
	
	public String encriptar(String word) {
		return estrategiaE.encriptar(word);
	}

	public String desencriptar(String word) {
		return this.estrategiaD.desencriptar(word);
	}

}
