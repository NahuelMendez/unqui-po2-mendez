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
		
		abecedarioNumerico.put("26", "z");
		abecedarioNumerico.put("25", "y");
		abecedarioNumerico.put("24", "x");
		abecedarioNumerico.put("23", "w");
		abecedarioNumerico.put("22", "v");
		abecedarioNumerico.put("21", "u");
		abecedarioNumerico.put("20", "t");
		abecedarioNumerico.put("19", "s");
		abecedarioNumerico.put("18", "r");
		abecedarioNumerico.put("17", "q");
		abecedarioNumerico.put("16", "p");
		abecedarioNumerico.put("15", "o");
		abecedarioNumerico.put("14", "n");
		abecedarioNumerico.put("13", "m");
		abecedarioNumerico.put("12", "l");
		abecedarioNumerico.put("11", "k");
		abecedarioNumerico.put("10", "j");
		abecedarioNumerico.put("9", "i");
		abecedarioNumerico.put("8", "h");
		abecedarioNumerico.put("7", "g");
		abecedarioNumerico.put("6", "f");
		abecedarioNumerico.put("5", "e");
		abecedarioNumerico.put("4", "d");
		abecedarioNumerico.put("3", "c");
		abecedarioNumerico.put("2", "b");
		abecedarioNumerico.put("1", "a");
		abecedarioNumerico.put("0", " ");
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

	@Override
	public String desencriptar(String word) {
		String[] keys = word.split(",");
		String palabraDesencriptada = "";
		for (String string : keys) {
			palabraDesencriptada += this.abecedarioNumerico.get(string);
		}
		palabraDesencriptada = palabraDesencriptada.substring(0, 1).toUpperCase() + palabraDesencriptada.substring(1);
		return palabraDesencriptada;
	}

}
