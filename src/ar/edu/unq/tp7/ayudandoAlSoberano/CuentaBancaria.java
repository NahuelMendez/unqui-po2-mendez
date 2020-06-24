package ar.edu.unq.tp7.ayudandoAlSoberano;

import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {

	// Esta es la clase abstracta del patron
	
	private String titular;
	private int saldo;
	private List<String> movimientos;
	
	public CuentaBancaria(String titular) {
		this.titular = titular;
		this.saldo = 0;
		this.movimientos=new ArrayList<String>();
	}
	
	public String getTitular(){
		return this.titular;
	}

	public int getSaldo() {
		return this.saldo;
	}
	
	protected void setSaldo(int monto){
		this.saldo = monto;
	}
	
	public void agregarMovimientos(String movimiento) {
		this.movimientos.add(movimiento);
	}
	
	public void realizarExtraccion(Integer monto) {
		
		// realizarExtraccion es el Template method
		// cumpleRequisitosDeExtraccion es la operacion primitiva y se define de manera abstracta
		// extraer extrae de una manera estandar, si a caso alguna subclase quiere alterar su modo de extraccion este actuaria como hook method
		
		if (cumpleRequisitosDeExtraccion(monto)) {
			extraer(monto);
			registrarExtraccion();
		}
	}
	
	private void registrarExtraccion() {
		this.movimientos.add("Extraccion");
	}

	protected abstract Boolean cumpleRequisitosDeExtraccion(Integer monto);

	public void extraer(int monto) {
		this.saldo -= monto;
	}
	
}
