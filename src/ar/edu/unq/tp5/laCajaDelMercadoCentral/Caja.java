package ar.edu.unq.tp5.laCajaDelMercadoCentral;

public class Caja {
	
	private Integer montoACobrar;
	
	public Caja() {
		this.montoACobrar = 0;
	}

	public Integer getMontoACobrar() {
		return montoACobrar;
	}

	public void cobrarACliente(Cliente cliente) {
		for (int i = 0; i < cliente.getCobrables().size(); i++) {
			this.registrarCobrable(cliente.getCobrables().get(i));
		}
		informarMontoTotalAPagar(cliente);
	}

	private void informarMontoTotalAPagar(Cliente cliente) {
		cliente.setSaldoAPagar(this.getMontoACobrar());
	}

	private void registrarCobrable(Cobrable cobrable) {
		cobrable.cobrarseEnCaja(this);
	}

	public void agregarMontoACobrar(Integer costoCobrable) {
		this.montoACobrar += costoCobrable;
	}

	public void registrarPago(Factura factura) {
		/* Se avisa a la agencia recaudadora sobre el pago de la factura */
	}

}
