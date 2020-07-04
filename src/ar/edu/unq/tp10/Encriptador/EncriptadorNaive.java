package ar.edu.unq.tp10.Encriptador;

public class EncriptadorNaive {

	private IEstrategiaDeEncriptacion estrategia;
	
	public EncriptadorNaive(IEstrategiaDeEncriptacion estrategia) {
		this.estrategia = estrategia;
	}
	
	public void setEstrategiaDeEncriptacion(IEstrategiaDeEncriptacion estrategia) {
		this.estrategia = estrategia;
	}
	
	public String encriptar(String word) {
		return estrategia.encriptar(word);
	}

	public String desencriptar(String word) {
		return this.estrategia.desencriptar(word);
	}

}
