package ar.edu.unq.tp7.LlamadasTelefonicas;

public abstract class LlamadaTelefonica {

	private int tiempo;
	private int horaDelDia;
	
	public LlamadaTelefonica(int tiempo, int horaDelDia){
		this.tiempo=tiempo;
		this.horaDelDia=horaDelDia;
	}
	
	public Integer getTiempo(){
		return this.tiempo;
	}
	public Integer getHoraDelDia(){
		return this.horaDelDia;
	}
	
	public abstract Boolean esHoraPico();

	public float costoFinal(){ //costo final es el template method ya que define el esqueleto del algoritmo y esta en la clase abstracta
		if(this.esHoraPico()){ // esHoraPico es la primitiva que debe redefinir cada subclase que herede de LlamadaTelefonica
			return this.costoNeto()*1.2f*this.getTiempo();
		} else {
			return this.costoNeto()*this.getTiempo();
		}
	}
	
	public float costoNeto(){
		return this.getTiempo()*1;
	}
	
}
	

