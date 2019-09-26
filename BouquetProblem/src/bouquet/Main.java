package bouquet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class Main {
	
	static HashMap<String, Integer> flowersCount = new HashMap<String,Integer>();

	public static void main(String args[])
	{
		
		System.out.println("Select Number of flowers to create your bouquet\n"
				+ "Enter number of flower of each type sequentially\n"
				+ "1.Rose\n2.Lily\n3.Lotus\n4.Jasmine\n");
		Scanner input = new Scanner(System.in);
		flowersCount.put("Rose", input.nextInt());
		flowersCount.put("Lily", input.nextInt());
		flowersCount.put("Lotus", input.nextInt());
		flowersCount.put("Jasmine", input.nextInt());
		input.close();
		Main obj= new Main();
		System.out.println("Bouquet Cost = "+obj.bouquetCost());
		
		
	}
	public int bouquetCost()
	{
		int totalCost=0;
		Iterator itr=flowersCount.entrySet().iterator();
		Flowers obj;
		while(itr.hasNext())
		{
			obj=new Rose();
			Map.Entry mapElement = (Map.Entry)itr.next(); 
			
			totalCost += obj.getCost((String)mapElement.getKey()) * (int)mapElement.getValue();
		}
		return totalCost;
	}
}
