package ar.edu.unq.tp5;

public abstract class Producto {

	private Integer precio;
	private Integer stock;
	
	public abstract Integer calcularCosto();
	
	public Producto(Integer precio, Integer stock) {
		this.precio = precio;
		this.stock = stock;
	}
	
	public Integer getPrecio() {
		return this.precio;
	}
	
	public Integer getStock() {
		return this.stock;
	}
	
	public void reducirStock() {
		this.stock--;
	}
}
