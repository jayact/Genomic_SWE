package model;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * The Parser class reads from files and writes to a file.  This class requires
 * assets from the JExcelAPI(http://jexcelapi.sourceforge.net/).
 * 
 * @author Chris Meyers
 */
public class Parser {
    private static final boolean DEBUG = true;
    
    //MAIN INCLUDED AND FUNCTIONS MADE STATIC FOR TESTING PURPOSES
    public static void main(String [] args) throws BiffException, IOException, WriteException{
        readDisease();
        readLanguage();
        readGene("test");
    }
    
    public Parser(){
        
    }
    
    /**
     * Takes a specified gene spreadsheet and parses all gene information for
     * each gene.  Each gene is stored in a map with an incremental gene name
     * and a Gene object with all of its data.
     * 
     * @param path the path to the gene information spreadsheet.
     * @return a map where K=Genei and V=Gene(name, type, color) 
     * @throws BiffException
     * @throws IOException
     * @throws WriteException 
     */
    public static Map<String, Gene> readGene(String path) throws BiffException, IOException, WriteException{
        Map<String, Gene> geneMap = new HashMap<String, Gene>();
        
        Workbook wb = Workbook.getWorkbook(new File("C:\\Users\\Chris\\Dropbox\\Rowan Documents\\3 Junior\\Spring Semester\\Software Engineering\\Genomic_SWE\\xls\\gene.xls"));
        Sheet sheet = wb.getSheet(0);

        // TODO: Need gene constructor: Gene(String name, String type, String color)
        for(int i = 1; i < sheet.getRows(); i++){
            if(DEBUG){
                System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i) + " " + getCurrentCell(sheet,2,i));
            }
            else{
                geneMap.put("Gene" + i, new Gene(getCurrentCell(sheet,0,i),getCurrentCell(sheet,1,i),getCurrentCell(sheet,2,i)));
            }
        }
        return geneMap;
    }
    
    /**
     * Takes a disease spreadsheet and parses the disease name and all genes
     * that are a cause of the disease.  Each diseaseName-geneList relation
     * is stored as an entry in the diseaseMap map.
     * 
     * @return a map where K=disease name and V=list of all related genes
     * @throws BiffException
     * @throws IOException
     * @throws WriteException 
     */
    public static Map<String, List<Gene>> readDisease() throws BiffException, IOException, WriteException {
        Map<String, List<Gene>> diseaseMap = new HashMap<String, List<Gene>>();
        
        Workbook wb = Workbook.getWorkbook(new File("C:\\Users\\Chris\\Dropbox\\Rowan Documents\\3 Junior\\Spring Semester\\Software Engineering\\Genomic_SWE\\xls\\disease.xls"));
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 1;i < sheet.getRows();i++){
            diseaseMap.put(getCurrentCell(sheet,0,i), makeGeneList(sheet,2,i));
        }
        
        return diseaseMap;
    }
    
    /**
     * Takes a language spreadsheet and parses the labels and phrases. Each 
     * label-phrase relation is stored as an entry in the languageMap map.
     * 
     * @return a map where K=label and V=phrase
     * @throws BiffException
     * @throws IOException
     * @throws WriteException 
     */
    public static Map<String, String> readLanguage() throws BiffException, IOException, WriteException{
        Map<String, String> languageMap = new HashMap<String, String>();
        
        Workbook wb = Workbook.getWorkbook(new File("C:\\Users\\Chris\\Dropbox\\Rowan Documents\\3 Junior\\Spring Semester\\Software Engineering\\Genomic_SWE\\xls\\lang.xls"));
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 1;i < sheet.getRows();i++){
            if(DEBUG){
                System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i));
            }
            else{
                languageMap.put(getCurrentCell(sheet,0,i), getCurrentCell(sheet,1,i));
            }
        }
        
        return languageMap;
    }
    /*
    public boolean writeResults(Map<String, List<Gene>>, String path){
        return true;
    }
    */
    
    /**
     * Returns the value of the current cell as a string.
     */
    private static String getCurrentCell(Sheet s, int col, int row){
        return s.getCell(col,row).getContents();
    }
    
    /**
     * Returns a list of all genes related to a disease.
     */
    private static List<Gene> makeGeneList(Sheet s, int col, int row){
        List<String> tempGeneList = new ArrayList<String>();
        List<Gene> geneList = new ArrayList<Gene>();
        
        // Loop through all causes and add each gene to tempGeneList as a String
        for(int i = col; i < s.getColumns(); i++){
            List<String> causeGenes = new ArrayList<String>(Arrays.asList(getCurrentCell(s,i,row).split(" ")));
            tempGeneList.addAll(causeGenes);
            //System.out.print(getCurrentCell(s,i,row) + " ");
        }
        
        // TODO Need gene constructor: Gene(String name)
        // Add each gene String to geneList as a Gene
        for(int i = 0;i < tempGeneList.size();i++){
            if(DEBUG){
                System.out.println(tempGeneList.get(i));
            }
            else{
                geneList.add(new Gene(tempGeneList.get(i)));
            }
        }
        
        if(DEBUG){
            System.out.println("-----------------------");
        }
        return geneList;
    }
}
