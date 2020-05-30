package ar.edu.unq.tp8C;

import java.util.ArrayList;
import java.util.List;

public class RegionDeCultivo extends Cultivo {
	
	private List<Cultivo> cultivos;

	public RegionDeCultivo() {
		cultivos = new ArrayList<Cultivo>(4);
	}
	
	@Override
	public Integer gananciaAnual() {
		Integer resultado = 0;
		for (Cultivo cultivo : cultivos) {
			resultado += cultivo.gananciaAnual();
		}
		return resultado / 4;
	}
	
	public List<Cultivo> getCultivos(){
		return this.cultivos;
	}
	
	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
	}

}
