package ar.edu.unq.tp3;

import java.util.ArrayList;

public class Multioperador {
	
	private ArrayList<Integer> enteros = new ArrayList<Integer>();
	
	public Integer sumarNumeros() {
		
		Integer resultado = 0;
		for (int i = 0; i < this.getEnteros().size(); i++) {
			resultado += this.getEnteros().get(i);
		}
		return resultado;
	}
	
	public Integer restarNumeros() {
		Integer resultado = 0;
		for (int i = 0; i < this.getEnteros().size(); i++) {
			resultado -= this.getEnteros().get(i);
		}
		return resultado;
	}
	
	public Integer multiplicarNumeros() {
		Integer resultado = 1;
		for (Integer numero: this.getEnteros()) {
			resultado *= numero;
		}
		return resultado;
	}
	
	public void agregarNumero(Integer num) {
		this.getEnteros().add(num);
	}

	public ArrayList<Integer> getEnteros() {
		return enteros;
	}
	
}
