package ar.edu.unq.tp7.SueldosRecagardo;

public abstract class SolicitudDeCredito {
	
	private Cliente cliente;
	private Integer monto;
	private Integer cuotas;
	
	public abstract Boolean chequearAprobacion();
	
	public SolicitudDeCredito(Cliente cliente, Integer monto, Integer cuotas) {
		
		this.cliente = cliente;
		this.monto = monto;
		this.cuotas = cuotas;
		cliente.crearSolicitud(this);
		
	}
	
	public Integer calcularMontoMensual() {
		return this.monto / this.cuotas;
	}
	
	public Integer getMonto() {
		return this.monto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Integer getPlazoEnMeses() {
		return this.cuotas;
	}

}
