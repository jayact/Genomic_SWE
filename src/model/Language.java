package model;
import java.util.*;

/**
 * @author Michael Arteaga
 */
public class Language {
	private Map<String,String> language;
	private String usingLanguage;
	
	public Language (String usingLanguage){
		this.usingLanguage = usingLanguage;
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
