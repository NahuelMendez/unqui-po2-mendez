package ar.edu.unq.tp6;

public abstract class SolicitudDeCredito {
	
	private Cliente cliente;
	private Integer monto;
	private Integer cuotas;
	
	public SolicitudDeCredito(Cliente cliente, Integer monto, Integer cuotas) {
		
		this.cliente = cliente;
		this.monto = monto;
		this.cuotas = cuotas;
		cliente.crearSolicitud(this);
		
	}

}
