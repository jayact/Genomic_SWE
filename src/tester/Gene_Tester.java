package tester;
import model.Gene;

public class Gene_Tester {
	public static void main(String[] args){
		Gene g = new Gene("Simmons");		
		System.out.println("Name:" + g.getName());
		
		System.out.println("---NEW GENE---");
		Gene g2 = new Gene("A-Gene", "Heterozygous", "Red");		
		System.out.println(g2.toString());
	}
}