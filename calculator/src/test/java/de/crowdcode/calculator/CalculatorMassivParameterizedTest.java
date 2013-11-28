package de.crowdcode.calculator;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorMassivParameterizedTest
{
	private static final int REPEATS = 150;
	private static final String[] OPERATORS = new String[]{"+", "-", "*","/"};
	
	@Parameters(name= "{index}: {0} = {1}")
	public static List<Object[]> params()
	{
		List<Object[]> params = new LinkedList<>();
		
		for (String operator : OPERATORS)
		{
			String term = "1.0 ";
			double expected = 1.0;
			for (int i=1; i< REPEATS; i++)
			{
				expected = increase(operator, expected, i); 
				term += " "+operator+" "+i;
				params.add(new Object[]{expected,term});
			}
			
		}
		return params;
	}
	
	private static double increase(String operator, double expected, double number)
	{
		switch (operator)
		{
			case "+": return expected + number; 
			case "*": return expected * number; 
			case "/": return expected / number; 
			case "-": return expected - number; 
		}
		return expected;
	}

	private double expected;
	private String term;
	
	public CalculatorMassivParameterizedTest(double expected, String term)
	{
		this.expected = expected;
		this.term = term;
	}
	
	@Test
	public void testCalculation()
	{
		assertEquals(expected, new Calculator().calculate(term), 0.0);
	}
	
	
}
