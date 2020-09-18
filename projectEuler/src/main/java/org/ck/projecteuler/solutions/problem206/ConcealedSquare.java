package org.ck.projecteuler.solutions.problem206;

public class ConcealedSquare
{

	private static String pattern = "1.2.3.4.5.6.7.8.9.0";
	private static long max = 1929394959697989990L;
	private static long min = 1020304050607080900L;
	
	private static long result = 0;

	public static void main(String[] args)
	{
		int minInt = (int) Math.floor(Math.sqrt(min));
		int maxInt = (int) Math.ceil(Math.sqrt(max));
		
		for( long i = minInt; i <= maxInt; i += 10)
		{
			long sqr = i * i;
			
			if (String.valueOf(sqr).matches(pattern))
			{
				result = i;
				break;
			}
		}
		
		printResult();
	}

	private static void printResult()
	{
		System.out.println(result);
	}

}