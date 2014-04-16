package model;

import java.io.File;
import java.io.IOException;

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
            //System.out.println(sheet.getCell(0,i).getContents() + " " + sheet.getCell(1,i).getContents() + " " + sheet.getCell(2,i).getContents() + "\n");
            geneMap.put("Gene" + i, new Gene(sheet.getCell(0,i).getContents(),sheet.getCell(1,i).getContents(),sheet.getCell(2,i).getContents()));
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
        
        for(int i = 0;i < sheet.getRows();i++){
            
            for(int j = 0;j < sheet.getColumns();j++){
                //diseaseMap.put(sheet.getCell(j,0).getContents(), getCurretCell(sheet,j,i));
                //System.out.print(sheet.getCell(j,0).getContents() + " ");
                System.out.print(getCurretCell(sheet,j,i) + "    ");
            }
            System.out.println();
        }
        
        return diseaseMap;
    }
    
    private static String getCurretCell(Sheet s, int col, int row){
        return s.getCell(col,row).getContents();
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
            //System.out.println(sheet.getCell(0,i).getContents() + " " + sheet.getCell(1,i).getContents() + "\n");
            languageMap.put(sheet.getCell(0,i).getContents(), sheet.getCell(1,i).getContents());
        }
        
        return languageMap;
    }
    /*
    public boolean writeResults(Map<String, List<Gene>>, String path){
        return true;
    }
    */
}
