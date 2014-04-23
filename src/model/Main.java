package model;

import java.util.*;

public class Main {

	private GUI gui;
	private static Handler handler;
	private static Language language;
	private static Parser parser;
	
	public static void main(String[] args)
	{
		gui = new GUI();
		parser = new Parser();
		handler = new Handler();
		language = new Language();
		
		handler.storeDisease(parser.readDisease());
		//fix this shit too.
		//language.setLanguage(English);
		gui.start();
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
	public static Map<String, Gene> readGene(String path)
	{
		//fix this shit
		//parser.setLocation(path);
		//return handler.storeData(gene.readIn());
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
		return handler.deselectGene();
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
	 */
	public static Map<String, Disease> readDisease()
	{
		return parser.readDisease();
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
	
}
