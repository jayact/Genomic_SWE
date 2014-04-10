package model;
import java.util.*;

/**
 * @author Michael Arteaga
 */
public class Language {
	private Map<String,String> language;
	private Parser reader = new Parser();
	
	public Language (){
		
	}
    
	public String findString(String label) {
		return "";
	}
	
	public boolean setLanguage(Map<String, String> lang) {
		language = lang;
		return true;
	}
}
