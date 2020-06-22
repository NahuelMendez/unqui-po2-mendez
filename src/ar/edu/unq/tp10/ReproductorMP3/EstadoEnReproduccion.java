package ar.edu.unq.tp10.ReproductorMP3;

public class EstadoEnReproduccion implements IEstadosDeReproductor{

	@Override
	public void play(Reproductor reproductor) throws Exception {
		throw new Exception("El reproductor ya esta reproduciendo");
	}

	@Override
	public void pause(Reproductor reproductor) {
		reproductor.getCancionEnReproduccion().pause();
		reproductor.setEstado(new EstadoEnPausa());
	}

	@Override
	public void stop(Reproductor reproductor) {
		reproductor.getCancionEnReproduccion().stop();
		reproductor.setEstado(new EstadoEnSeleccion());
		reproductor.quitarCancionEnReproduccion();
	}

	@Override
	public Boolean enReproduccion() {
		return true;
	}

}
