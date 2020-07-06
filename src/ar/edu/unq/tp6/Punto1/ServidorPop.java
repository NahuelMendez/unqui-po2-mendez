package ar.edu.unq.tp6.Punto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServidorPop implements IServidor, IPop {
	
	private Map<ClienteEMail, ArrayList<Correo>> usuariosRegistrados;

	public List<Correo> recibirNuevos(ClienteEMail usuario) {
		List<Correo> retorno = new ArrayList<Correo>();
	    if(elUsuarioEstaRegistrado(usuario)) {
	    	retorno = this.usuariosRegistrados.get(usuario);
	    }
		return retorno;
	}

	private Boolean elUsuarioEstaRegistrado(ClienteEMail usuario) {
		return this.usuariosRegistrados.keySet().contains(usuario);
	}

	public void conectar(ClienteEMail usuario) throws Exception {
		if (elUsuarioEstaRegistrado(usuario)) {
		   throw new Exception("El usuario es invalido");
		}
	}

	public void enviar(Correo correo) {
		// hace lo necesario para enviar el correo
	}

	@Override
	public float tazaDeTransferencia() {
		//no corresponde
		return 0;
	}

	@Override
	public void resetear() {
         //no corresponde		
	}

	@Override
	public void realizarBackUp() {
		//no corresponde
		
	}



}
