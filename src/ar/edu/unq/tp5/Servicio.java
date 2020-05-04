package ar.edu.unq.tp5;

public class Servicio extends Factura {

	private Integer unidadesConsumidas;
	private Integer costoPorUnidad;

	public Servicio(Integer costoPorUnidad, Integer unidadesConsumidas) {
		this.costoPorUnidad = costoPorUnidad;
		this.unidadesConsumidas = unidadesConsumidas;
	}

	public Integer calcularCosto() {
		return this.costoPorUnidad * this.unidadesConsumidas;
	}

}
