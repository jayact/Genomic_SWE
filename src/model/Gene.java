package model;

public class Gene
{
	private String urgency = "";
	private String name = "";
	private String type = "";
	private String[] acceptedColors = {"red", "yellow", "green", "blue", "purple"};
	private String[] acceptedTypes = {"heterozygous", "homozygous", "wild", "present"};
	
	/**
	 * Sets the type of the gene (heterozygous, homozygous, wild, or present)
	 * @param type - 1 of the 4 types of genes
	 * @return true if setting type is successful
	 * 	false if setting type is unsuccessful
	 */
	public boolean setType(String type)
	{
		if(containsParam(acceptedTypes, type))
			return true;
		return false;
	}
	
	/**
	 * Sets the urgency color code of the gene (red, yellow, green, blue, or purple)
	 * @param color - Final urgency color code of the gene
	 * @return true if setting color is successful
	 * 	false if setting color is unsuccessful
	 */
	public boolean setUrgency(String color)
	{
		if(containsParam(acceptedColors, color))
			return true;
		return false;
	}
	
	/**
	 * Sets the name of the gene
	 * @param name - Name of the gene
	 * @return true if setting name is successful
	 */
	public boolean setName(String name)
	{
		this.name = name;
		return true;
	}
	
	/**
	 * Checks if a String array contains a string
	 * @param array - Array to check
	 * @param check - String to check for membership
	 * @return true if array contains check
	 * 	fales if array does not contain check
	 */
	private boolean containsParam(String[] array, String check)
	{
		for(int i = 0; i < array.length; i++)
			if(check.equalsIgnoreCase(array[i]))
			{
				return true;
			}
		return false;
	}
}