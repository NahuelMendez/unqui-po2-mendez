package ar.edu.unq.tp7.SueldosRecagardo;

public class SolicitudDeCreditoPersonal extends SolicitudDeCredito{

	public SolicitudDeCreditoPersonal(Cliente cliente, Integer monto, Integer cuotas) {
		super(cliente, monto, cuotas);
	}

	public Boolean chequearAprobacion() {
		return cumpleIngresosAnuales() & limiteDeMontoNoSuperado();
	}

	private Boolean limiteDeMontoNoSuperado() {
		Double limite = super.getCliente().getSueldoNetoMensual() * 0.70;
		Integer cuota = super.calcularMontoMensual();
		return cuota < limite;
		
	}

	private Boolean cumpleIngresosAnuales() {
		return super.getCliente().calcularSueldoNetoAnual() > 15000;
	}

}
