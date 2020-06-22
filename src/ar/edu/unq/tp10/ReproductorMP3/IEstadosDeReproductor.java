package ar.edu.unq.tp10.ReproductorMP3;

public interface IEstadosDeReproductor {
	
	public void play(Reproductor reproductor) throws Exception;
	
	public void pause(Reproductor reproductor) throws Exception;
	
	public void stop(Reproductor reproductor);

	public Boolean enReproduccion();

}
