package model;

public class Main {

	private GUI gui;
	private Genome_Parser gene;
	private Handler handler;
	private Language language;
	private Disease_Parser disease;
	
	public static void main(String[] args)
	{
		//To do
	}

	/**
	 * Sets the location for the Genome Parser
	 * @param path
	 * @return
	 */
	public static boolean setLocation(String path)
	{
		//To do
		return false;
	}
	
	/**
	 * Tells the Genome Parser to write out the disease information.
	 * @return
	 */
	public static boolean writeOut(Map<String, List<Gene>> data, String path)
	{
		//To do
		return false;
	}
	
	/**
	 * Tells the Genome Parser to read in the info from the file.
	 */
	public static Map<String, Gene> readIn()
	{
		//To do
		return null;
	}
	
	/**
	 * Gets the gene data from the handler.
	 */
	public static Map<String, Gene> retrieveData()
	{
		//To do
		return null;
	}
	
	/**
	 * Selects a gene from the data list in handler.
	 * @param gene
	 * @return
	 */
	public static boolean selectGene(String gene)
	{
		//To do
		return false;
	}
	
	/**
	 * Deselects a gene from the data list in handler.
	 * @param gene
	 * @return
	 */
	public static boolean deselectGene(String gene)
	{
		//To do
		return false;
	}
	
	/**
	 * Deselects all of the genes from the data list in handler.
	 */
	public static void deselectAll()
	{
		//To do
	}
	
	/**
	 * Sets the gene in the handler.
	 * @param gene
	 */
	public static setGene(Gene gene)
	{
		//To do
		return null;
	}
	
	/**
	 * Retrieves the list of selected genes in the handler.
	 */
	public static Map<String name, Gene gene> getSelected()
	{
		//To do
		return null;
	}
	
	/**
	 * Gets the results from the handler.
	 * @return
	 */
	public static Map<String, List<Gene>> results()
	{
		//To do
		return null;
	}
	
	/**
	 * Imports the disease list from the Disease Parser.
	 * @return
	 */
	public static Map<String, List<Gene>> retrieveDisease()
	{
		//To do
		return null;
	}
	
	/**
	 * Gets the phrase for the selected language.
	 * @param label
	 * @return
	 */
	public static String findString(String label)
	{
		//To do
		return null;
	}
	
	/**
	 * Sets the language, if available.
	 * @param language
	 * @return
	 */
	public static boolean setLanguage(String language)
	{
		//To do
		return false;
	}
}
