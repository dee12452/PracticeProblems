package Ch2_LinkedLists;

import java.util.Random;
import java.util.Scanner;

/*
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class Two_Two 
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
		System.out.println("Enter k, the number we will use to find the kth last element of the list");
		Scanner in = new Scanner(System.in);
		int j = tryNum(in.nextLine());
		System.out.println(dataFromBack(j , head));
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
	
	static int dataFromBack(int k, Node head)
	{
		if(k < 0)
		{
			System.out.println("Number entered is negative. Not possible. Returning -1");
			return -1;
		}
		Node t = head;
		int count = 0;
		while(t != null)
		{
			t = t.next;
			count++;
		}
		if(k > count)
		{
			System.out.print("The list is " + count + " long. The list");
			System.out.println(" is too short to handle this request. Returning -1");
			return -1;
		}
		else
		{
			t = head;
			for(int i = 0; i < count - k - 1; i++)
			{
				t = t.next;
			}
			return t.data;
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
/*
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
*/