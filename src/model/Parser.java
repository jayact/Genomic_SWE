package model;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * The Parser class reads from files and writes to a file.  This class requires
 * assets from the JExcelAPI(http://jexcelapi.sourceforge.net/).
 * 
 * @author Chris Meyers
 */
public class Parser {
    // DEBUG 0 -> readDisease() testing
    // DEBUG 1 -> readDisease(), readLanguage() testing  
    // DEBUG 2 -> readDisease(), readLanguage(), readGene() testing
    private static final int DEBUG = 0; 
    private static final String root = "refs/";
    //MAIN INCLUDED AND FUNCTIONS MADE STATIC FOR TESTING PURPOSES

    public static void main(String [] args) throws BiffException, IOException, WriteException{
        readDisease();
        readLanguage("english");
        //readGene("test");
    }
    
    public Parser(){
        
    }
    
    public boolean writeOut(Map<Disease, ArrayList<ArrayList<Gene>>> data, String path) throws BiffException, IOException, WriteException{
        WritableWorkbook wworkbook;
        wworkbook = Workbook.createWorkbook(new File(path));
        WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
        
        //patient data goes here
        Patient patient = new Patient();
        Label currentPatient = new Label(0, 0, patient.toString());
        wsheet.addCell(currentPatient);
        
        //Add quick list here (Gene - Urgency)
        //...
        //...
        
        
        //Prints out Diseases and genes that cause them.
        int row = 1;
        int col = 0;
        
        Set<Disease> k = data.keySet();
        for(Disease d : k){
            col = 0; //resets the column to start
            ArrayList<ArrayList<Gene>> l = data.get(d);
            Label currentDisease = new Label(col, row, d.getName());
            wsheet.addCell(currentDisease); // Writes
            row++;
            
            for(ArrayList<Gene> m : l){
                for (Gene m1 : m) {
                    Label currentGene = new Label(col, row, m1.getName());
                    wsheet.addCell(currentGene);
                    col++;
                    
                    Label currentLifestyle = new Label(col, row, d.getLifestyle());
                    wsheet.addCell(currentLifestyle);
                    col++;
                    
                    Label currentDietary = new Label(col, row, d.getDietary());
                    wsheet.addCell(currentDietary);
                    col++;
                    
                    Label currentEffect = new Label(col, row, d.getEffect());
                    wsheet.addCell(currentEffect);
                    col++;
                    
                    Label currentSuppliments = new Label(col, row, d.getSupplements());
                    wsheet.addCell(currentSuppliments);
                    col++;
                } 
            }
        }
        
    	return true;
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
    public static Map<String, Gene> readGene() throws BiffException, IOException, WriteException{
        Map<String, Gene> geneMap = new HashMap<String, Gene>();
        
        Workbook wb = Workbook.getWorkbook(new File(root + "gene.xls"));
        Sheet sheet = wb.getSheet(0);
	    for(int i = 1; i < sheet.getRows(); i++){
	        Gene temp = new Gene(getCurrentCell(sheet,0,i),getCurrentCell(sheet,1,i),getCurrentCell(sheet,2,i));
	        geneMap.put(temp.getName(),temp);
	        // geneMap.put("Gene" + i, new Gene(getCurrentCell(sheet,0,i),getCurrentCell(sheet,1,i),getCurrentCell(sheet,2,i)));
	            
	        if(DEBUG >= 2){
	            System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i) + " " + getCurrentCell(sheet,2,i));
	        }    
	    }
        return geneMap;
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
        
        Workbook wb = Workbook.getWorkbook(new File(path + "gene.xls"));
        Sheet sheet = wb.getSheet(0);

        for(int i = 1; i < sheet.getRows(); i++){
	        Gene temp = new Gene(getCurrentCell(sheet,0,i),getCurrentCell(sheet,1,i),getCurrentCell(sheet,2,i),getCurrentCell(sheet,3,i),getCurrentCell(sheet,4,i));
	        geneMap.put(temp.getName(),temp);
	            
	        if(DEBUG >= 2){
	            System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i) + " " + getCurrentCell(sheet,2,i));
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
    public static Map<String, Disease> readDisease() throws BiffException, IOException, WriteException {
        Map<String, Disease> diseaseMap = new HashMap<String, Disease>();
        ArrayList<ArrayList<Gene>> geneList = new ArrayList<ArrayList<Gene>>();
        
        //Workbook wb = Workbook.getWorkbook(new File(root + "disease.xls"));
        Workbook wb = Workbook.getWorkbook(new File(root + "diseaseDatabase2.xls"));
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 1;i < sheet.getRows();i++){
            Disease temp = new Disease(getCurrentCell(sheet, 0, i), // Disease Name
                                       getCurrentCell(sheet, 2, i), // Effect
                                       getCurrentCell(sheet, 3, i), // Dietary
                                       getCurrentCell(sheet, 4, i), // Suppliments
                                       getCurrentCell(sheet, 5, i), // Lifestyle
                                       makeGeneList(geneList, sheet, 0, i),
                                       getCurrentCell(sheet, 6, i));// RS number
            
            diseaseMap.put(temp.getName(), temp);
            geneList.clear();
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
    public static Map<String, String> readLanguage(String language) throws BiffException, IOException, WriteException{
        Map<String, String> languageMap = new HashMap<String, String>();
        
        Workbook wb = Workbook.getWorkbook(new File(root + language + ".xls"));
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 1;i < sheet.getRows();i++){
            languageMap.put(getCurrentCell(sheet,0,i), getCurrentCell(sheet,1,i));
            
            if(DEBUG >= 1){
                System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i));
            }
        }
        
        return languageMap;
    }
    
    public boolean writeResults(Map<String, List<Gene>> map, String path){
        return true;
    }
    
    
    /**
     * Returns the value of the current cell as a string.
     */
    private static String getCurrentCell(Sheet s, int col, int row){
        return s.getCell(col,row).getContents();
    }
    
    /**
     * Returns a list of all genes related to a disease.
     */
    private static ArrayList<ArrayList<Gene>> makeGeneList(ArrayList<ArrayList<Gene>> geneList, Sheet s, int col, int row){
        ArrayList<Gene> geneSubArray = new ArrayList<Gene>();
        String currentDisease = getCurrentCell(s, col, row);
        
        for(int i = row; i < s.getRows(); i++){
            if(getCurrentCell(s, 0, i).equals(currentDisease)){
                //Must still be the same Disease if here.
                geneSubArray.add(new Gene(getCurrentCell(s, 1, i), getCurrentCell(s, 6, i)));
                geneList.add(geneSubArray);
                //System.out.println("Gene Sub Array: " + geneSubArray);
                //System.out.println("Gene List: " + geneList);
                geneSubArray.clear();
            }
            else{
                break; //Different disease, done here
            }
        }

        return geneList;
    }
}
