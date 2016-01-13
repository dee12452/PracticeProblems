package Ch1_InterviewQuestions;

import java.util.Scanner;

/*
 * 1.3 Given two strings, write a method to decide if one is a permutation of the other.
 * Did so using a small hash table
 */

public class One_Three 
{

	
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String perm1 = in.nextLine();
		String perm2 = in.nextLine();
		System.out.println(isPermutation(perm1, perm2));
	}
	
	static boolean isPermutation(String a, String b)
	{
		String[] alphabet = new String[1000];
		initString(alphabet); //is this needed?
		int hashNum = 0;
		for(int i = 0; i < a.length(); i++)
		{
			hashNum = (int)a.charAt(i);
			alphabet[hashNum] += a.charAt(i);
		}
		for(int i = 0; i < b.length(); i++)
		{
			hashNum = (int)b.charAt(i);
			alphabet[hashNum] += b.charAt(i);
		}
		for(int i = 0; i < 100; i++)
		{
			if(alphabet[i].length() % 2 != 0)
			{
				return false;
			}
		}
		return true;
	}

	static void initString(String[] a)
	{
		for(int i = 0; i < 1000; i++)
		{
			a[i] = "";
		}
	}
}

