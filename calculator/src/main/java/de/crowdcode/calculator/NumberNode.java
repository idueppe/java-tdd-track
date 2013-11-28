package de.crowdcode.calculator;

public class NumberNode implements Node
{
	private Double value;

	public NumberNode(double value)
	{
		this.value = value;
	}
	
	public Double evaluate()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
		return Double.toString(value);
	}
	
}
