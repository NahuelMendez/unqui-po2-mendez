package ar.edu.unq.tp5;

public class ProductoCooperativa extends Producto{

	public ProductoCooperativa(Integer precio, Integer stock) {
		super(precio, stock);
	}

	public Integer calcularCosto() {
		Integer precio;
		precio = super.getPrecio() - descuentoIVA();
		return precio;
	}

	private Integer descuentoIVA() {
		return super.getPrecio() * 10 / 100;
	}

}
