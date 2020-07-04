package ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta;

public class CajaAhorro extends CuentaBancaria{

	public CajaAhorro(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super(historialDeMovimientos, notificador, saldo);
	}

	@Override
	protected Boolean elMontoEsExtraible(Integer monto) {
		return this.getSaldo() >= monto;
	}
	

}
