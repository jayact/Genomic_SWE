package tester;
import model.Gene;
import model.Disease;
import java.util.ArrayList;

public class Disease_Tester {

	public static void main(String[] args) {
		Gene g1 = new Gene("A-Gene", "wild", "rNJx00", "w", "yellow");
		Gene g2 = new Gene("B-Gene", "present", "rNJx01", "P", "Red");
		Gene g3 = new Gene("C-Gene", "heterozygous", "rNJx03", "HE", "purple");
		
		ArrayList<Gene> deathList = new ArrayList<Gene>();
		ArrayList<Gene> sickList = new ArrayList<Gene>();
		
		
		deathList.add(g1);
		deathList.add(g2);
		sickList.add(g3);
		
		
		ArrayList<ArrayList<Gene>> deathCause = new ArrayList<ArrayList<Gene>>();
		deathCause.add(deathList);
		ArrayList<ArrayList<Gene>> sickCause = new ArrayList<ArrayList<Gene>>();
		sickCause.add(sickList);
		
		Disease death = new Disease("Death","no heart beat", "no food", "none", "underground", deathCause);
		Disease sick = new Disease("Sick","cough","lots of water","Medicine", "bed rest",sickCause);
		
		System.out.println(death + "\ngenes are caused of death");
		

	}

}
