package org.ck.hackerrank.corecs.datastructures.linkedlists.comparetwolinkedlists;

@org.ck.codechallengelib.annotation.Solution(
		id = 20208,
		name = "Compare two linked lists",
		url = "https://www.hackerrank.com/challenges/compare-two-linked-lists",
		category = "Data Structures",
		subCategory = "Linked Lists"
)
public class Solution
{
	int CompareLists(Node headA, Node headB)
	{
		Node currentA = headA;
		Node currentB = headB;
		while (currentA != null && currentB != null)
		{
			if (currentA.data != currentB.data)
			{
				return 0;
			}

			currentA = currentA.next;
			currentB = currentB.next;
		}

		if (currentA != null || currentB != null)
		{
			return 0;
		}

		return 1;
	}

	static class Node
	{
		int data;
		Node next;
	}
}