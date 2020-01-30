package util;

public class FormatearString {
	public static String toView(String s){
		String resultado = s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
		resultado = resultado.replace("_", " ");
		return resultado;
	}
	public static String toDatabase(String s){
		String resultado = s.toUpperCase();
		resultado = resultado.replace(" ","_");
		return resultado;
	}
}
