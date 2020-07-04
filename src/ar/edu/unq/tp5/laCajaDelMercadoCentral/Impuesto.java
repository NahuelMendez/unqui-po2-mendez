package ar.edu.unq.tp5.laCajaDelMercadoCentral;

public class Impuesto extends Factura {

	private Integer tasaFija;

	public Impuesto(Integer tasaFija) {
		this.tasaFija = tasaFija;
	}

	public Integer calcularCosto() {
		return this.tasaFija;
	}

}
