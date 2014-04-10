package model;
import java.util.*;

/**
 * @author Michael Arteaga
 */
public class Language {
	private Map<String,String> language;
	private Parser reader = new Parser();
	private String wantLanguage;
	
	public Language (){
		wantLanguage = "English";
	}
    
	public String findString(String label) {
		String phrase = "";
		if(!language.isEmpty()) {
			phrase = language.get(label);
		}
		return phrase;
	}
	
	public boolean setLanguage(Map<String, String> lang) {
		language = lang;
		return true;
	}
}
