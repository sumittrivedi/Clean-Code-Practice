package bouquet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class Main {
	
	static HashMap<Flowers, Integer> flowersCount = new HashMap<Flowers,Integer>();

	public static void main(String args[])
	{
		
		System.out.println("Select Number of flowers to create your bouquet\n"
				+ "Enter number of flower of each type sequentially\n"
				+ "1.Rose\n2.Lily\n3.Jasmine\n4.Lotus\n");
		Scanner input = new Scanner(System.in);
		flowersCount.put(new Rose(), input.nextInt());
		flowersCount.put(new Lily(), input.nextInt());
		flowersCount.put(new Jasmine(), input.nextInt());
		flowersCount.put(new Lotus(), input.nextInt());
		input.close();
		Main obj= new Main();
		System.out.println("Bouquet Cost = "+obj.bouquetCost());
		
		
	}
	public int bouquetCost()
	{
		int totalCost=0;
		Iterator itr=flowersCount.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry mapElement = (Map.Entry)itr.next(); 
			totalCost += ((Flowers)mapElement.getKey()).getCost() * (int)mapElement.getValue();
		}
		return totalCost;
	}
}
