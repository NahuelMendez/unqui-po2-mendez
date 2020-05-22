package ar.edu.unq.tp8C;

import java.util.ArrayList;

public class RegionDeCultivo extends Cultivo {
	
	private ArrayList<Cultivo> cultivos;

	public RegionDeCultivo() {
		cultivos = new ArrayList<Cultivo>();
	}
	
	@Override
	public Integer gananciaAnual() {
		Integer resultado = 0;
		for (Cultivo cultivo : cultivos) {
			resultado += cultivo.gananciaAnual();
		}
		return resultado / 4;
	}
	
	public ArrayList<Cultivo> getCultivos(){
		return this.cultivos;
	}
	
	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
	}

}
