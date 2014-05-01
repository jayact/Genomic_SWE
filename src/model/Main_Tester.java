package model;

import java.util.Map;

public class Main_Tester 
{
	static Handler handler;
	public static void main(String[] args)
	{
		handler = new Handler();
		System.out.println("Test 1: testing addition of genes");
		Gene test1 = new Gene("gene1", "heterozygous", "green");
		handler.setGene(test1);
		Gene result1 = handler.getGene(test1.getName());
		if(result1.equals(test1))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		System.out.println("Test 2: testing setting of gene types");
		test1.setType("wild");
		handler.setGene(test1);
		result1 = handler.getGene(test1.getName());
		if(result1.equals(test1))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		System.out.println("Test 3: testing gene selections");
		boolean t = handler.selectGene(test1.getName());
		Map<String, Gene> sel = handler.getSelected();
		result1 = sel.get(test1.getName());
		if(result1.equals(test1) && t == true)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		System.out.println("Test 4: testing improper selections");
		test1.setName("bille");
		handler.setGene(test1);
		result1 = handler.getGene(test1.getName());
		if(result1.equals(test1))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
	}
}
