package model;
import java.util.*;

/**
 * This class contains the language the user desires. It maintains a Map using English
 * as the key and the desired language phrase as the value.
 * @author Michael Arteaga
 */
public class Language {
	private Map<String,String> language;
	
	/**
	 * Constructor
	 */
	public Language (){
		language = new HashMap<String, String>();
	}
    
	/**
	 * Loops through the Map with the given label to find and return the phrase
	 * associated with the label.
	 * @param label- key for the Map
	 * @return phrase- The value the key was referring to.
	 */
	public String findString(String label) {
		String phrase = "";
		if(!language.isEmpty()) {
			phrase = language.get(label);
		}
		return phrase = label + "could not be found.";
	}
	
	/**
	 * Takes in the Map from Main and stores it in this class.
	 * @param lang- Map given by Main
	 * @return true if the Map was successfully put in this class.
	 */
	public boolean setLanguage(Map<String, String> lang) {
		if (lang == null) {
			return false;
		}
		language = lang;
		return true;
	}
	
}
