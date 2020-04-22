package ar.edu.unq.tp4;

public class Ingreso {

	private String mesDePercepcion;
	private String concepto;
	private Double monto;
	
	public Ingreso(String mes, String concepto, Double monto) {
		this.mesDePercepcion = mes;
		this.concepto = concepto;
		this.monto = monto;
	}
	
	public Double getMonto() {
		return this.monto;
	}
	
	public Double getMontoImponible() {
		return getMonto();
	}
	
}
