package ar.edu.unq.tp5;

public abstract class Factura implements Cobrable {
	
	public abstract Integer calcularCosto();
	
	public void cobrarseEnCaja(Caja caja) {
		caja.agregarMontoACobrar(this.calcularCosto());
		caja.registrarPago(this);
	}
	
}
