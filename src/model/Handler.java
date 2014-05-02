package model;

import java.util.*;

public class Handler 
{
	Map<String, Gene> data;
	Map<String, Gene> selected;
	Map<String, Disease> disease;
	Map<Disease, ArrayList<ArrayList<Gene>>> results;
    
	
	public Handler()
	{
		data = new HashMap<String, Gene>();
		selected = new HashMap<String, Gene>();
		disease = new HashMap<String, Disease>();
		results = new HashMap<Disease, ArrayList<ArrayList<Gene>>>();
	}
	
	/**
	 * Store the map into data
	 * @param map the map being stored into data
	 * @return true if the map was able to be added to data
	 */
	public boolean storeData(Map<String, Gene> map)
	{
		if(map != null){
			
            this.data = map;
            return true;
		}
		return false;
	}
    /**
     * Store the map into disease
     * @param map the map being stored into disease
     * @return true if the map was able to be added to disease
     */
	public boolean storeDisease (Map<String, Disease> map)
	{
		if(map != null){
            this.disease = map;
            return true;
		}
		return false;
	}
	/**
	 * Get the request gene from data
	 * @param gene the name of the gene
	 * @return gene that is associated with that name
	 */
	public Gene getGene(String gene)
	{
		Gene temp = data.get(gene);    
		return temp;
	}
    /**
     * Add gene to data
     * @param gene the gene being added to data
     * @return true if the gene was added successfully
     */
	public boolean setGene(Gene gene)
	{
		if(gene != null)
		{
			data.put(gene.getName(), gene);
			return true;
		}
        
		return false;
	}
    /**
     * Add gene to the selected map
     * @param name the gene's name
     * @return true if was successfully added to the selected map
     */
	public boolean selectGene(String name)
	{
		if(name != null)
		{
			Gene temp = data.get(name);
			selected.put(name, temp);
			return true;
		}
        
		return false;
	}
    /**
     * Remove gene from selected map
     * @param name the gene's name
     * @return true if successfully removed
     */
	public boolean deselectGene(String name)
	{
        
		if(name != null)
		{
			selected.remove(name);
			return true;
		}
        
		return false;
	}
    /**
     * Remove all from the selected map
     * @return true if all were removed
     */
	public boolean deselectAll()
	{
		if(selected != null){
			
            selected.clear();
            return true;
            
		}
		return false;
	}
    /**
     * Gets the data map
     * @return the data map
     */
	public Map<String, Gene> getData()
	{
		return data;
	}
    /**
     * Generates the results from the selected genes
     * @return A map containing diseases the patient has
     */
	public Map<Disease, ArrayList<ArrayList<Gene>>> getResults()
	{
		for (String key : disease.keySet()) {
		    Disease temp = disease.get(key);
		    
            Set<String> names = selected.keySet();
		    
		    ArrayList<Gene> geneArray = new ArrayList<Gene>();
		    for(String string : names){
		    	geneArray.add(selected.get(string));
		    }
		    
		    if(Disease.isAffected(geneArray) == true){
		    	
                results.put(temp, Disease.getAffected(geneArray));
		    }
		}
		
		return results;
	}
    /**
     * Gets the selected map
     * @return selected map
     */
	public Map<String, Gene> getSelected()
	{
		return selected;   
	}
    
    
}
