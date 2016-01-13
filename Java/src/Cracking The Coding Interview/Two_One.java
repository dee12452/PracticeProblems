package Ch2_LinkedLists;

import java.util.Random;

/*
 * 2.1 Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */

public class Two_One 
{

	public static void main(String[] args) 
	{
		Node head = new Node(RandomNum(0, 5));
		for(int i = 0; i < RandomNum(40, 50); i++)
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
		
		removeDuplicates(head);
		
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
	
	//EXTREMELY INEFFICIENT, SUPER NAIVE, TOO LAZY TO MAKE RIGHT
	//TO MAKE RIGHT, USE HASH TABLE OR TREE TO STORE AND COMPARE DATA
	//SHOULD END UP BEING O(nLOGn) BUT IS O(n^2) RIGHT NOW
	static void removeDuplicates(Node head)
	{
		Node t = head;
		while(t != null)
		{
			int d = t.data;
			Node loop = head;
			Node prev = loop;
			boolean once = false;
			while(loop != null)
			{
				if(loop.data == d)
				{
					if(!once)
					{
						once = true;
						prev = loop;
						loop = loop.next;
					}
					else
					{
						prev.next = loop.next;
						loop = prev.next;
					}
				}
				else
				{
					prev = loop;
					loop = loop.next;
				}
			}
			t = t.next;
		}
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

//ended up using the class defined in the book to help me solve sooner
class Node 
{
 Node next = null;
 int data;
 public Node(int d) 
 {
	 	data = d;
 }
 
 void appendToTail(int d)
 {
 
	 Node end = new Node(d);
 
	 Node n = this;
 
 while (n.next != null) 
 {
 n = n.next;
 }
 n.next = end;
 }
}
