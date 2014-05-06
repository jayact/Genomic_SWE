package tester;

import java.util.Map;
import java.util.Set;

import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import model.Disease;
import model.Gene;
import model.Parser;

/**
 *
 * @author Chris Meyers
 */
public class Parser_Tester {
    public static void main(String[] args) throws IOException, WriteException, BiffException{
        Parser p = new Parser();
        
        // Language Map Tests
        System.out.println("========LANGUAGE TESTS========");
        Map<String, String> langMap = p.readLanguage("english");
        
        String testLangKey1 = "label1";
        String testLangKey2 = "label9000"; //incorrect
        String testLangKey3 = "label15";
        String testLangValue1 = "Wild";
        
        Set<String> langKeys = langMap.keySet();
        System.out.println("There are " + langKeys.size() + " keys.");
        for(String key : langKeys){
            System.out.println(key);
        }
        
        //Lang Test 1
        if(langMap.containsKey(testLangKey1)){
            System.out.println(testLangKey1 + " key exists : PASSED");
        }
        else{
            System.out.println(testLangKey1 + " key does not exist : FAILED");
        }
        
        //Lang Test 2 - SHOULD FAIL
        if(langMap.containsKey(testLangKey2)){
            System.out.println(testLangKey2 + " key exists : PASSED");
        }
        else{
            System.out.println(testLangKey2 + " key does not exist : FAILED");
        }
        
        //Lang Test 3
        if(langMap.containsKey(testLangKey3)){
            System.out.println(testLangKey3 + " key exists : PASSED");
        }
        else{
            System.out.println(testLangKey3 + " key does not exist : FAILED");
        }
        
        //Lang Test 4
        if(langMap.values().contains(testLangValue1)){
            System.out.println("Value " + testLangValue1 + " Exists : PASSED");
        }
        else{
            System.out.println("Value " + testLangValue1 + " SHOULD exist : FAILED");
        }
        
        //Lang Test 5
        if(langMap.size() == 15){
            System.out.println("All entries are stored : PASSED");
        }
        else{
            System.out.println("There are missing entries : FAILED");
        }
        
        //Gene Map Tests
        //BCMO1, CETP, CFH, DRD2 have repeats in gene.xls
        
        System.out.println("========GENE TESTS========");
        Map<String, Gene> geneMap = p.readGene();
        
        Gene testGeneValue1 = new Gene("WFS1", "10010131");
        Gene testGeneValue2 = new Gene("WFS1", "99999999"); //incorrect
        
        Set<String> geneKeys = geneMap.keySet();
        System.out.println("There are " + geneKeys.size() + " keys.");
        for(String gene : geneKeys){
            System.out.println(gene);
        }
        
        //Gene Test 1
        if(testGeneValue1.getName().equals(geneMap.get(testGeneValue1.getName()).getName()) && 
                testGeneValue1.getRSNumber().equals(geneMap.get(testGeneValue1.getName()).getRSNumber())){
            
            System.out.println(testGeneValue1.getName() + " is mapped to the correct value, " + 
                    geneMap.get(testGeneValue1.getName()).getRSNumber() + " : PASSED");
            
        }
        else{
            System.out.println(testGeneValue1.getName() + " is mapped to the incorrect value, " + 
                    geneMap.get(testGeneValue1.getName()).getRSNumber() +
                    ". It should be " + testGeneValue1.getRSNumber() + " : FAILED");
        }
        
        //Gene Test 2 - SHOULD FAIL
        if(testGeneValue2.getName().equals(geneMap.get(testGeneValue2.getName()).getName()) && 
                testGeneValue2.getRSNumber().equals(geneMap.get(testGeneValue2.getName()).getRSNumber())){
            
            System.out.println(testGeneValue2.getName() + " is mapped to the correct value, " + 
                    geneMap.get(testGeneValue2.getName()).getRSNumber() + " : PASSED");
            
        }
        else{
            System.out.println(testGeneValue2.getName() + " is mapped to the incorrect value, " + 
                    testGeneValue2.getRSNumber() +
                    ". It should be " + geneMap.get(testGeneValue2.getName()).getRSNumber() + " : FAILED");
        }
        
        //Disease Map Tests
        //Need to fix repeated diseases in diseaseDatabase2.xls
        
        System.out.println("========DISEASE TESTS========");
        Map<String, Disease> diseaseMap = p.readDisease();
        
        Gene testGeneList1 = new Gene("VDR-1", "Homozygous", "154410");
        Gene testGeneList2 = new Gene("VDR-1", "Heterozygous", "154410");
        ArrayList<Gene> subArray = new ArrayList<Gene>();
        subArray.add(testGeneList1);
        subArray.add(testGeneList2);
        ArrayList<ArrayList<Gene>> finalArray = new ArrayList<ArrayList<Gene>>();
        finalArray.add(subArray);
        
        //DiseaseMap: Name - Effect - Dietary - Supplements - Lifestyle - Genes - RS
        Disease testDisease1 = new Disease("Vitamin D Receptor",
                                           "SNP linked to decreased calcium absorption and increases risk of bone fracture.",
                                           "Blood Type Diet",
                                           "Calcium (1500 mg) daily, Magnesium (750 mg) daily",
                                           "Weight Bearing excerises",
                                           finalArray,
                                           "17883968");
        
        Set<String> diseaseKeys = diseaseMap.keySet();
        System.out.println("There are " + diseaseKeys.size() + " keys.");
        for(String disease : diseaseKeys){
            System.out.println(disease);
        }
        
        if(testDisease1.getName().equals(diseaseMap.get(testDisease1.getName()).getName()) && //test name
                testDisease1.getEffect().equals(diseaseMap.get(testDisease1.getName()).getEffect()) && //test effects
                testDisease1.getDietary().equals(diseaseMap.get(testDisease1.getName()).getDietary()) && //test dietary
                testDisease1.getSupplements().equals(diseaseMap.get(testDisease1.getName()).getSupplements()) && //test supplements
                testDisease1.getLifestyle().equals(diseaseMap.get(testDisease1.getName()).getLifestyle()) && //test lifestyle
                //need causes array to test genes
                testDisease1.getRsNumber().equals(diseaseMap.get(testDisease1.getName()).getRsNumber()) //test RS
                ){
            
            System.out.println("Disease '" + testDisease1.getName() + "' is mapped correctly.");
        }
        else{
            System.out.println("Disease '" + testDisease1.getName() + "' is not mapped correctly.");
        }
    }
}
