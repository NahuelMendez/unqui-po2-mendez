package ar.edu.unq.tp6;

public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Integer sueldoNetoMensual;
	private PropiedadInmobiliaria propiedad;
	private SolicitudDeCredito solicitudDeCredito;

	public Cliente(String nombre, String apellido, String direccion, int edad, int sueldoNetoMensual, PropiedadInmobiliaria propiedad) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.sueldoNetoMensual = sueldoNetoMensual;
		this.propiedad = propiedad;
		
	}

	public Integer calclarSueldoNetoAnual() {
		return this.sueldoNetoMensual * 12;
	}

	public PropiedadInmobiliaria getPropiedadInmobiliaria() {
		return this.propiedad;
	}

	public void crearSolicitud(SolicitudDeCredito solicitudDeCredito) {
		this.solicitudDeCredito = solicitudDeCredito;	
	}

}
