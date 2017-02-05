package org.ck.codeChallengeLib.testhelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.*;
import java.util.Scanner;

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

	protected String getFileAsResult(String name)
	{
		File resultFile = new File(getClass().getResource(name + ".result.txt").getFile());

		StringBuilder builder = new StringBuilder();
		try (Scanner resultScanner = new Scanner(resultFile))
		{
			while (resultScanner.hasNextLine())
			{
				builder.append(resultScanner.nextLine()).append(System.lineSeparator());
			}
		}
		catch (FileNotFoundException e)
		{
		}

		return builder.toString();
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
