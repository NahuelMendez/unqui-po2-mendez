package ar.edu.unq.tp9C.cultivos;

import java.util.ArrayList;

public class SistemaDeProduccion {
	
	private ArrayList<Cultivo> tierrasProductivas;
	
	public SistemaDeProduccion() {
		tierrasProductivas = new ArrayList<Cultivo>();
	}
	
	public ArrayList<Cultivo> getTierrasProductivas(){
		return this.tierrasProductivas;
	}
	
	public Integer calcularGananciasDeTierrasProductivas() {
		Integer ganancias = 0;
		for (Cultivo cultivo : tierrasProductivas) {
			ganancias += cultivo.gananciaAnual();
		}
		return ganancias;
	}
	
	public void agregarCultivoAProduccion(Cultivo cultivo) {
		this.tierrasProductivas.add(cultivo);
	}

}
