package Miscellaneous_Problems;

import java.util.Scanner;

/*
 * Write an algorithm that takes a phone number and prints all combinations of that number
 */

public class Phone_Number_Problem 
{

	public static void main(String[] args) 
	{
		String number = getNumber();
		printCombinations(number, "");
		System.out.println("Done");
	}
	
	static String getNumber()
	{
		Scanner in = new Scanner(System.in);
		String ret = in.nextLine();
		in.close();
		return ret;
	}
	
	static void printCombinations(String number, String combo)
	{
		if(number.length() == 0)
		{	
			System.out.println(combo);
			return;
		}
		for(int i = 0; i < number.length(); i++)
		{
			printCombinations(removeIndex(i, number), combo + number.charAt(i));
		}
	}
	
	static String removeIndex(int i, String s)
	{
		String temp = "";
		for(int j = 0; j < s.length(); j++)
		{
			if(j == i)
			{
				continue;
			}
			temp += s.charAt(j);
		}
		return temp;
	}
}
