package tester;
import model.Gene;

public class Gene_Tester {
	public static void main(String[] args){
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
	
	private static void printGenes(Gene g1, Gene g2){
		System.out.println(g1.toString());
		System.out.println(g2.toString());
	}
}