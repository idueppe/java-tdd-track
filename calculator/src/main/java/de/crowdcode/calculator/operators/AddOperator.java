package de.crowdcode.calculator.operators;

import de.crowdcode.calculator.Node;

public class AddOperator extends Operator
{

	public AddOperator(Node left, Node right)
	{
		super(left, right);
	}

	public Double evaluate()
	{
		return left.evaluate() + right.evaluate();
	}

	@Override
	public String toString()
	{
		return left.toString() + " + " + right.toString();
	}
	
	

}
