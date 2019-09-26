package newYearGift;

public interface Chocolates
{
	 public String getName();
	 public Double getWeight();
}
class DairyMilk implements Chocolates
{
	public String getName()
	{
		return "DairyMilk";
	}
	public Double getWeight()
	{
		return 12.00;
	}
}

class KitKat implements Chocolates
{
	public String getName()
	{
		return "KitKat";
	}
	public Double getWeight()
	{
		return 15.00;
	}
}
class FiveStar implements Chocolates
{
	public String getName()
	{
		return "FiveStar";
	}
	public Double getWeight()
	{
		return 17.00;
	}
}