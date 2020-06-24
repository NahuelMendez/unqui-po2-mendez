package ar.edu.unq.tp7.LlamadasTelefonicas;

public class LLamadasDescuento extends LlamadaTelefonica{
	
	public LLamadasDescuento(int tiempo, int horaDelDia) {
		super(tiempo, horaDelDia);
	}
	
	@Override
	public Boolean esHoraPico() { //esta es la operacion concreta ya que esta redefiniendo el metodo abstracto que esta dentro del algoritmo
		return false;
	}
		
	@Override
	public float costoNeto() { // costoNeto probablemente sea el hook method, en la clase abstracta esta definido de una manera estandar que podria variar en cada subclase
		return this.getTiempo()*0.95f;
	}
}
