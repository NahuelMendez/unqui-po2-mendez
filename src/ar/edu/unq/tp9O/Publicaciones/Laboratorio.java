package ar.edu.unq.tp9O.Publicaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Laboratorio implements ISuscriptor{
	
	private List<String> notificaciones;
	private SistemaBibliografico sistema;
	
	public void cargarArticulo(Articulo articulo) {
		this.sistema.agregarArticulo(articulo);
	}

	public Laboratorio(SistemaBibliografico sistema) {
		this.sistema = sistema;
		this.notificaciones = new ArrayList<String>();
	}
	
	public void suscribirseAlSistema(Set<String> temaDeInteres) {
		this.sistema.agregarSuscriptor(this, temaDeInteres);
	}
	
	@Override
	public void update(String notificacion) {
		this.notificaciones.add(notificacion);
	}

	public List<String> getNotificacionesRecibidas() {
		return this.notificaciones;
	}
}
