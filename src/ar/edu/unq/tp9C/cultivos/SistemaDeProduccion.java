package ar.edu.unq.tp9C.cultivos;

import java.util.ArrayList;

public class SistemaDeProduccion {
	
	private ArrayList<ICultivo> tierrasProductivas;
	
	public SistemaDeProduccion() {
		tierrasProductivas = new ArrayList<ICultivo>();
	}
	
	public ArrayList<ICultivo> getTierrasProductivas(){
		return this.tierrasProductivas;
	}
	
	public Integer calcularGananciasDeTierrasProductivas() {
		Integer ganancias = 0;
		for (ICultivo cultivo : tierrasProductivas) {
			ganancias += cultivo.gananciaAnual();
		}
		return ganancias;
	}
	
	public void agregarCultivoAProduccion(ICultivo cultivo) {
		this.tierrasProductivas.add(cultivo);
	}

}
