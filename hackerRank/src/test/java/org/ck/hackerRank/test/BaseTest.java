package org.ck.hackerRank.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class BaseTest
{
	protected ByteArrayOutputStream output = null;
	
	private InputStream input = null;
	
	@Rule
	public TestName testName = new TestName();
	private Long start = null;
	
	@Before
	public void setUp() throws Exception
	{
		this.output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.output));
		
		this.start = System.currentTimeMillis();
	}
	
	@After
	public void tearDown() throws Exception
	{
		Long end = System.currentTimeMillis();
		System.err.println(getClass().getName() + "." + this.testName.getMethodName() + " took: " + (end - this.start) + " milliseconds.");
		
		try
		{
			if (this.input != null)
			{
				this.input.close();
			}
		}
		catch (IOException e)
		{
			//We don't care
		}
	}
	
	protected void pipeResource(String name)
	{
		this.input = getClass().getResourceAsStream(name + ".txt");
		
		System.setIn(this.input);
	}
	
	protected static String getResult(String... restults)
	{
		StringBuilder builder = new StringBuilder();
		
		for (String result : restults)
		{
			builder.append(result + System.lineSeparator());
		}
		
		return builder.toString();
	}
}
