package ar.edu.unq.tp7.ayudandoAlSoberano;

public class CajaDeAhorro extends CuentaBancaria {
	
	// CajaDeAhorro es una de las clases concretas del patron
	
	private int limite;
	
	public CajaDeAhorro(String titular, int limite){
		super(titular);
		this.limite = limite;
	}
	
	public int getLimite(){
		return this.limite;
	}

	@Override
	// este metodo implementa la operacion primitiva
	protected Boolean cumpleRequisitosDeExtraccion(Integer monto) {
		return elMontoEsMenorAlSaldo(monto) && elMontoEsMenorAlLimite(monto);
	}

	private boolean elMontoEsMenorAlLimite(Integer monto) {
		return this.getLimite() >= monto;
	}

	private boolean elMontoEsMenorAlSaldo(Integer monto) {
		return this.getSaldo() >= monto;
	}
}
