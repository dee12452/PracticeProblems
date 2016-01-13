package Ch2_LinkedLists;

import java.util.Random;
import java.util.Scanner;

/*
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 */

public class Two_Three {

	public static void main(String[] args) 
	{
		Node head = new Node(RandomNum(0, 5));
		for(int i = 0; i < RandomNum(0, 15); i++)
		{
			Node n = new Node(RandomNum(0, 5));
			Node t = head;
			while(t.next != null)
			{
				t = t.next;
			}
			t.next = n;
			t = null;
		}
		
		printList(head);
		Node middle = getMiddleNode(head);
		deleteMiddleNode(middle);
		printList(head);
	}
	
	static void printList(Node head)
	{
		Node t = head;
		while(t != null)
		{
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println("");
	}
	
	/**********************************************
	 * 
	//doesn't work for when the list is <= 2 :(
	 * 
	 **********************************************/
	static void deleteMiddleNode(Node middle)
	{
		if(middle.next == null)
		{
			middle = middle.next;
			return;
		}
		middle.data = middle.next.data;
		middle.next = middle.next.next;
	}
	
	static Node getMiddleNode(Node head)
	{
		Node t = head;
		int count = 0;
		while(t != null)
		{
			t = t.next;
			count++;
		}
		if(count == 0)
		{
			return null;
		}
		if(count == 1)
		{
			return head;
		}
		System.out.println(count);
		count /= 2;
		t = head;
		while(count > 0)
		{
			t = t.next;
			count--;
		}
		return t;
	}
	
	static int RandomNum(int min, int max)
	{
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	
	static int tryNum(String n)
	{
		try
		{
			return Integer.parseInt(n);
		}
		catch(NumberFormatException e)
		{
			System.out.println("You did not enter a number. Defaulting to 0.");
			return 0;
		}
	}
}
