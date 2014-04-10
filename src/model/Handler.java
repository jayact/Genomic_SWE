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
    
    public boolean storeDisease (Map<String, List<Gene>> map){
        
        this.disease = map;
        return false;
    }
    //
    public Gene getType(String gene){
        Gene temp = data.get(gene);
        
        return temp;
    }
    
    public boolean setType(Gene gene){
        
        
        return false;
    }
    
    public boolean selectGene(String name){
        
        return false;
    }
    
    public boolean deselectGene(String name){
        
        return false;
    }
    
    public boolean deselectAll(){
        
        return false;
    }
    
    public Map<String, Gene> getData(){
        return data;
        
    }
    
    public Map<String, List<Gene>> getResults(){
        
        
        return disease;
        
    }
    
    public Map<String, Gene> getSelected(){
        
        
        return data;
        
    }
    
    
}
