package ar.edu.unq.tp9.ReproductorMP3;

public class EstadoEnSeleccion implements IEstadosDeReproductor {

	@Override
	public void play(Reproductor reproductor) {
		reproductor.getCancionEnReproduccion().play();
		reproductor.setEstado(new EstadoEnReproduccion());
	}

	@Override
	public void pause(Reproductor reproductor) throws Exception {
		throw new Exception("No hay ninguna cancion reproduciendose");
	}

	@Override
	public void stop(Reproductor reproductor) {
		// no hace nada
	}

	@Override
	public Boolean enReproduccion() {
		return false;
	}

}
