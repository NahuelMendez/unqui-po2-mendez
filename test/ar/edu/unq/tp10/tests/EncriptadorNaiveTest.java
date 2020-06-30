package ar.edu.unq.tp10.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.tp10.Encriptador.DesencriptarConNumeros;
import ar.edu.unq.tp10.Encriptador.DesencriptarPorVocales;
import ar.edu.unq.tp10.Encriptador.EncriptadorNaive;
import ar.edu.unq.tp10.Encriptador.EncriptarConNumeros;
import ar.edu.unq.tp10.Encriptador.EncriptarPorVocales;
import ar.edu.unq.tp10.Encriptador.IEstrategiaDeDesencriptacion;

class EncriptadorNaiveTest {
	
	private EncriptadorNaive encriptador;
	private EncriptarPorVocales estrategiaEVocales;
	private DesencriptarPorVocales estrategiaDVocales;
	private EncriptarConNumeros estrategiaENumerico;
	private IEstrategiaDeDesencriptacion estrategiaDNumerico;
	
	@BeforeEach
	public void setUp() {
		estrategiaEVocales = new EncriptarPorVocales();
		estrategiaDVocales = new DesencriptarPorVocales();
		estrategiaENumerico = new EncriptarConNumeros();
		estrategiaDNumerico = new DesencriptarConNumeros();
		encriptador = new EncriptadorNaive(estrategiaEVocales, estrategiaDVocales);
	}

	@Test
	void test_UnEncriptadorAlRecibirLaPalabra_Hola_LaEncriptaComo_Hule_() {
		String result = encriptador.encriptar("Hola");
		assertEquals("Hule", result);
	}
	
	@Test
	void test_UnEncriptadorAlRecibirLaPalabra_Sol_LaEncriptaComo_Sul_() {
		String result = encriptador.encriptar("Sol");
		assertEquals("Sul", result);
	}
	
	@Test
	void test_UnEncriptadorAlRecibirLaPalabraEncriptada_Solle_LaDesencriptaComo_Silla_() {
		String result = encriptador.desencriptar("Solle");
		assertEquals("Silla", result);
	}
	
	@Test
	void test_UnEncriptadorCambiaDeEstrategiaYAlRecibirLaPalabra_Hola_LaEncriptaComo_8_15_12_1(){
		encriptador.setEstrategiaDeEncriptacion(estrategiaENumerico);
		String result = encriptador.encriptar("Hola");
		assertEquals("8,15,12,1", result);
	}
	
	@Test
	void test_UnEncriptadorCambiaDeEstrategiaYAlRecibirLaPalabra_Sol_Retorna_19_15_12() {
		encriptador.setEstrategiaDeEncriptacion(estrategiaENumerico);
		String result = encriptador.encriptar("Sol");
		assertEquals("19,15,12", result);
	}
	
	@Test
	void test_UnEncriptadorCambiaDeEstrategiaYAlRecibir_2_21_5_14_0_4_9_1_DesencriptaComo_Buen_Dia() {
		encriptador.setEstrategiaDeDesencriptacion(estrategiaDNumerico);
		String result = encriptador.desencriptar("2,21,5,14,0,4,9,1");
		assertEquals("Buen Dia", result);
	}

	@Test
	void test_UnEncriptadorCambiaDeEstrategiaYAlRecibir_3_1_2_12_5_DesencriptaComo_Cable_() {
		encriptador.setEstrategiaDeDesencriptacion(estrategiaDNumerico);
		String result = encriptador.desencriptar("3,1,2,12,5");
		assertEquals("Cable", result);
	}
}
