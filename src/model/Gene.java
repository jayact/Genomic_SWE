package model;

public class Gene {
	private String urgency = "";
	private String name = "";
	private String type = "";
	private String[] acceptedColors = { "red", "yellow", "green", "blue",
			"purple" };
	private String[] acceptedTypes = { "heterozygous", "homozygous", "wild",
			"present" };
	private String rsNumber = "";
	private String varient = "";

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
	 *            the number identifier
	 * @param abbreviations
	 *            the gene abbreviation
	 */
	public Gene(String name, String variant, String rsNumber, String type,
			String color) {
		this.name = name;
		this.type = type;
		this.urgency = color;
		this.varient = variant;
		this.rsNumber = rsNumber;
	}

	/**
	 * Constructs a gene with everything but color and type
	 * 
	 * @param name
	 * @param rsNumber
	 * @param abbr
	 */
	public Gene(String name, String rsNumber, String abbr) {
		this.name = name;
		this.rsNumber = rsNumber;
		this.varient = abbr;
	}

	/**
	 * Constructs a gene with name and RS number
	 * 
	 * @param name
	 *            Name of gene
	 * @param rsNumber
	 *            rsNumber of gene
	 */
	public Gene(String name, String rsNumber) {
		this.name = name;
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
		if (containsParam(acceptedTypes, type)) {
			// this.type = type;
			return true;
		}
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
		if (containsParam(acceptedColors, color)) {
			// //this.urgency = color;
			return true;
		}
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
	 * Get the rs number of the gene
	 * 
	 * @return the rsNumber of the gene
	 */
	public String getRsNumber() {
		return rsNumber;
	}

	/**
	 * Sets the rs number of the gene
	 * 
	 * @param rsNumber
	 *            the rs number of the gene
	 * @return true if it was able to set the property
	 */
	public Boolean setRsNumber(String rsNumber) {
		if (rsNumber != null) {
			this.rsNumber = rsNumber;
			return true;
		}
		return false;
	}

	/**
	 * Get the abbreviation of the gene
	 * 
	 * @return the abbreviation of the gene
	 */
	public String getAbbreviation() {
		return varient;
	}

	/**
	 * Sets the abbreviation of the gene
	 * 
	 * @param rsNumber
	 *            the abbreviation of the gene
	 * @return true if it was able to set the property
	 */
	public Boolean setAbbreviation(String abbreviation) {
		if (abbreviation != null) {
			this.varient = abbreviation;
			return true;
		}
		return false;
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
	public boolean equals(Object o) {
		Gene temp;
		if (!(o instanceof Gene)) {
			return false;
		}
		temp = (Gene) o;
		if (name != temp.getName() || urgency != temp.getUrgency()
				|| type != temp.getType()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String returnString = "";
		returnString += "Name: " + name + "\n" + "Type: " + type + "\n"
				+ "Urgency: " + urgency + "\n";
		return returnString;
	}
}