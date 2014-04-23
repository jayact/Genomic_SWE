
public class Disease 
{
	private List<List<Gene>> causes;
	private String recommendations;
	private String name;
	
	/**
	 * Checks if any of the conditions for the disease are met.
	 * @param selected is the list of selected genes.
	 * @return true if conditions met.
	 */
	public static boolean isAffected(List<Gene> selected)
	{
		for(List<Gene> x : causes)
		{
			boolean conditions = true;
			//check if the list of conditions are met.
			int j = 0;
			while(conditions == true && j < causes.size())
			{
				boolean gene_found = false;
				int i = 0;
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
					onditions = false;	
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
	public static List<List<Gene>> getAffected(List<Gene> selected)
	{
		List<List<Gene>> results = new List<List<Gene>>();
		for(List<Gene> x : causes)
		{
			boolean conditions = true;
			//check if the list of conditions are met.
			int j = 0;
			while(conditions == true && j < causes.size())
			{
				boolean gene_found = false;
				int i = 0;
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
					onditions = false;	
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
	public static String getName()
	{
		return name;
	}
	
	/**
	 * Gets the recommendations for the disease treatment.
	 * @return the recommendations for the disease treatment.
	 */
	public static String getRecommendations()
	{
		return recommendations;
	}
	
	public Disease(String name, String recommendations, List<List<Gene>> causes)
	{
		this.name = name;
		this.recommendations = recommendations;
		this.causes = causes;
	}
}
