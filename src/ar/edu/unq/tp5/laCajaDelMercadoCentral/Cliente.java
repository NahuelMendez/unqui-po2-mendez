package ar.edu.unq.tp5.laCajaDelMercadoCentral;

import java.util.ArrayList;

public class Cliente {

	private ArrayList<Cobrable> cobrables;
	private Integer saldoAPagar;
	
	public Cliente() {
		this.cobrables = new ArrayList<Cobrable>();
		this.saldoAPagar = 0;
	}

	public ArrayList<Cobrable> getCobrables() {
		return this.cobrables;
	}

	public void agregarCobrable(Cobrable cobrable) {
		this.cobrables.add(cobrable);
	}

	public Integer getSaldoAPagar() {
		return this.saldoAPagar;
	}

	public void setSaldoAPagar(Integer montoAPagar) {
		this.saldoAPagar = montoAPagar;
	}

}
