package ar.edu.unq.tp11.Cuenta.Cuenta.test.cuenta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta.CajaAhorro;
import ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta.HistorialMovimientos;
import ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta.Notificador;

public class CajaAhorroTest {
	
	@Test
	public void testCajaAhorro() {
		HistorialMovimientos historialMovimientos = Mockito.mock(HistorialMovimientos.class);
		Notificador notificador = Mockito.mock(Notificador.class);
		
		CajaAhorro cajaAhorro = new CajaAhorro(historialMovimientos, notificador, 100);
		
		cajaAhorro.extraer(90);
		assertEquals(10, cajaAhorro.getSaldo());
		Mockito.verify(historialMovimientos).registrarMovimiento("Extracción", 90);
		
		cajaAhorro.extraer(10);
		assertEquals(0, cajaAhorro.getSaldo());
		Mockito.verify(historialMovimientos).registrarMovimiento("Extracción", 10);
		
		cajaAhorro.extraer(1);
		assertEquals(0, cajaAhorro.getSaldo());
		Mockito.verify(historialMovimientos, Mockito.never()).registrarMovimiento("Extracción", 1);
		
		Mockito.verify(notificador, Mockito.times(2)).notificarNuevoSaldoACliente(cajaAhorro);
	}
}
