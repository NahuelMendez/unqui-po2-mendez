package ar.edu.unq.tp7.SueldosRecagardo;

import java.util.ArrayList;

public class Banco {
	
	private ArrayList<Cliente> clientes;
	private ArrayList<SolicitudDeCredito> solicitudesPendientes;
	
	public Banco() {
		this.clientes = new ArrayList<Cliente>();
		this.solicitudesPendientes = new ArrayList<SolicitudDeCredito>();
	}

	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}

	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public ArrayList<SolicitudDeCredito> getSolicitudesPendientes() {
		return this.solicitudesPendientes;
	}

	public void registrarSolicitudDeCredito(SolicitudDeCredito solicitudDeCredito) {
		this.solicitudesPendientes.add(solicitudDeCredito);
	}

	public void evaluarSoliticudDeCredito(SolicitudDeCredito solicitudDeCredito) {
		if (solicitudDeCredito.chequearAprobacion()) {
			this.otorgarCreditoACliente(solicitudDeCredito.getCliente());
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

	

}
