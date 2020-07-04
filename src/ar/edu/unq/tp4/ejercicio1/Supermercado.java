package ar.edu.unq.tp4.ejercicio1;

import java.util.ArrayList;

public class Supermercado {

	private String nombre;
	private String direccion;
	private ArrayList<Producto> productos;

	public Supermercado(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
	}

	public Integer getCantidadDeProductos() {
		return this.productos.size();
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public Double getPrecioTotal() {
		Double precioTotal = 0d;
		for (Producto producto: productos) {
			precioTotal += producto.getPrecio();
		}
		return precioTotal;
	}

}
