package ar.edu.unq.tp6.bancoYPrestamos;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Cliente> clientes;
	private List<SolicitudDeCredito> solicitudesPendientes;
	private List<SolicitudDeCredito> solicitudesDeCreditoAprobadas;
	
	public Banco() {
		this.clientes = new ArrayList<Cliente>();
		this.solicitudesPendientes = new ArrayList<SolicitudDeCredito>();
		this.solicitudesDeCreditoAprobadas = new ArrayList<SolicitudDeCredito>();
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public List<SolicitudDeCredito> getSolicitudesPendientes() {
		return this.solicitudesPendientes;
	}

	public void registrarSolicitudDeCredito(SolicitudDeCredito solicitudDeCredito) {
		this.solicitudesPendientes.add(solicitudDeCredito);
	}

	public void evaluarSoliticudDeCredito(SolicitudDeCredito solicitudDeCredito) {
		if (solicitudDeCredito.chequearAprobacion()) {
			this.otorgarCreditoACliente(solicitudDeCredito.getCliente());
			this.solicitudesDeCreditoAprobadas.add(solicitudDeCredito);
		} 
	}

	private void otorgarCreditoACliente(Cliente cliente) {
		cliente.setCreditoObtenido(cliente.getSolicitudDeCredito().getMonto());
	}

	public void registrarSolicitudes() {
		for (int i = 0; i < clientes.size(); i++) {
			registrarSolicitudDeCredito(clientes.get(i).getSolicitudDeCredito());
		}
	}

	public void evaluarSolicitudesPendientes() {
		for (int i = 0; i < clientes.size(); i++) {
			evaluarSoliticudDeCredito(clientes.get(i).getSolicitudDeCredito());
		}
		
	}

	public Integer getMontoTotalADesembolsar() {
		return this.solicitudesDeCreditoAprobadas
				.stream()
				.mapToInt(SolicitudDeCredito::getMonto)
				.sum();	
	}

}
