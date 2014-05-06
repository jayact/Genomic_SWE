package tester;

import java.util.Map;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import model.Parser;

/**
 *
 * @author Chris Meyers
 */
public class Parser_Tester {
    public static void main(String[] args) throws IOException, WriteException, BiffException{
        Parser p = new Parser();

        Map<String, String> langMap = p.readLanguage("english");
        
        String testKey1 = "label1";
        String testKey2 = "label9000";
        String testKey3 = "label15";
        String testValue1 = "Wild";
        
        if(langMap.containsKey(testKey1)){
            System.out.println(testKey1 + " key exists : PASSED");
        }
        else{
            System.out.println(testKey1 + " key does not exist : FAILED");
        }
        
        if(langMap.containsKey(testKey2)){
            System.out.println(testKey2 + " key exists : FAILED");
        }
        else{
            System.out.println(testKey2 + " key does not exist : PASSED");
        }
        
        if(langMap.containsKey(testKey3)){
            System.out.println(testKey3 + " key exists : PASSED");
        }
        else{
            System.out.println(testKey3 + " key does not exist : FAILED");
        }
        
        if(langMap.values().contains(testValue1)){
            System.out.println("Value " + testValue1 + " Exists : PASSED");
        }
        else{
            System.out.println("Value " + testValue1 + " SHOULD exist : FAILED");
        }
        
        if(langMap.size() == 15){
            System.out.println("All entries are stored : PASSED");
        }
        else{
            System.out.println("There are missing entries : FAILED");
        }

    }
}
