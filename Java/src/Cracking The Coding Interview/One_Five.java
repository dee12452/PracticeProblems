package Ch1_InterviewQuestions;

import java.util.Scanner;

/*
 * 1.5 Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 */

public class One_Five {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String OneFive = in.nextLine();
		System.out.println(compressString(OneFive));
	}
	
	static String compressString(String a)
	{
		int i = 0, count = 0;
		String temp = "";
		while(i < a.length())
		{
			if(a.charAt(i) == ' ')
			{
				temp += " ";
				if(i == a.length() - 1)
				{
					break;
				}
				i++;
				continue;
			}
			char current = a.charAt(i);
			while(i != a.length() && current == a.charAt(i))
			{
				count++;
				i++;
			}
			temp += current;
			temp += count;
			count = 0;
		}
		if(a.length() < temp.length())
		{
			return a;
		}
		a = temp;
		return a;
	}
	
}
