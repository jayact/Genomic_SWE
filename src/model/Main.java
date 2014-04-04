package model;

public class Main {

	private GUI gui;
	private Handler handler;
	private Language language;
	private Parser parser;
	
	public static void main(String[] args)
	{
		gui = new GUI();
		parser = new Parser();
		handler = new Handler();
		language = new Language();
		
	}
	
	/**
	 * Tells the parser to write out the disease information.
	 * @return
	 */
	public static boolean writeOut(Map<String, List<Gene>> data, String path)
	{
		return parser.writeOut(data, path);
	}
	
	/**
	 * Tells the parser to read in the info from the file.
	 * Hands the data to the handler.
	 */
	public static Map<String, Gene> readGene(String path)
	{
		parser.setLocation(path);
		return handler.storeData(gene.readIn());
	}
	
	/**
	 * Gets the gene data from the handler.
	 */
	public static Map<String, Gene> getData()
	{
		return handler.getData();
	}
	
	/**
	 * Selects a gene from the data list in handler.
	 * @param gene
	 * @return
	 */
	public static boolean selectGene(String gene)
	{
		return handler.selectGene(gene);
	}
	
	/**
	 * Deselects a gene from the data list in handler.
	 * @param gene
	 * @return
	 */
	public static boolean deselectGene(String gene)
	{
		return handler.deselectGene()
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
	 * @param gene
	 */
	public static boolean setGene(Gene gene)
	{
		return handler.setGene(gene);
	}
	
	/**
	 * Retrieves the list of selected genes in the handler.
	 */
	public static Map<String name, Gene gene> getSelected()
	{
		return handler.getSelected();
	}
	
	/**
	 * Gets the results from the handler.
	 * @return
	 */
	public static Map<String, List<Gene>> results()
	{
		handler.getResults();
	}
	
	/**
	 * Imports the disease list from the parser.
	 * @return
	 */
	public static Map<String, List<Gene>> retrieveDisease()
	{
		return handler.retrieveDisease();
	}
	
	/**
	 * Gets the phrase for the selected language.
	 * @param label
	 * @return
	 */
	public static String findString(String label)
	{
		return langauge.findString(label);
	}
	
	/**
	 * Sets the language, if available.
	 * @param language
	 * @return
	 */
	public static boolean setLanguage(String language)
	{
		return language.setLanguage(language);
	}
}
