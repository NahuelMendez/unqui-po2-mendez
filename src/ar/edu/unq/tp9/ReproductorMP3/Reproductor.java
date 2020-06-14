package ar.edu.unq.tp9.ReproductorMP3;

public class Reproductor {
	
	private IEstadosDeReproductor estadoActual;
	private Song cancionEnReproduccion;
	
	public Reproductor() {
		this.estadoActual = new EstadoEnSeleccion();
	}
	
	public void agregarAReproduccion(Song song) {
		this.cancionEnReproduccion = song;
	}
	
	public Song getCancionEnReproduccion() {
		return this.cancionEnReproduccion;
	}
	
	public void play() throws Exception {
		this.estadoActual.play(this);
	}
	
	public void pause() throws Exception {
		this.estadoActual.pause(this);
	}

	public void setEstado(IEstadosDeReproductor estado) {
		this.estadoActual = estado;
	}

	public Boolean enReproduccion() {
		return this.estadoActual.enReproduccion();
	}

	public void stop() {
		this.estadoActual.stop(this);
	}

	public void quitarCancionEnReproduccion() {
		this.cancionEnReproduccion = null;
	}

}
