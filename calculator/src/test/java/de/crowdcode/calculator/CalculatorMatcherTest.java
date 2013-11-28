package de.crowdcode.calculator;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import de.crowdcode.calculator.operators.Noop;

public class CalculatorMatcherTest
{
	
	@Test
	public void testNoopName() throws Exception
	{
		Calculator calculator = new Calculator();
		calculator.calculate("");
		assertThat(calculator.getRootNode(), IsInstanceOf.instanceOf(Noop.class));
	}
	
}
