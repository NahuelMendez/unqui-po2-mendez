package ar.edu.unq.tp5.laCajaDelMercadoCentral;

public abstract class Producto implements Cobrable{

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
	
	public void cobrarseEnCaja(Caja caja) {
		if (this.getStock() > 0) {
			caja.agregarMontoACobrar(this.calcularCosto());
			this.reducirStock();
		}
	}
}
