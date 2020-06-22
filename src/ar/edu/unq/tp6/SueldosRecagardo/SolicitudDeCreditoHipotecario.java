package ar.edu.unq.tp6.SueldosRecagardo;

public class SolicitudDeCreditoHipotecario extends SolicitudDeCredito {

	public SolicitudDeCreditoHipotecario(Cliente cliente, Integer monto, Integer cuotas) {
		super(cliente, monto, cuotas);
	}

	@Override
	public Boolean chequearAprobacion() {
		return montoDeCuotaPermitido() && requisitoValorDeGarantia() && requisitoDeEdadAprobado();
	}

	private Boolean requisitoDeEdadAprobado() {
		Integer edadCliente = super.getCliente().getEdad();
		return edadCliente + añosDePago() < 65;
	}

	private Integer añosDePago() {
		Integer plazo = super.getPlazoEnMeses();
		if (plazo < 12) {
			return 0;
		} else if (plazo == 12) {
			return 1;
		} else  {
			return 2;
		}
	}

	private Boolean requisitoValorDeGarantia() {
		Double valorGarantia = super.getCliente().getPropiedadInmobiliaria().getValorFiscal() * 0.70;
		Integer montoTotalSolicitado = super.getMonto();
		return valorGarantia > montoTotalSolicitado;
	}

	private Boolean montoDeCuotaPermitido() {
		Double montoLimite = super.getCliente().getSueldoNetoMensual() * 0.50;
		Integer valorCuotaCredito = super.calcularMontoMensual();
		return montoLimite >= valorCuotaCredito;
	}

}
