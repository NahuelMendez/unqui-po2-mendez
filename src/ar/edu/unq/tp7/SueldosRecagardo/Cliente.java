package ar.edu.unq.tp7.SueldosRecagardo;

public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Integer sueldoNetoMensual;
	private PropiedadInmobiliaria propiedad;
	private SolicitudDeCredito solicitudDeCredito;
	private Integer creditoObtenido;

	public Cliente(String nombre, String apellido, String direccion, int edad, int sueldoNetoMensual, PropiedadInmobiliaria propiedad) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.sueldoNetoMensual = sueldoNetoMensual;
		this.propiedad = propiedad;
		this.creditoObtenido = 0;
		
	}

	public Integer calcularSueldoNetoAnual() {
		return this.sueldoNetoMensual * 12;
	}

	public PropiedadInmobiliaria getPropiedadInmobiliaria() {
		return this.propiedad;
	}

	public void crearSolicitud(SolicitudDeCredito solicitudDeCredito) {
		this.solicitudDeCredito = solicitudDeCredito;	
	}
	
	public Integer getSueldoNetoMensual() {
		return this.sueldoNetoMensual;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public SolicitudDeCredito getSolicitudDeCredito() {
		return this.solicitudDeCredito;
	}

	public Integer getCreditoObtenido() {
		return this.creditoObtenido;
	}

	public void setCreditoObtenido(Integer monto) {
		this.creditoObtenido = monto;
	}

}
