package tester;
import model.Gene;

public class Gene_Tester {
	public static void main(String[] args){
<<<<<<< HEAD
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
=======
		Gene g1 = new Gene("First", "<VARIANT>", "RS 1");
		Gene g2 = new Gene("Second", "<VARIANT>", "RS 2", "homozygous", "purple");
		
		printGenes(g1, g2);
		
		g1.setName("Still First");
		g1.setRSNumber("RS 11");
		g1.setVariant("<NEW VAR>");
		g1.setType("wild");
		g1.setUrgency("red");
		
		g2.setName("Still Second");
		g2.setRSNumber("RS 21");
		g2.setVariant("<VAR 2>");
		g2.setType("absent");
		g2.setUrgency("green");
		
		printGenes(g1, g2);
	}
	
	static void printGenes(Gene g1, Gene g2){
		System.out.println(g1.toString());
>>>>>>> b84b4d80e7aaa6f846c8634e0721b02787147d13
		System.out.println(g2.toString());
		
	}
}