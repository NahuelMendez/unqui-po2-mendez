package ar.edu.unq.tp10.Encriptador;

public class EncriptarPorVocales implements IEstrategiaDeEncriptacion{

	@Override
	public String encriptar(String word) {
		word = word.replace("u", "a").replace("o", "u")
				.replace("i", "o")
				.replace("e", "i").replace("a", "e");
		return word;
	}

}
