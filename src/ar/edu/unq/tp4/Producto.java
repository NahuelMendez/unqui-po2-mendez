package ar.edu.unq.tp4;

import java.util.function.BooleanSupplier;

public class Producto {
	
	private String nombre;
	private double precio;
	private boolean precioCuidado;

	public Producto(String nombre, double precio, boolean precioCuidado) {
		this.nombre = nombre;
		this.precio = precio;
		this.precioCuidado = precioCuidado;
	}

	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.precioCuidado = false;
	}

	public Object getNombre() {
		return this.nombre;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public Boolean esPrecioCuidado() {
		return this.precioCuidado;
	}

	public void aumentarPrecio(double aumento) {
		this.precio += aumento;
	}

}
