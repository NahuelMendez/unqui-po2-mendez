package ar.edu.unq.tp11.Registro.Registro.src.automotor;

import java.time.LocalDate;

public class Vehiculo {
	private Boolean esVehiculoPolicial;
	private LocalDate fechaFabricacion;	
	private String ciudadRadicacion; 
	
	public Vehiculo(Boolean esVehiculoPolicial, LocalDate fechaFabricacion, String ciudadRadicacion) {
		this.esVehiculoPolicial = esVehiculoPolicial;
		this.fechaFabricacion = fechaFabricacion;
		this.ciudadRadicacion = ciudadRadicacion;
	}

	public Boolean esVehiculoPolicial() {
		return esVehiculoPolicial;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public String getCiudadRadicacion() {
		return ciudadRadicacion;
	}
	
	public Boolean puedeAplicarParaVtv(LocalDate fecha) {
		return this.tieneAntiguedadMayorAUnAño(fecha) &&
				this.elVehiculoEsDeBuenosAires();
	}
	
	private Boolean tieneAntiguedadMayorAUnAño(LocalDate fecha) {
		return fecha.minusYears(1).isAfter(this.getFechaFabricacion());
	}
	
	private Boolean elVehiculoEsDeBuenosAires() {
		return this.getCiudadRadicacion().equalsIgnoreCase("Buenos Aires");
	}
}


