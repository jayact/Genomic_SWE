package model;

import java.util.*;

public class Handler 
{
	Map<String, Gene> data;
	Map<String, Gene> selected;
	Map<String, Disease> disease;
	Map<Disease, ArrayList<ArrayList<Gene>>> results;
    
	
	public Handler(){
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
	public boolean storeData(Map<String, Gene> map){
		if(map != null){
            this.data = map;
            deselectAll();
            return true;
		}
		return false;
	}
    /**
     * Store the map into disease
     * @param map the map being stored into disease
     * @return true if the map was able to be added to disease
     */
	public boolean storeDisease (Map<String, Disease> map){
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
	public Gene getGene(String gene){
		Gene temp = data.get(gene);    
		return temp;
	}
    /**
     * Add gene to data
     * @param gene the gene being added to data
     * @return true if the gene was added successfully
     */
	public boolean setGene(Gene gene){
		if(gene != null){
			data.put(gene.getName(), gene);
			if(selected.get(gene.getName()) != null){
				selected.put(gene.getName(), gene);
			}
			return true;
		}
		return false;
	}
    /**
     * Add gene to the selected map
     * @param name the gene's name
     * @return true if was successfully added to the selected map
     */
	public boolean selectGene(String name){
		if(name != null){
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
	public boolean deselectGene(String name){
		if(name != null){
			selected.remove(name);
			return true;
		}
		return false;
	}
    /**
     * Remove all from the selected map
     * @return true if all were removed
     */
	public boolean deselectAll(){
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
	public Map<String, Gene> getData(){
		return data;
	}
    /**
     * Generates the results from the selected genes
     * @return A map containing diseases the patient has
     */
	public Map<Disease, ArrayList<ArrayList<Gene>>> getResults(){
                    
            results.clear();             
            
		for (String key : disease.keySet()) {
		    Disease temp = disease.get(key);
		    
            Set<String> names = selected.keySet();
		    
		    ArrayList<Gene> geneArray = new ArrayList<Gene>();
		    for(String string : names){
		    	geneArray.add(selected.get(string));
		    }
		    
		    if(temp.isAffected(geneArray) == true){
		    	ArrayList<ArrayList<Gene>> res_temp = temp.getAffected(geneArray);
		    	//have to readd the colors
		    	for(ArrayList<Gene> x : res_temp)
		    	{
		    		for(Gene gene_x : x)
		    		{
		    			gene_x.setUrgency(selected.get((gene_x.getName())).getUrgency());
		    		}
		    	}
                results.put(temp, temp.getAffected(geneArray));
		    }
		}
		return results;
	}
    /**
     * Gets the selected map
     * @return selected map
     */
	public Map<String, Gene> getSelected(){
		return selected;   
	}
    
	/**
	 * removes a gene from the system
	 * @param gene
	 * @return if removed.
	 */
    public boolean removeGene(String gene){
    	Gene g = data.remove(gene);
    	selected.remove(gene);
    	if(g != null){
    		return false;
    	}
    	return true;
    }
}
