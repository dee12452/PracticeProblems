package Ch1_InterviewQuestions;

import java.util.Scanner;

/*
 * Implement a function void reverse(char* str) in C or C++ (meh Java rules) which reverses a null terminated
 * string
 * I'll do similar but just in JAVA :^>
 */

public class One_Two {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(input);
		System.out.println(reverse(input));
	}
	
	public static String reverse(String input)
	{
		char[] temp = new char[input.length()];
		for(int i= 0; i < input.length(); i++)
		{
			temp[i] = input.charAt(input.length() - i - 1);
		}
		String reversed = new String(temp);
		return reversed;
	}

}
