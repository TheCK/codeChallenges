package org.ck.hackerRank.algorithms.decommissioned.chocolateFeast;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int cases = in.nextInt();
			
			for (int i = 0; i < cases; ++i)
			{
				int money = in.nextInt();
				int price = in.nextInt();
				int discountAmount = in.nextInt();

				int totalChocolates = money / price;
				int wrapper = totalChocolates;
				
				while (wrapper >= discountAmount)
				{
					totalChocolates += wrapper / discountAmount;
					wrapper = (wrapper / discountAmount) + (wrapper % discountAmount);
				}
				
				System.out.println(totalChocolates);
			}
		}
	}
}