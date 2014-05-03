package tester;
import java.util.HashMap;
import model.Language;

public class Language_Tester {
	
	public static void main(String[] args) {
		Language english = new Language();
		
		HashMap<String,String> englDic = new HashMap<String,String>();
		englDic.put("button1", "OK");
		englDic.put("button2", "Cancel");
		
		System.out.println("------Map never imported------");
		System.out.println(english.findString("button1")+ "\n");
		
		System.out.println("------Map imported------");
		english.setLanguage(englDic);
		System.out.println(english.findString("button2"));
		
	}
}
