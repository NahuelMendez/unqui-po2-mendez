package ar.edu.unq.tp11.Registro.Registro.src.automotor;

import java.time.LocalDate;

public class RegistroAutomotor {

	public Boolean debeRealizarVtv(Vehiculo vehiculo, LocalDate fecha) {
		Boolean esVehiculoPolicial = vehiculo.esVehiculoPolicial();
		Boolean cumpleCondiciones = vehiculo.puedeAplicarParaVtv(fecha);
		return (!esVehiculoPolicial && cumpleCondiciones);
	}
	
}
