package ar.edu.unq.tp4.ejercicio2;

public class IngresoHorasExtra extends Ingreso{

	private Integer cantidadHorasExtra;

	public IngresoHorasExtra(String mes, String concepto, Double monto, Integer cantidadHorasExtra) {
		super(mes, concepto, monto);
		this.cantidadHorasExtra = cantidadHorasExtra;
	}
	
	@Override
	public Double getMontoImponible() {
		return 0d;
	}
	
}
