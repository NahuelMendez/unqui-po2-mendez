package ar.edu.unq.tp6.bancoYPrestamos;

public class PropiedadInmobiliaria {
	
	private String descripcion;
	private String direccion;
	private Integer valorFiscal;
	
	public PropiedadInmobiliaria(String descripcion, String direccion, Integer valorFiscal) {
		
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.valorFiscal = valorFiscal;
		
	}

	public Integer getValorFiscal() {
		return valorFiscal;
	}
	
}
