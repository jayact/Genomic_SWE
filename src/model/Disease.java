package model;
import java.util.*;
public class Disease 
{
	private static ArrayList<ArrayList<Gene>> causes;
	private String recommendations;
	private String name;
	
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
			{
				Gene gene_x = x.get(j);
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
	 * Gets the recommendations for the disease treatment.
	 * @return the recommendations for the disease treatment.
	 */
	public String getRecommendations()
	{
		return recommendations;
	}
	
	public Disease(String name, String recommendations, ArrayList<ArrayList<Gene>> causes)
	{
		this.name = name;
		this.recommendations = recommendations;
		Disease.causes = causes;
	}
}
