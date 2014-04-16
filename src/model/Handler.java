package model;

import java.util.*;

public class Handler {
    
	Map<String, Gene> data;
	Map<String, Gene> selected;
	Map<String, List<Gene>> disease;
    
	public boolean storeData(Map<String, Gene> map)
	{
		this.data = map;
		return false;
        
	}
    
	public boolean storeDisease (Map<String, List<Gene>> map)
	{
        
		this.disease = map;
		return false;
	}
	//
	public Gene getType(String gene)
	{
		Gene temp = data.get(gene);
        
		return temp;
	}
    
	public boolean setType(Gene gene)
	{
		if(gene != null)
		{
			Gene temp = data.get(gene.getName());
			temp.setName(gene.getName());
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
		selected.clear();
		return false;
	}
    
	public Map<String, Gene> getData()
	{
        
		return data;
	}
    
	public Map<String, List<Gene>> getResults()
	{
        
		return disease;
        
	}
    
	public Map<String, Gene> getSelected()
	{
        
		return selected;
        
	}
    
    
}
