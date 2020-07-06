package ar.edu.unq.tp3.ejercicio1;

import java.util.ArrayList;

public class Counter {

	private ArrayList<Integer> numeros;
	
	public Counter() {
		numeros = new ArrayList<Integer>();
	}
	
	public void agregarNumero(Integer num) {
		this.numeros.add(num);
	}

	public Integer getNumerosPares() {
		Integer cantidad = 0;
		for (Integer numero : numeros) {
			cantidad = cantidad + unoSiEsPar(numero);
		}
		return cantidad;
	}
	
	private Integer unoSiEsPar(Integer num) {
		if (num % 2 == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public Integer getNumerosImpares() {
		Integer numImpares;
		numImpares = this.numeros.size() - getNumerosPares();
		return numImpares;
	}

	public Integer getMultiplosDe(Integer num) {
		Integer cantidad = 0;
		for (Integer numero : numeros) {
			cantidad = cantidad + unoSiSonMultiplos(numero, num);
		}
		return cantidad;
	}

	private Integer unoSiSonMultiplos(Integer numero, Integer num) {
		if (numero % num == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
