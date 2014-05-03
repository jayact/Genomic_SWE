package model;


import java.io.IOException;
import java.util.*;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import display.*;

public class Main {

	private static GUI gui;
	private static Handler handler = new Handler();
	private static Language language = new Language();
	private static Parser parser = new Parser();
	
	public static void main(String[] args)
	{
		
		parser = new Parser();
		handler = new Handler();
		language = new Language();
		gui = new GUI();
		try {
			handler.storeData(Parser.readGene());
		} catch (Exception e) {
			gui.displayException(e);
		}
		try {
			handler.storeDisease(Parser.readDisease());
		} catch (Exception e) {
			gui.displayException(e);
		}
		try {
			readLanguage("english");
		} catch (Exception e) {
			gui.displayException(e);
		}
		gui.refreshData();
		gui.setVisible(true);
		
	}
	
	/**
	 * Tells the parser to write out the disease information.
	 * @param data is the results to write out.
	 * @param path is the path to the file.
	 * @return if the data was successfully written.
	 */
	public static boolean writeOut(Map<Disease, ArrayList<ArrayList<Gene>>> data, String path)
	{
		return parser.writeOut(data, path);
	}
	
	/**
	 * Tells the parser to read in the info from the file.
	 * Hands the data to the handler.
	 * @param path is the file path of the gene file.
	 * @return a map representing the gene information.
	 */
	public static boolean readGene(String path)
	{
		try {
			return handler.storeData(Parser.readGene(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			gui.displayException(e);
			//e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Tells the parser to read in the info from the file.
	 * Hands the data to the handler.
	 * @param path is the file path of the gene file.
	 * @return a map representing the gene information.
	 */
	public static boolean readGene()
	{
		try {
			return handler.storeData(Parser.readGene());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			gui.displayException(e);
			//e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Gets the gene data from the handler.
	 * @return the data.
	 */
	public static Map<String, Gene> getData()
	{
		return handler.getData();
	}
	
	/**
	 * Selects a gene from the data list in handler.
	 * @param gene is the gene selected.
	 * @return true if the gene was successfully set.
	 */
	public static boolean selectGene(String gene)
	{
		return handler.selectGene(gene);
	}
	
	/**
	 * Deselects a gene from the data list in handler.
	 * @param gene is the gene to deselect.
	 * @return true if gene was successfully deselected.
	 */
	public static boolean deselectGene(String gene)
	{
		return handler.deselectGene(gene);
	}
	
	/**
	 * Deselects all of the genes from the data list in handler.
	 */
	public static void deselectAll()
	{
		handler.deselectAll();
	}
	
	/**
	 * Sets the gene in the handler.
	 * @param gene is the gene info to set.
	 * @return true if successfully set.
	 */
	public static boolean setGene(Gene gene)
	{
		return handler.setGene(gene);
	}
	
	/**
	 * Retrieves the list of selected genes in the handler.
	 * @return a map representing the selected genes.
	 */
	public static Map<String, Gene> getSelected()
	{
		return handler.getSelected();
	}
	
	/**
	 * Gets the results from the handler.
	 * @return a map representing the results.
	 */
	public static Map<Disease, ArrayList<ArrayList<Gene>>> results()
	{
		return handler.getResults();
		
	}
	
	/**
	 * Imports the disease list from the parser.
	 * @return a map representing the disease list.
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws BiffException 
	 */
	public static boolean readDisease() throws BiffException, WriteException, IOException
	{
		try{
			return handler.storeDisease(Parser.readDisease());
		}catch(Exception e)
		{
			gui.displayException(e);
			//e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Gets the phrase for the selected language.
	 * @param label is the search number.
	 * @return the phrase assigned to the number.
	 */
	public static String findString(String label)
	{
		return language.findString(label);
	}
	
	public static boolean readLanguage(String lang)
	{
		try{
			return language.setLanguage(Parser.readLanguage(lang));	
		}catch(Exception e){
			gui.displayException(e);
			//e.printStackTrace();
			return false;
		}
	}
        
    public static boolean storeData(Map<String, Gene> map)
    {
        return handler.storeData(map);
    }
    
    public static boolean removeGene(String gene)
    {
    	return handler.removeGene(gene);
    }
    
    public static Gene getGene(String gene)
    {
    	return handler.getGene(gene);
    }
}