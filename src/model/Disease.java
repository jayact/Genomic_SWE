package model;
import java.util.*;
public class Disease
{
	private static ArrayList<ArrayList<Gene>> causes;
	private String name;
	private String effect;
	private String dietary;
	private String supplements;
	private String lifestyle;
	private String rsNumber;
	
	/**
	 * Checks if any of the conditions for the disease are met.
	 * @param selected is the list of selected genes.
	 * @return true if conditions met.
	 */
	public static boolean isAffected(ArrayList<Gene> selected)
	{
		for(ArrayList<Gene> x : causes)
		{
			boolean conditions = true;
			//check if the list of conditions are met.
			int j = 0;
			while(conditions == true && j < x.size())
			{//goes through sub list
				Gene gene_x = x.get(j); //gets current gene
				boolean gene_found = false;
				int i = 0;
				//check input list against condition
				while(gene_found == false && i < selected.size())
				{
					if(gene_x.equals(selected.get(i)))
					{
						gene_found = true;
					}
					i++;
				}
				if(gene_found == false)
				{
					conditions = false;
				}
				j++;
			}
			if(conditions == true)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets a list of the affected genes.
	 * @param selected is the list of selected genes.
	 * @return the list of affected genes.
	 */
	public static ArrayList<ArrayList<Gene>> getAffected(ArrayList<Gene> selected)
	{
		ArrayList<ArrayList<Gene>> results = new ArrayList<ArrayList<Gene>>();
		for(ArrayList<Gene> x : causes)
		{
			boolean conditions = true;
			//check if the list of conditions are met.
			int j = 0;
			while(conditions == true && j < x.size())
			{
				boolean gene_found = false;
				int i = 0;
				Gene gene_x = x.get(j);
				//check input list against condision
				while(gene_found == false && i < selected.size())
				{
					if(gene_x.equals(selected.get(i)))
					{
						gene_found = true;
					}
					i++;
				}
				if(gene_found == false)
				{
					conditions = false;
				}
				j++;
			}
			if(conditions == true)
			{
				results.add(x);
			}
		}
		return results;
	}
	
	/**
	 * Gets the name of the disease.
	 * @return the name of the disease.
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Gets the effect of the disease
	 * @return the effect of the disease
	 */
	public String getEffect() {
		return effect;
	}
	/**
	 * Gets the dietary of the disease
	 * @return the dietary of the disease
	 */
	public String getDietary() {
		return dietary;
	}
	/**
	 * Gets the supplements of the disease
	 * @return the supplements of the disease
	 */
	public String getSupplements() {
		return supplements;
	}
	/**
	 * Gets the lifestyle of the disease
	 * @return the lifestyle of the disease
	 */
	public String getLifestyle() {
		return lifestyle;
	}
	
	
	/**
	 * Gets the rs number of the disease
	 * @return the rsNumber of the disease
	 */
	public Integer getRsNumber() {
		return rsNumber;
	}
    
	public Disease(String name, String effect, String dietary, String supplements, String lifestyle, ArrayList<ArrayList<Gene>> causes, String rsNumber)
	{
		this.causes = causes;
		this.name = name;
		this.effect = effect;
		this.dietary = dietary;
		this.supplements = supplements;
		this.lifestyle = lifestyle;
		this.rsNumber = rsNumber;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < causes.size(); i++) {
			result = causes.get(i).toString();
			//for (int j = 0; j < causes.get(j); j++) {
            
			//}
		}
		return result;
	}
}
