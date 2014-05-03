package tester;
import model.Gene;
import model.Disease;
import java.util.ArrayList;

public class Disease_Tester {

	public static void main(String[] args) {
		Gene g1 = new Gene("A-Gene", "wild", "Red");
		Gene g2 = new Gene("B-Gene", "present", "Red");
		Gene g3 = new Gene("C-Gene", "Heterozygous", "Yellow");
		
		ArrayList<Gene> deathList = new ArrayList<Gene>();
		ArrayList<Gene> sickList = new ArrayList<Gene>();
		
		deathList.add(g1);
		deathList.add(g2);
		sickList.add(g3);
		
		ArrayList<ArrayList<Gene>> deathCause = new ArrayList<ArrayList<Gene>>();
		deathCause.add(deathList);
		ArrayList<ArrayList<Gene>> sickCause = new ArrayList<ArrayList<Gene>>();
		sickCause.add(sickList);
		
		Disease death = new Disease("Death","Get burried",deathCause);
		//Disease sick = new Disease("Sick","Medicine",sickCause);
		
		System.out.println(death + "\ngenes are caused of death");
		

	}

}
