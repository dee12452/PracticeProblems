package Ch1_InterviewQuestions;

import java.util.Scanner;
import java.util.Random;

/*
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 */

public class One_Seven 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String first = in.nextLine();
		int fir = tryNum(first);
		String second = in.nextLine();
		int sec = tryNum(second);
		int[][] matrix = new int[fir][sec];
		CreateMatrix(fir, sec, matrix);
		printMatrix(fir, sec, matrix);
		makeZeros(fir, sec, matrix);
		printMatrix(fir, sec, matrix);
	}
	
	static void CreateMatrix(int f, int n, int[][] matrix)
	{
		Random rand = new Random();
		for(int i = 0; i < f; i++)
		{
			for(int j = 0; j < n; j++)
			{
				matrix[i][j] = rand.nextInt(9 - 0 + 1) + 0;
			}
		}
	}
	
	static int tryNum(String n)
	{
		try
		{
			return Integer.parseInt(n);
		}
		catch(NumberFormatException e)
		{
			System.out.println("You did not enter a number. Defaulting to 1.");
			return 1;
		}
	}
	
	static void printMatrix(int f, int s, int[][] matrix)
	{
		System.out.println("");
		for(int i = 0; i < f; i++)
		{
			for(int j = 0; j < s; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
		}
	}
	
	static void makeZeros(int f, int n, int[][] matrix)
	{
		int[] arr = new int[f];
		for(int i = 0; i < f; i++)
		{
			arr[i] = -1;
		}
		for(int i = 0; i < f; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(matrix[i][j] == 0)
				{
					arr[i] = j;    
				}
			}
		}
		makeZeros(f, n, matrix, arr);
	}
	
	static void makeZeros(int f, int n, int[][] matrix, int[] arr)
	{
		for(int i = 0; i < f; i++)
		{
			if(arr[i] != -1)
			{
				for(int j = 0; j < n; j++)
				{
					matrix[i][j] = 0;
				}
				for(int j = 0; j < f; j++)
				{
					matrix[j][arr[i]] = 0;
				}
			}
		}
	}
}