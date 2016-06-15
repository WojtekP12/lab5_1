package edu.iis.mto.multithread;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.internal.util.Decamelizer;

public class RepeatRule implements TestRule
{

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface Repeat
	{
		public abstract int times();
	}
	
	private static class RepeatStatement extends Statement
	{

		private final int times;
		private final Statement statment;
		
		public RepeatStatement(int times, Statement statment) {
			super();
			this.times = times;
			this.statment = statment;
		}	
		
		@Override
		public void evaluate() throws Throwable {
			for(int i=0;i<times;i++)
			{
				statment.evaluate();
			}
			
		}
		
	}
	
	
	@Override
	public Statement apply(Statement statement, Description description)
	{
		Statement result = statement;
		Repeat repeat = description.getAnnotation(Repeat.class);
		if(repeat != null)
		{
			int times = repeat.times();
			result = new RepeatStatement(times, statement);
		}
		return result;
	}
	
}
