package ar.edu.unq.tp6.Punto1;

import java.util.List;

public interface IPop {

	public List<Correo> recibirNuevos(ClienteEMail usuario);

	public void conectar(ClienteEMail usuario) throws Exception;

	public void enviar(Correo correo);
	
}
