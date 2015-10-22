package org.ck.codeEval.medium.roboandrobitta;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("5", "14"), this.output.toString());
	}

	@Test
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult("1051", "55", "5", "150", "38", "258", "23", "92", "980", "1437", "97", "303", "742",
				"12", "608", "216", "1079", "1038", "207", "1018", "47", "14", "60", "22", "400", "227", "1257", "24",
				"715", "318", "977", "102", "258", "646", "375", "87", "28", "212", "453", "1098"), this.output.toString());
	}
}
