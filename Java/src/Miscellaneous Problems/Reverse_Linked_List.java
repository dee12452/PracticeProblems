package Ch2_LinkedLists;

import java.util.Scanner;

public class Reverse_Linked_List 
{

	public static void main(String[] args) 
	{
		List list = new List();
		list.reverseListIterative();
		list.reverseListRecursive();
		list.printList();
		System.out.println("I did it! :^>");
	}

}

class List
{
	private Node2 head;
	
	public List()
	{
		head = null;
		this.addNodes();
		System.out.println("Here are the nodes in your new list: ");
		this.printList();
	}
	
	public void addNodes()
	{
		Scanner in = new Scanner(System.in);
		char data;
		while(true)
		{
			System.out.println("Please input a string. Press enter to stop: ");
			String s = in.nextLine();
			try
			{
				data = s.charAt(0);
				Node2 next = new Node2(data);
				Node2 traverse = head;
				if(head == null)
				{
					head = next;
					continue;
				}
				while(traverse.getNext() != null)
				{
					traverse = traverse.getNext();
				}
				traverse.setNext(next);
			}
			catch(java.lang.StringIndexOutOfBoundsException e)
			{
				break;
			}
		}
		in.close();
	}
	
	public void printList()
	{
		Node2 traverse = head;
		while(traverse != null)
		{
			System.out.print(traverse.getData());
			traverse = traverse.getNext();
		}
		System.out.println("");
	}
	
	public void reverseListIterative()
	{
		Node2 traverse = head;
		boolean firstNode = false;
		while(traverse != null)
		{
			if(!firstNode)
			{
				traverse = traverse.getNext();
				head.setNext(null);
				firstNode = true;
				continue;
			}
			Node2 temp = traverse.getNext();
			traverse.setNext(head);
			head = traverse;
			traverse = temp;
		}
	}
	
	public void reverseListRecursive()
	{
		this.reverseListRecursive(head, false);
	}
	
	public void reverseListRecursive(Node2 h, boolean firstTime)
	{
		if(h == null)
		{
			return;
		}
		if(!firstTime)
		{
			Node2 temp = head.getNext();
			head.setNext(null);
			this.reverseListRecursive(temp, true);
		}
		else
		{
			Node2 temp = h.getNext();
			h.setNext(head);
			head = h;
			this.reverseListRecursive(temp, firstTime);
		}
	}
}

class Node2
{
	private Node2 next;
	private char data;
	
	public Node2()
	{
		next = null;
		data = ' ';
	}
	
	public Node2(char d)
	{
		data = d;
	}
	
	public Node2 getNext()
	{
		return next;
	}
	
	public void setNext(Node2 n)
	{
		next = n;
	}
	
	public void setData(char d)
	{
		data = d;
	}
	
	public char getData()
	{
		return data;
	}
}
