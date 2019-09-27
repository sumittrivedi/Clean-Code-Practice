package newYearGift;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static HashMap<Chocolates, Integer> chocoDetails = new HashMap<Chocolates, Integer>();
	static HashMap<Sweets, Integer> sweetsDetails = new HashMap<Sweets, Integer>();
	public static void main(String[] args)
	{
		System.out.println("Sequentially enter the number of particular gift items you received\n"
						+ "1.DairyMilk\n2.KitKat\n3.FiveStar\n4.KajuKatli\n5.KalaKand\n6.Laddu");
		Scanner input =new Scanner(System.in);
		chocoDetails.put(new DairyMilk(),input.nextInt());
		chocoDetails.put(new KitKat(),input.nextInt());
		chocoDetails.put(new FiveStar(),input.nextInt());
		sweetsDetails.put(new KajuKatli(),input.nextInt());
		sweetsDetails.put(new KalaKand(),input.nextInt());
		sweetsDetails.put(new Laddu(),input.nextInt());
		Main obj = new Main();
		System.out.println("Total weight of gifts = "+ obj.totalGiftWeight());
		System.out.println("Enter weight range to display gifts :");
		Double range=input.nextDouble();
		input.close();
		obj.giftRange(chocoDetails,sweetsDetails, range);
		
	}
	public double totalGiftWeight() 
	{
		Double giftWt=0.00;
		Iterator itr=chocoDetails.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry mapElement = (Map.Entry)itr.next(); 
			giftWt += ((Chocolates)mapElement.getKey()).getWeight() * (int)mapElement.getValue();
		}
		
		Iterator itr2=sweetsDetails.entrySet().iterator();
		while(itr2.hasNext())
		{
			Map.Entry mapElement1 = (Map.Entry)itr2.next(); 
			giftWt += ((Sweets)mapElement1.getKey()).getWeight() * (int)mapElement1.getValue();
		}
		return giftWt;
	}
	void giftRange(HashMap<Chocolates, Integer> choco,HashMap<Sweets, Integer> sweets, Double range)
	{
		for(Map.Entry ran: choco.entrySet())
			{
			if(((Chocolates)ran.getKey()).getWeight()<range)
			System.out.println(((Chocolates)ran.getKey()).getName()+"===>"+((Chocolates)ran.getKey()).getWeight());
			}
		for(Map.Entry ran: sweets.entrySet())
		{
			if(((Sweets)ran.getKey()).getWeight()<range)
			System.out.println(((Sweets)ran.getKey()).getName()+"===>"+((Sweets)ran.getKey()).getWeight());
		}
	}
	
}
