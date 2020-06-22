package ar.edu.unq.tp9O.EncuentrosDeportivos;

import java.util.List;
import java.util.Set;

public class Partido {
	
	private String resultado;
	private List<String> nombresDeContrincantes;
	private String deporte;
	
	public Partido(String resultado, List<String> nombresDeContrincantes, String deporte) {
		super();
		this.resultado = resultado;
		this.nombresDeContrincantes = nombresDeContrincantes;
		this.deporte = deporte;
	}

	public List<String> getListaDeContrincantes() {
		return this.nombresDeContrincantes;
	}
	
	public String getDeporte() {
		return this.deporte;
	}
	
	private String getResultado() {
		return this.resultado;
	}

}
