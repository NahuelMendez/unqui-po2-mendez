package ar.edu.unq.tp5;

public class Caja {
	
	private Integer montoACobrar;
	
	public Caja() {
		this.montoACobrar = 0;
	}

	public Integer getMontoACobrar() {
		return montoACobrar;
	}

	public void cobrarACliente(Cliente cliente) {
		for (int i = 0; i < cliente.getProductos().size(); i++) {
			this.registrarProducto(cliente.getProductos().get(i));
		}
	}

	private void registrarProducto(Producto producto) {
		this.montoACobrar += producto.calcularCosto();
		producto.reducirStock();
	}

}
