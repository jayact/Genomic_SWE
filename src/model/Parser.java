package model;

import java.io.File;
import java.io.IOException;

import java.util.*;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * The Parser class reads from a file and writes to a file.
 * 
 * @author Chris Meyers
 */
public class Parser {
    public static void main(String [] args) throws BiffException, IOException, WriteException{
        readDisease();
    }
    
    public Parser(){
        
    }

    public Map<String, String> readGene(String path){
        Map<String, String> geneMap = new HashMap<String, String>();
        
        Workbook wb = Workbook.getWorkbook(new File());
        Sheet sheet = wb.getSheet(0);
        
        return null;
    }
    
    public static Map<String, List<Gene>> readDisease() throws BiffException, IOException, WriteException {
        Map<String, List<Gene>> diseaseMap = new HashMap<String, List<Gene>>();
        
        Workbook wb = Workbook.getWorkbook(new File("C:\\Users\\Chris\\Dropbox\\Rowan Documents\\3 Junior\\Spring Semester\\Software Engineering\\Genomic_SWE\\xls\\testinput.xls"));
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 0;i < sheet.getRows();i++){
            for(int j = 0;j < sheet.getColumns();j++){
                //diseaseMap.put(sheet.getCell(j,0).getContents(), getCurretCell(sheet,j,i));
                //System.out.print(sheet.getCell(j,0).getContents() + " ");
                System.out.print(getCurretCell(sheet,j,i) + "    ");
            }
            System.out.println();
        }
        
        return null;
    }
    
    private static String getCurretCell(Sheet s, int col, int row){
        return s.getCell(col,row).getContents();
    }
    
    public Map<String, String> readLanguage() {
        Map<String, String> languageMap = new HashMap<String, String>();
        
        Workbook wb = Workbook.getWorkbook(new File());
        Sheet sheet = wb.getSheet(0);
        
        for(int i = 0;i < sheet.getRows();i++){
            for(int j = 0;j < sheet.getColumns();j++){
                
            }
        }
        
        return null;
    }
    /*
    public boolean writeResults(Map<String, List<Gene>>, String path){
        return true;
    }*/
}
