package model;
import java.util.Map;

public class Lang_Tester {

	static Language language;
	static Map<String,String> mapTest;
	public static void main(String[] args) {
		language = new Language();
		
		mapTest.put("val1","Hello");
		mapTest.put("val2","Button");
		mapTest.put("val3","Desease");
		mapTest.put("val4","Danger");
		
		language.setLanguage(mapTest);
		
		language.findString("val1");

	}

}
