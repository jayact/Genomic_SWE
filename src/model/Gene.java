package model;

public class Gene {
	private String name = "";
	private String variant = "";
	private String rsNumber = "";
	private String type = "";
	private String urgency = "";
	private String[] acceptedColors = { "red", "yellow", "green", "blue",
			"purple" };
	private String[] acceptedTypes = { "heterozygous", "homozygous", "wild",
			"absent" };

	/**
	 * Constructs a gene with all attributes
	 * 
	 * @param name
	 *            Name of the gene
	 * @param type
	 *            Heterozygous, homozygous, wild, or absent
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
		this.variant = variant;
		this.rsNumber = rsNumber;
		this.type = type;
		this.urgency = color;
	}

	/**
	 * Constructs a gene with everything but color and type
	 * 
	 * @param name
	 * @param type
	 * @param reNumber
	 */
	public Gene(String name, String type, String rsNumber) {
		this.name = name;
		this.variant = type;
		this.rsNumber = rsNumber;
	}

	/**
	 * Constructs a gene with name and rsNumber.
	 * 
	 * @param name
	 * @param rsNumber
	 */
	public Gene(String name, String rsNumber) {
		this.name = name;
		this.rsNumber = rsNumber;
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
		if (name.length() != 0) {
			this.name = name;
			return true;
		}
		return false;
	}

	/**
	 * Get the gene variant
	 * 
	 * @return variant
	 */
	public String getVariant() {
		return this.variant;
	}

	/**
	 * Specify the gene variant
	 * 
	 * @param variant
	 *            the variant of the gene
	 * @return true if successful, else false
	 */
	public boolean setVariant(String variant) {
		if (variant.length() != 0) {
			this.variant = variant;
			return true;
		}
		return false;
	}

	/**
	 * Get the rs number of the gene
	 * 
	 * @return the rsNumber of the gene
	 */
	public String getRSNumber() {
		return this.rsNumber;
	}

	/**
	 * Sets the rs number of the gene
	 * 
	 * @param rsNumber
	 *            the rs number of the gene
	 * @return true if it was able to set the property
	 */
	public boolean setRSNumber(String rsNumber) {
		if (rsNumber.length() != 0) {
			this.rsNumber = rsNumber;
			return true;
		}
		return false;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type of the gene (heterozygous, homozygous, wild, or absent)
	 * 
	 * @param type
	 *            1 of the 4 types of genes
	 * @return true if setting type is successful false if setting type is
	 *         unsuccessful
	 */
	public boolean setType(String type) {
		if (containsParam(acceptedTypes, type)) {
			this.type = type;
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
			this.urgency = color;
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

	/**
	 * Checks if one Gene equals another
	 */
	@Override
	public boolean equals(Object o) {
		Gene temp;
		if (!(o instanceof Gene)) {
			return false;
		}
		temp = (Gene) o;
		if (!name.equals(temp.getName()) || !type.equals(temp.getType())) {
			return false;
		}
		return true;
	}

	/**
	 * @return returnString All existent information about a gene
	 */
	@Override
	public String toString() {
		String returnString = "";
		if (name.length() != 0) {
			returnString += "Name: " + name + "\n";
		}
		if (variant.length() != 0) {
			returnString += "Variant: " + variant + "\n";
		}
		if (rsNumber.length() != 0) {
			returnString += "RS Number: " + rsNumber + "\n";
		}
		if (type.length() != 0) {
			returnString += "Type: " + type + "\n";
		}
		if (urgency.length() != 0) {
			returnString += "Urgency: " + urgency + "\n";
		}

		return returnString;
	}
}
