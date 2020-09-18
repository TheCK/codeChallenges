package org.ck.projecteuler.solutions.problem052;

import java.util.HashSet;
import java.util.Set;

import org.ck.projecteuler.lib.MyMath;

public class PermutedMultiples
{
	public static void main(String[] args)
	{
		Long i = 0L;
		
		while (true)
		{
			++i;
			String iString = i.toString();
			Set<String> digit1 = MyMath.getUniqueDigits(iString);
			
			Long i2 = 2 * i;
			String i2String = i2.toString();
			Set<String> digit2 = MyMath.getUniqueDigits(i2String);
			
			Long i3 = 3 * i;
			String i3String = i3.toString();
			Set<String> digit3 = MyMath.getUniqueDigits(i3String);
			
			Long i4 = 4 * i;
			String i4String = i4.toString();
			Set<String> digit4 = MyMath.getUniqueDigits(i4String);
			
			Long i5 = 5 * i;
			String i5String = i5.toString();
			Set<String> digit5 = MyMath.getUniqueDigits(i5String);
			
			Long i6 = 6 * i;
			String i6String = i6.toString();
			Set<String> digit6 = MyMath.getUniqueDigits(i6String);
			
			Set<String> all = new HashSet<>();
			all.addAll(digit1);
			all.addAll(digit2);
			all.addAll(digit3);
			all.addAll(digit4);
			all.addAll(digit5);
			all.addAll(digit6);
			
			if (iString.length() == i2String.length() && i2String.length() == i3String.length()
					&& i3String.length() == i4String.length() && i4String.length() == i5String.length()
					&& i5String.length() == i6String.length())
			{
				if (digit1.size() == digit2.size() && digit2.size() == digit3.size() && digit3.size() == digit4.size()
						&& digit4.size() == digit5.size() && digit5.size() == digit6.size() && digit6.size() == all.size())
				{
					System.out.println(i);
					break;
				}
			}
			
		}
	}
}