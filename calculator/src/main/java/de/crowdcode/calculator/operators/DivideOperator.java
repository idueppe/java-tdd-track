package de.crowdcode.calculator.operators;

import de.crowdcode.calculator.Node;

public class DivideOperator extends Operator
{

	public DivideOperator(Node left, Node right)
	{
		super(left, right);
	}

	public Double evaluate()
	{
		return left.evaluate() / right.evaluate();
	}

	@Override
	public String toString()
	{
		return left.toString() + " / " + right.toString();
	}
	

}
