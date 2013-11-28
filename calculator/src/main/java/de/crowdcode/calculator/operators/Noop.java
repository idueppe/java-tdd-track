package de.crowdcode.calculator.operators;

import de.crowdcode.calculator.Node;

public final class Noop implements Node
{

	private static Noop instance = new Noop();
	
	private Noop() {}
	
	public static Noop insance() 
	{
		return instance;
	}
	
	@Override
	public Double evaluate()
	{
		return Double.NaN;
	}

}
