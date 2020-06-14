package ar.edu.unq.tp9.Encriptador;

public class DesencriptarPorVocales implements IEstrategiaDeDesencriptacion{

	@Override
	public String desencriptar(String word) {
		word = word.replace("e", "a").replace("i", "e")
				.replace("o", "i")
				.replace("u", "o").replace("u", "a");
		return word;
	}

}
