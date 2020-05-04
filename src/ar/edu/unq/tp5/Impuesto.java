package ar.edu.unq.tp5;

public class Impuesto extends Factura {

	private Integer tasaFija;

	public Impuesto(Integer tasaFija) {
		this.tasaFija = tasaFija;
	}

	public Integer calcularCosto() {
		return this.tasaFija;
	}

}
