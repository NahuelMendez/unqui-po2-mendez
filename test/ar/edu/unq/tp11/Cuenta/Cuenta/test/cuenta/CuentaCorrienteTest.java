package ar.edu.unq.tp11.Cuenta.Cuenta.test.cuenta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta.CuentaCorriente;
import ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta.HistorialMovimientos;
import ar.edu.unq.tp11.Cuenta.Cuenta.src.cuenta.Notificador;

public class CuentaCorrienteTest {
	@Test
	public void testCajaAhorro() {
		HistorialMovimientos historialMovimientos = Mockito.mock(HistorialMovimientos.class);
		Notificador notificador = Mockito.mock(Notificador.class);
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(historialMovimientos, notificador, 100, 1);
		
		cuentaCorriente.extraer(90);
		assertEquals(10, cuentaCorriente.getSaldo());
		Mockito.verify(historialMovimientos).registrarMovimiento("Extracción", 90);
		
		cuentaCorriente.extraer(10);
		assertEquals(0, cuentaCorriente.getSaldo());
		Mockito.verify(historialMovimientos).registrarMovimiento("Extracción", 10);
		
		cuentaCorriente.extraer(1);
		assertEquals(-1, cuentaCorriente.getSaldo());
		Mockito.verify(historialMovimientos).registrarMovimiento("Extracción", 1);
		
		Mockito.verify(notificador, Mockito.times(3)).notificarNuevoSaldoACliente(cuentaCorriente);
	}
}
