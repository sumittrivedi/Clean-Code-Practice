package newYearGift;

public interface Sweets 
{
	public String getName();
	public Double getWeight();
}

class KalaKand implements Sweets
{
	public String getName()
	{
		return "KalaKand";
	}
	public Double getWeight()
	{
		return 19.00;
	}
}

class KajuKatli implements Sweets
{
	public String getName()
	{
		return "KajuKatli";
	}
	public Double getWeight()
	{
		return 21.00;
	}
}
class Laddu implements Sweets
{
	public String getName()
	{
		return "Laddu";
	}
	public Double getWeight()
	{
		return 25.00;
	}
}