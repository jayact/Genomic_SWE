package tester;
import model.Gene;

public class Gene_Tester {
	public static void main(String[] args){
		System.out.println("---GENE ONE---");
		Gene g = new Gene("A-Gene");		
		System.out.println("Name:" + g.getName() + "\n");
		
		System.out.println("---GENE TWO---");
		Gene g2 = new Gene("B-Gene", "Heterozygous", "rNJx01", "HE", "Red");		
		System.out.println("Name: " + g2.getName() + "\n");
		
		//CHANGES TO GENES
		g.setRsNumber("rNJx00");
		g.setUrgency("purple");
		g.setAbbreviation("w");
		g2.setType("wild");
		
		System.out.println("---ALL GENES PRINT---");
		System.out.println(g.toString());
		System.out.println(g2.toString());
		
	}
}