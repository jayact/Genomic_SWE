package model;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.biff.RowsExceededException;

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
    //private static final int DEBUG = 0; 
    private static final String root = System.getProperty("user.dir") + "/refs/";
    
    public Parser(){
        
    }
    
    public boolean saveGenes(Map<String, Gene> data, String path) throws RowsExceededException, WriteException, IOException, BiffException
    {
    	 WritableWorkbook workbook = Workbook.createWorkbook(new File(path));
         WritableSheet wsheet = workbook.createSheet("First Sheet", 0);
         
         int i = 1;
         Set<String> keys = data.keySet();
         
         //write default header
         wsheet.addCell(new Label(0,0,"Gene"));
    	 wsheet.addCell(new Label(1,0,"Variant"));
    	 wsheet.addCell(new Label(2,0,"RS Number"));
    	 wsheet.addCell(new Label(3,0,"Type"));
    	 wsheet.addCell(new Label(4,0,"Urgency"));
    	 
         for(String k : keys)
         {
        	 Gene gene = data.get(k);
        	 wsheet.addCell(new Label(0,i,gene.getName()));
        	 wsheet.addCell(new Label(1,i,gene.getVariant()));
        	 wsheet.addCell(new Label(2,i,gene.getRSNumber()));
        	 wsheet.addCell(new Label(3,i,gene.getType()));
        	 wsheet.addCell(new Label(4,i,gene.getUrgency()));
        	 i++;
         }
         workbook.write();
         workbook.close();
         return true;
    }
    
    /**
     * Writes user selected data out to an excel file.
     * 
     * @param data all data needed to print a report
     * @param path path to save the final report
     * @param patient the current patient data
     * @return true if the report was created successfully, false otherwise.
     * @throws BiffException
     * @throws IOException
     * @throws WriteException 
     */
    public boolean writeOut(Map<Disease, ArrayList<ArrayList<Gene>>> data, String path, Patient patient) throws BiffException, IOException, WriteException{
        WritableWorkbook wworkbook;
        wworkbook = Workbook.createWorkbook(new File(path));
        WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
        
        //patient data goes here
        Label parientLname = new Label(0, 0, "Last Name: " + patient.get_last_name());
        Label parientFname = new Label(0, 1, "First Name: " + patient.get_first_name());
        Label parientInitial = new Label(0, 2, "Middle Initial: " + patient.get_initial());
        Label parientAddress = new Label(0, 3, "Address: " + patient.get_address());
        Label parientCity = new Label(0, 4, "City: " + patient.get_city());
        Label parientState = new Label(0, 5, "State: " + patient.get_state());
        Label parientGender = new Label(0, 6, "Gender: " + patient.get_gender());
        Label parientDOBmonth = new Label(0, 7, "Month: " + patient.get_month());
        Label parientDOBday = new Label(0, 8, "Day: " + patient.get_day());
        Label parientDOByear = new Label(0, 9, "Year: " + patient.get_year());
        wsheet.addCell(parientLname);
        wsheet.addCell(parientFname);
        wsheet.addCell(parientInitial);
        wsheet.addCell(parientAddress);
        wsheet.addCell(parientCity);
        wsheet.addCell(parientState);
        wsheet.addCell(parientGender);
        wsheet.addCell(parientDOBmonth);
        wsheet.addCell(parientDOBday);
        wsheet.addCell(parientDOByear);
        //age
        //ethnicity
        
        //quick list (Gene - Urgency)
        int rowQuick = wsheet.getRows() + 1;
        int colQuick = 0;

        Set<Disease> kQuick = data.keySet();
        for(Disease d : kQuick){
            colQuick = 0; //resets the column to start
            
            //String urgency = "RED";
            //cellFormat.setBackground(Colour.RED);
            
            ArrayList<ArrayList<Gene>> l = data.get(d);
            Label currentDisease = new Label(colQuick, rowQuick, d.getName());
            
            wsheet.addCell(currentDisease); // Writes current disease
            rowQuick++;
            
            for(ArrayList<Gene> m : l){
                for (Gene m1 : m) {
                    // m1.getUrgency() is returning an empty string
                    WritableCellFormat cellFormat = formatCell(m1.getUrgency(), m1);
                    
                    Label currentGene = new Label(colQuick, rowQuick, m1.getName(), cellFormat);
                    wsheet.addCell(currentGene);
                    
                    colQuick++;
                    rowQuick++;
                } 
            }
        }
        rowQuick = wsheet.getRows() + 1;
        
        //Full data list
        //Prints out Diseases and genes that cause them.
        int row = rowQuick;
        int col = 0;
        
        Set<Disease> kFull = data.keySet();
        for(Disease d : kFull){
            col = 0; //resets the column to start
            ArrayList<ArrayList<Gene>> l = data.get(d);
            Label currentDisease = new Label(col, row, d.getName());
            wsheet.addCell(currentDisease); // Writes disease
            row++;
            
            for(ArrayList<Gene> m : l){
                for (Gene m1 : m) {
                    
                    WritableCellFormat cellFormat = formatCell(m1.getUrgency(), m1);
                    System.out.println(cellFormat.toString());
                    
                    Label currentGene = new Label(col, row, m1.getName(), cellFormat);
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
                    row++;
                } 
            }
        }
        wworkbook.write();
        wworkbook.close();
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
        Workbook wb = Workbook.getWorkbook(new File(root + "sample/gene.xls"));
        Sheet sheet = wb.getSheet(0);
	    for(int i = 1; i < sheet.getRows(); i++){
	    	if(!getCurrentCell(sheet,0,i).isEmpty())
	    	{
		        Gene temp = new Gene(getCurrentCell(sheet,0,i),getCurrentCell(sheet,1,i),getCurrentCell(sheet,2,i));
		        geneMap.put(temp.getName(),temp);
		        // geneMap.put("Gene" + i, new Gene(getCurrentCell(sheet,0,i),getCurrentCell(sheet,1,i),getCurrentCell(sheet,2,i)));
		            
		        //if(DEBUG >= 2){
		         //   System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i) + " " + getCurrentCell(sheet,2,i));
		        //}  
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
        Workbook wb = Workbook.getWorkbook(new File(path));
        Sheet sheet = wb.getSheet(0);
        for(int i = 1; i < sheet.getRows(); i++){
        	if(!getCurrentCell(sheet,0,i).isEmpty())
        	{
		        Gene temp = new Gene(getCurrentCell(sheet,0,i),getCurrentCell(sheet,1,i),getCurrentCell(sheet,2,i),getCurrentCell(sheet,3,i),getCurrentCell(sheet,4,i));
		        geneMap.put(temp.getName(),temp);
		            
		        //if(DEBUG >= 2){
		        //    System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i) + " " + getCurrentCell(sheet,2,i));
		        //}   
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
        Workbook wb = Workbook.getWorkbook(new File( root + "sample/disease.xls"));
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 1;i < sheet.getRows()-1;i++){
            Disease temp = new Disease((getCurrentCell(sheet, 0, i).trim() + ":" +
                                        getCurrentCell(sheet, 1, i) + ":" +
                                        getCurrentCell(sheet, 7, i).substring(0,2)), // Unique Disease Name
                                       getCurrentCell(sheet, 2, i), // Effect
                                       getCurrentCell(sheet, 3, i), // Dietary
                                       getCurrentCell(sheet, 4, i), // Suppliments
                                       getCurrentCell(sheet, 5, i), // Lifestyle
                                       makeGeneList(sheet, 0, i),
                                       getCurrentCell(sheet, 6, i),
                                       getCurrentCell(sheet, 7, i));// RS number
            
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
        
        Workbook wb = Workbook.getWorkbook(new File(root + "languages/" + language + ".xls"));
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 1;i < sheet.getRows();i++){
            languageMap.put(getCurrentCell(sheet,0,i), getCurrentCell(sheet,1,i));
            
            //if(DEBUG >= 1){
            //    System.out.println(getCurrentCell(sheet,0,i) + " " + getCurrentCell(sheet,1,i));
            //}
        }
        
        return languageMap;
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
    private static ArrayList<ArrayList<Gene>> makeGeneList(Sheet s, int col, int row){
        ArrayList<Gene> geneSubArray = new ArrayList<Gene>();
        ArrayList<ArrayList<Gene>> geneList = new ArrayList<ArrayList<Gene>>();
        geneSubArray.add(new Gene(getCurrentCell(s, 1, row), getCurrentCell(s, 7, row), getCurrentCell(s, 6, row)));
        geneList.add(geneSubArray);

       //geneSubArray.clear();

        return geneList;
    }
    
    /**
     * Sets the cell color for each gene.
     * 
     * @param urgency the color the cell should be set to
     * @param m1 the current gene
     * @return the formatted cell
     * @throws WriteException 
     */
    private WritableCellFormat formatCell(String urgency, Gene m1) throws WriteException{
        WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);

        switch (urgency) {
            case "red":
                System.out.println(m1.getName() + " SET TO RED");
                cellFormat.setBackground(Colour.RED);
                break;
            case "yellow":
                System.out.println(m1.getName() + " SET TO YELLOW");
                cellFormat.setBackground(Colour.YELLOW);
                break;
            case "green":
                System.out.println(m1.getName() + " SET TO GREEN");
                cellFormat.setBackground(Colour.GREEN);
                break;
            case "blue":
                System.out.println(m1.getName() + " SET TO BLUE");
                cellFormat.setBackground(Colour.BLUE);
                break;
            case "purple":
                System.out.println(m1.getName() + " SET TO PURPLE");
                cellFormat.setBackground(Colour.VIOLET);
                break;
            default:
                System.out.println("SOMETHNG IS MESSED UP");
                cellFormat.setBackground(Colour.GREY_25_PERCENT);
                break;
        }
        
        return cellFormat;
    }
}
