package org.ck.projectEuler.solutions.problem031;

public class CoinSums
{

	private static Integer possibilities = 0;

	public static void main(String[] args)
	{
		for (int po2 = 0; po2 <= 200; po2 += 200)
		{
			for (int po1 = 0; po1 <= 200; po1 += 100)
			{
				int po2po1 = po2 + po1;

				if (po2po1 <= 200)
				{
					for (int pe50 = 0; pe50 <= 200; pe50 += 50)
					{
						int po2po1pe50 = po2po1 + pe50;

						if (po2po1pe50 <= 200)
						{
							for (int pe20 = 0; pe20 <= 200; pe20 += 20)
							{
								int po2po1pe50pe20 = po2po1pe50 + pe20;

								if (po2po1pe50pe20 <= 200)
								{
									for (int pe10 = 0; pe10 <= 200; pe10 += 10)
									{
										int po2po1pe50pe20pe10 = po2po1pe50pe20 + pe10;

										if (po2po1pe50pe20pe10 <= 200)
										{
											for (int pe5 = 0; pe5 <= 200; pe5 += 5)
											{
												int po2po1pe50pe20pe10pe5 = po2po1pe50pe20pe10 + pe5;

												if (po2po1pe50pe20pe10pe5 <= 200)
												{
													for (int pe2 = 0; pe2 <= 200; pe2 += 2)
													{
														int po2po1pe50pe20pe10pe5pe2 = po2po1pe50pe20pe10pe5 + pe2;

														if (po2po1pe50pe20pe10pe5pe2 <= 200)
														{
															for (int pe1 = 0; pe1 <= 200; ++pe1)
															{
																int sum = po2po1pe50pe20pe10pe5pe2 + pe1;
																
																if (sum == 200)
																{
																	possibilities++;
																}
																else if (sum > 200)
																{
																	break;
																}
															}
														}
														else
														{
															break;
														}
													}
												}
												else
												{
													break;
												}
											}
										}
										else
										{
											break;
										}
									}
								}
								else
								{
									break;
								}
							}
						}
						else
						{
							break;
						}
					}
				}
				else
				{
					break;
				}
			}
		}

		printResult();
	}

	private static void printResult()
	{
		System.out.println(possibilities);
	}

}
