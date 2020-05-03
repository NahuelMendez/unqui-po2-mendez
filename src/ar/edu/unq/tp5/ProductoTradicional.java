package ar.edu.unq.tp5;

public class ProductoTradicional extends Producto {

	public ProductoTradicional(Integer precio, Integer stock) {
		super(precio, stock);
		
	}

	@Override
	public Integer calcularCosto() {
		return super.getPrecio();
	}

}
