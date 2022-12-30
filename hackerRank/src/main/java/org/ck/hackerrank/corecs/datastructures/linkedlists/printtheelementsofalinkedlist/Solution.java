package org.ck.hackerrank.corecs.datastructures.linkedlists.printtheelementsofalinkedlist;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 20201,
		name = "Print the Elements of a Linked List",
		url = "https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list",
		category = "Data Structures",
		subCategory = "Linked Lists"
)
public class Solution
{
	void Print(Node head)
	{
		Node node = head;

		while (node != null)
		{
			System.out.println(node.data);
			node = node.next;
		}
	}

	static class Node
	{
		int data;
		Node next;
	}
}