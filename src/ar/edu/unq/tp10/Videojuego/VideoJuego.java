package ar.edu.unq.tp10.Videojuego;

public class VideoJuego {

	private Integer fichas;
	private IEstadoDeJuego estadoActual;
	
	public VideoJuego() {
		this.fichas = 0;
		this.estadoActual = new EstadoSinFichas();
	}
	
	public Integer getFichas() {
		return this.fichas;
	}

	public void agregarFicha() {
		this.fichas++;
		if(this.getFichas() == 1) {
			this.setEstadoDeJuego(new EstadoParaUnJugador());
		} else if (this.getFichas() >= 2) {
			this.setEstadoDeJuego(new EstadoParaDosJugadores());
		}
	}

	private void setEstadoDeJuego(IEstadoDeJuego estadoDeJuego) {
		this.estadoActual = estadoDeJuego;
		
	}

	public String iniciar() {
		return this.estadoActual.iniciar(this);
	}
	
	public void gastarFicha() {
		this.fichas--;
	}

}
