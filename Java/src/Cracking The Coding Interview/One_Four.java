package Ch1_InterviewQuestions;

import java.util.Scanner;

/*
 *  Write a method to replace all spaces in a string with'%20'. You may assume that
 *  the string has sufficient space at the end of the string to hold the additional
 *  characters, and that you are given the "true" length of the string. (Note: if implementing
 *  in Java, please use a character array so that you can perform this operation
 *  in place.)
 *  EXAMPLE
 *  Input: "Mr John Smith
 *  Output: "Mr%20Dohn%20Smith"
 */

public class One_Four {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String datStringeroniPizza = in.nextLine();
		String percent = PercentSignString(datStringeroniPizza);
		System.out.println(percent);
	}

	
	static String PercentSignString(String a)
	{
		int count = 0;
		for(int i = 0; i < a.length(); i++)
		{
			if(a.charAt(i) == ' ')
			{
				count++;
			}
		}
		if(count == 0)
			return a;
		else
		{
			char[] change = new char[a.length() + (count * 3)];
			int indexForArray = 0;
			for(int i = 0; i < a.length(); i++, indexForArray++)
			{
				if(a.charAt(i) == ' ')
				{
					change[indexForArray] = '%';
					indexForArray++;
					change[indexForArray] = '2';
					indexForArray++;
					change[indexForArray] = '0';
				}
				else
				{
					change[indexForArray] = a.charAt(i);
				}
			}
			String percent = new String(change);
			return percent;
		}
	}
}
