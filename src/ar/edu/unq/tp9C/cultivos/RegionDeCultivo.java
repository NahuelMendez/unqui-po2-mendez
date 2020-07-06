package ar.edu.unq.tp9C.cultivos;

import java.util.ArrayList;
import java.util.List;

public class RegionDeCultivo implements ICultivo {
	
	private List<ICultivo> cultivos;

	public RegionDeCultivo() {
		cultivos = new ArrayList<ICultivo>(4);
	}
	
	@Override
	public Integer gananciaAnual() {
		Integer resultado = 0;
		for (ICultivo cultivo : cultivos) {
			resultado += cultivo.gananciaAnual();
		}
		return resultado / 4;
	}
	
	public List<ICultivo> getCultivos(){
		return this.cultivos;
	}
	
	public void agregarCultivo(ICultivo cultivo) {
		this.cultivos.add(cultivo);
	}

}
