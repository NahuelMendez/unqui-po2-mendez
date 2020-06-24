package ar.edu.unq.tp7.ayudandoAlSoberano;

public class CuentaCorriente extends CuentaBancaria {
	
	// Cuenta corriente es una de las clases concretas del patron
	
	private int descubierto;
	
	public CuentaCorriente(String titular, int descubierto){
		super(titular);
		this.descubierto = descubierto;
	}
	
	public int getDescubierto(){
		return this.descubierto;
	}

	@Override
	// este metodo implementa la operacion primitiva
	protected Boolean cumpleRequisitosDeExtraccion(Integer monto) {
		return this.getSaldo() + this.getDescubierto() >= monto;
	}

}
