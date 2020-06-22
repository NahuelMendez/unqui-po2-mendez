package ar.edu.unq.tp10.Encriptador;

import java.util.HashMap;
import java.util.Map;

public class EncriptarConNumeros implements IEstrategiaDeEncriptacion{
	
	private Map<String, String> abecedarioNumerico;
	
	public EncriptarConNumeros() {
		this.abecedarioNumerico = new HashMap<String, String>();
		abecedarioNumerico.put(" ", "0");
		abecedarioNumerico.put("a", "1");
		abecedarioNumerico.put("b", "2");
		abecedarioNumerico.put("c", "3");
		abecedarioNumerico.put("d", "4");
		abecedarioNumerico.put("e", "5");
		abecedarioNumerico.put("f", "6");
		abecedarioNumerico.put("g", "7");
		abecedarioNumerico.put("h", "8");
		abecedarioNumerico.put("i", "9");
		abecedarioNumerico.put("j", "10");
		abecedarioNumerico.put("k", "11");
		abecedarioNumerico.put("l", "12");
		abecedarioNumerico.put("m", "13");
		abecedarioNumerico.put("n", "14");
		abecedarioNumerico.put("o", "15");
		abecedarioNumerico.put("p", "16");
		abecedarioNumerico.put("q", "17");
		abecedarioNumerico.put("r", "18");
		abecedarioNumerico.put("s", "19");
		abecedarioNumerico.put("t", "20");
		abecedarioNumerico.put("u", "21");
		abecedarioNumerico.put("v", "22");
		abecedarioNumerico.put("w", "23");
		abecedarioNumerico.put("x", "24");
		abecedarioNumerico.put("y", "25");
		abecedarioNumerico.put("z", "26");
	}

	@Override
	public String encriptar(String word) {
		char[] charArray = word.toCharArray();
		String wordEncriptada = "";
		for (char c : charArray) {
			wordEncriptada += this.abecedarioNumerico.get(Character.toString(c).toLowerCase()) + ",";
		}
		return wordEncriptada.substring(0, wordEncriptada.length() -1);
	}

}
