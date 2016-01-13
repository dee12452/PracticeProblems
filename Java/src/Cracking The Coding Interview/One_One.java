package Ch1_InterviewQuestions;

import java.util.Scanner;

/*
    1.1 Implement an algorithm to determine if a string has all unique characters. What
	if you cannot use additional data structures?
 */

public class One_One 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(hasUniqueCharacters(input));
	}
	
	private static boolean hasUniqueCharacters(String input)
	{
		char a, b;
		for(int i = 0; i < input.length(); i++)
		{
			for(int j = 0; j < input.length(); j++)
			{
				if(j != i)
				{
					a = input.charAt(i);
					b = input.charAt(j);
					if(a == b)
					{
						return false;
					}
				}
				else
				{
					continue;
				}
			}
		}
		return true;
	}
}

//VERY inefficient, as the worst case is O(n^2). Needs to be an easier way just am not sure right now
