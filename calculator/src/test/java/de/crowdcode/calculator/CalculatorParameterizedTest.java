package de.crowdcode.calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorParameterizedTest
{
	
	@Parameters(name= "{index}: {0} = {1}")
	public static List<Object> params()
	{
		Object[] param = new Object[][]{ //
				{1.0, "1.2 - 0.2"}, //
				{1.0, "0.7 + 0.3"},
				{0.2, "1.0 * 0.2"},
				{5.0, "1.0 / 0.2"},
				{5.0, "5.5 + 5 * 5 / 5 - 5.5"},
				{125.0, "5.5 + 5 * 5 * 5 - 5.5"}}; //
		return Arrays.asList(param);
	}
	
	private double expected;
	private String term;
	
	public CalculatorParameterizedTest(double expected, String term)
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
