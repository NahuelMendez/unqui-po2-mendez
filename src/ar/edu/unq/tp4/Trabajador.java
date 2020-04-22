package ar.edu.unq.tp4;

import java.util.ArrayList;

public class Trabajador {
	
	private ArrayList<Ingreso> ingresos;
	
	public Trabajador() {
		ingresos = new ArrayList<Ingreso>();
	}
	
	public void agregarIngreso(Ingreso ingreso) {
		this.ingresos.add(ingreso);
	}

	public Double getTotalPercibido() {
		Double totalPecibido = 0d;
		for (Ingreso ingreso : ingresos) {
			totalPecibido += ingreso.getMonto();
		}
		return totalPecibido;
	}

	public Double getMontoImponible() {
		Double montoImponible = 0d;
		for (Ingreso ingreso : ingresos) {
			montoImponible += ingreso.getMontoImponible();
		}
		return montoImponible;
	}

	public Double getImpuestoAPagar() {
		Double impuesto = this.getMontoImponible() * 2d / 100d;
		return impuesto;
	}

}
