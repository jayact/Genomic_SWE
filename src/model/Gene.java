package model;

public class Gene
{
	private String urgency = "";
	private String name = "";
	private String type = "";
	private String[] acceptedColors = {"red", "yellow", "green", "blue", "purple"};
	private String[] acceptedTypes = {"heterozygous", "homozygous", "wild", "present"};
	
	public boolean setType(String type)
	{
		if(containsParam(acceptedTypes, type))
			return true;
		return false;
	}
	
	public boolean setUrgency(String color)
	{
		if(containsParam(acceptedColors, color))
			return true;
		return false;
	}
	
	public boolean setName(String name)
	{
		this.name = name;
		return true;
	}
	
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