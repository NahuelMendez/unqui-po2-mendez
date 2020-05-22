package ar.edu.unq.tp7;

public class Carta {

	private String palo;
	private String valor;

	public Carta(String valor, String palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public String getValor() {
		return this.valor;
	}

	public String getPalo() {
		return this.palo;
	}
	
	public Boolean esDeValorSuperiorA(Carta carta) {
		return this.getValorNumerico() > carta.getValorNumerico();
	}
	
	public Integer getValorNumerico() {
		if (valor.equals("J")) {
			return 10;
		} else if (valor.equals("Q")) {
			return 11;
		} else if (valor.equals("K")) {
			return 12;
		} else if (valor.equals("A")) {
			return 13;
		} else {
			return Integer.parseInt(valor);
		}
	}
}
