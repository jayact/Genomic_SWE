package model;

import java.util.*;
import java.util.Map.Entry;

public class Handler {
    
	Map<String, Gene> data;
	Map<String, Gene> selected;
	Map<String, Disease> disease;
	Map<Disease, ArrayList<ArrayList<Gene>>> results;
    
	public boolean storeData(Map<String, Gene> map)
	{
		if(map != null){
			
            this.data = map;
            return true;
            
		}
		return false;
	}
    
	public boolean storeDisease (Map<String, Disease> map)
	{
		if(map != null){
            this.disease = map;
            return true;
		}
		return false;
	}
	/**
	 * 
	 * @param gene
	 * @return
	 */
	public Gene getGene(String gene)
	{
		Gene temp = data.get(gene);
        
		return temp;
		
		
	}
    
	public boolean setGene(Gene gene)
	{
		if(gene != null)
		{
			data.put(gene.getName(), gene);
			return true;
		}
        
		return false;
	}
    
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
    
	public boolean deselectGene(String name)
	{
        
		if(name != null)
		{
			selected.remove(name);
			return true;
		}
        
		return false;
	}
    
	public boolean deselectAll()
	{
		if(selected != null){
			
            selected.clear();
            return true;
            
		}
		return false;
	}
    
	public Map<String, Gene> getData()
	{
        
		return data;
	}
    
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
    
	public Map<String, Gene> getSelected()
	{
        
		return selected;
        
	}
    
    
}
