package ar.edu.unq.tp4;

public class ProductoPrimeraNecesidad extends Producto{
	
	private Double porcentajeDescuento;
	
	public ProductoPrimeraNecesidad(String nombre, double precio, boolean precioCuidado, Double descuento) {
		super(nombre, precio, precioCuidado);
		this.porcentajeDescuento = descuento;
	}

	public Double getPrecio() {
		Double descuento = super.getPrecio() * porcentajeDescuento / 100;
		return super.getPrecio() - descuento;
	}

}
