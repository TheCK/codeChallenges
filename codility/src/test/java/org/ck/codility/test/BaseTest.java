package org.ck.codility.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class BaseTest
{
	protected final static int TIMEOUT = 10000;

	@Rule
	public TestName testName = new TestName();
	private Long start = null;
	
	@Before
	public void setUp() throws Exception
	{
		this.start = System.currentTimeMillis();
	}
	
	@After
	public void tearDown() throws Exception
	{
		Long end = System.currentTimeMillis();
		System.err.println(getClass().getName() + "." + this.testName.getMethodName() + " took: " + (end - this.start) + " milliseconds.");
	}
}
