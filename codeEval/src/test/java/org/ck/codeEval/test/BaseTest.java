package org.ck.codeEval.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class BaseTest
{
	protected final static int TIMEOUT = 10000;

	protected ByteArrayOutputStream output = null;

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
	}

	protected String[] getFileAsArgs(String name)
	{
		return new String[] { getClass().getResource(name + ".txt").getFile() };
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
