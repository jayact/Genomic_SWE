package model;

public class Gene {
	private String urgency = "";
	private String name = "";
	private String type = "";
	private String[] acceptedColors = { "red", "yellow", "green", "blue",
			"purple" };
	private String[] acceptedTypes = { "heterozygous", "homozygous", "wild",
			"present" };
	private Integer rsNumber;
	private String abbreviation;

	/**
	 * Get the rs number of the gene
	 * @return the rsNumber of the gene
	 */
	public Integer getRsNumber() {
		return rsNumber;
	}
	/**
	 * Sets the rs number of the gene
	 * @param rsNumber the rs number of the gene
	 * @return true if it was able to set the property
	 */
	public Boolean setRsNumber(Integer rsNumber) {
		if(rsNumber != null){
		this.rsNumber = rsNumber;
		return true;
		}
		return false;
	}
	/**
	 * Get the abbreviation of the gene
	 * @return the abbreviation of the gene
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	/**
	 * Sets the abbreviation of the gene
	 * @param rsNumber the abbreviation of the gene
	 * @return true if it was able to set the property
	 */
	public Boolean setAbbreviation(String abbreviation) {
		if(abbreviation != null){
			this.abbreviation = abbreviation;
			return true;
			}
			return false;
	}

	/**
	 * Constructs a gene with all attributes
	 * 
	 * @param name
	 *            Name of the gene
	 * @param type
	 *            Heterozygous, homozygous, wild, or present
	 * @param color
	 *            Urgency rating: red, yellow, green, blue, purple
	 * @param rsNumber
	 * 			  the number identifier
	 * @param abbreviations  
	 * 			  the gene abbreviation         
	 */
	public Gene(String name, String type, String color, Integer rsNumber, String abbreviation) {
		this.name = name;
		this.type = type;
		this.urgency = color;
		this.abbreviation = abbreviation;
		this.rsNumber = rsNumber; 
	}

	/**
	 * Constructs a gene with just the name
	 * 
	 * @param name
	 *            Name of the gene
	 */
	public Gene(String name) {
		this.name = name;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type of the gene (heterozygous, homozygous, wild, or present)
	 * 
	 * @param type
	 *            1 of the 4 types of genes
	 * @return true if setting type is successful false if setting type is
	 *         unsuccessful
	 */
	public boolean setType(String type) {
		if (containsParam(acceptedTypes, type))
			return true;
		return false;
	}

	/**
	 * @return urgency
	 */
	public String getUrgency() {
		return this.urgency;
	}

	/**
	 * Sets the urgency color code of the gene (red, yellow, green, blue, or
	 * purple)
	 * 
	 * @param color
	 *            Final urgency color code of the gene
	 * @return true if setting color is successful false if setting color is
	 *         unsuccessful
	 */
	public boolean setUrgency(String color) {
		if (containsParam(acceptedColors, color))
			return true;
		return false;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the gene
	 * 
	 * @param name
	 *            Name of the gene
	 * @return true if setting name is successful
	 */
	public boolean setName(String name) {
		this.name = name;
		return true;
	}

	/**
	 * Checks if a String array contains a string
	 * 
	 * @param array
	 *            Array to check
	 * @param check
	 *            String to check for membership
	 * @return true if array contains check fales if array does not contain
	 *         check
	 */
	private boolean containsParam(String[] array, String check) {
		for (int i = 0; i < array.length; i++)
			if (check.equalsIgnoreCase(array[i])) {
				return true;
			}
		return false;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Gene temp;
		if(!(o instanceof Gene))
		{
			return false;
		}
		temp = (Gene) o;
		if(name != temp.getName() || urgency != temp.getUrgency() || type != temp.getType())
		{
			return false;
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		String returnString = "";
		returnString += "Name: " + name + "\n" +
				"Type: " + type + "\n" +
				"Urgency: " + urgency + "\n";
		return returnString;
	}
}