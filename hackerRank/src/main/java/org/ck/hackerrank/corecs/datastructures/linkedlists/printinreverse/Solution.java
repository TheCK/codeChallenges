package org.ck.hackerrank.corecs.datastructures.linkedlists.printinreverse;

@org.ck.codechallengelib.annotation.Solution(
		id = 20206,
		name = "Print in Reverse",
		url = "https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse",
		category = "Data Structures",
		subCategory = "Linked Lists"
)
public class Solution
{
	void ReversePrint(Node head)
	{
		if (head != null)
		{
			ReversePrint(head.next);
			System.out.println(head.data);
		}
	}

	static class Node
	{
		int data;
		Node next;
	}
}