package ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta;

public class CuentaCorriente extends CuentaBancaria{
	private Integer limiteDescubierto;
	
	public CuentaCorriente(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo, Integer limiteDescubierto) {
		super(historialDeMovimientos, notificador, saldo);
		this.limiteDescubierto = limiteDescubierto;
	}

	@Override
	protected Boolean elMontoEsExtraible(Integer monto) {
		return this.getSaldo() + this.limiteDescubierto >= monto;
	}

}
