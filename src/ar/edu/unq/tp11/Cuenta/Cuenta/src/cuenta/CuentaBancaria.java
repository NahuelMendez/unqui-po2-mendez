package ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta;

public abstract class CuentaBancaria {
	private HistorialMovimientos historialDeMovimientos;
	private Notificador notificador;
	private Integer saldo;
	
	public CuentaBancaria(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super();
		this.historialDeMovimientos = historialDeMovimientos;
		this.notificador = notificador;
		this.saldo = saldo;
	}

	public Integer getSaldo() {
		return this.saldo;
	}
	
	public void extraer(Integer monto) {
		if(this.elMontoEsExtraible(monto)) {
			this.saldo -=monto;
			this.historialDeMovimientos.registrarMovimiento("Extracción", monto);
			this.notificador.notificarNuevoSaldoACliente(this);
		}
	}
	protected abstract Boolean elMontoEsExtraible(Integer monto);
}
