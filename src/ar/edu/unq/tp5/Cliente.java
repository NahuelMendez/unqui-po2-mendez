package ar.edu.unq.tp5;

import java.util.ArrayList;

public class Cliente {

	private ArrayList<Producto> productos;
	
	public Cliente() {
		this.productos = new ArrayList<Producto>();
	}

	public ArrayList<Producto> getProductos() {
		return this.productos;
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

}
