package de.crowdcode.tdd.fitness;

import org.junit.runner.RunWith;

import com.googlecode.refit.junit.DefaultFitConfiguration;
import com.googlecode.refit.junit.FitConfiguration;
import com.googlecode.refit.junit.FitSuite;


@RunWith(FitSuite.class)
@FitConfiguration(FitnessWithRefit.Configuration.class)
public class FitnessWithRefit
{

	public static class Configuration extends DefaultFitConfiguration 
	{

		@Override
		public String[] getIncludes()
		{
			return new String[]{"**/calculator.fit.html"};
		}
		
	}
}
