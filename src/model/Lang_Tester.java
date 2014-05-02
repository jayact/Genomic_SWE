package model;
import java.util.*;

public class Lang_Tester {

	static Language language;
	
	
	public static void main(String[] args) {
		language = new Language();
		Map<String,String> mapTest;
		mapTest = new HashMap<String,String>();
		
		mapTest.put("val1","Hello");
		mapTest.put("val2","Button");
		mapTest.put("val3","Desease");
		mapTest.put("val4","Danger");
		
		language.setLanguage(mapTest);
		
		language.findString("val1");

	}

}
