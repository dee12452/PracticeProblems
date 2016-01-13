package Ch1_InterviewQuestions;

import java.util.Scanner;
import java.util.Random;

/*
 * 1.6 Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 */



public class One_Six {

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
		int[][] a = rotateClockwise90DegreesClockwise(fir, sec, matrix);
		printMatrix(sec, fir, a);
	}
	
	static void CreateMatrix(int f, int n, int[][] spiral)
	{
		Random rand = new Random();
		for(int i = 0; i < f; i++)
		{
			for(int j = 0; j < n; j++)
			{
				spiral[i][j] = rand.nextInt(9 - 0 + 1) + 0;
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
	
	//NOT WORKING YET
	static int[][] rotateClockwise90DegreesCounterclockwise(int x, int y, int[][] a)
	{
		int[][] b = new int[y][x];
		x--; y--;
		for(int i = 0; i <= x; i++)
		{
			for(int j = 0; j <= y; j++)
			{
				if(x - j >= 0)
				{
					b[x - j][i] = a[i][j];
				}
			}
		}
		return b;
	}
	
	static int[][] rotateClockwise90DegreesClockwise(int x, int y, int[][] a)
	{
		int[][] b = new int[y][x];
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				b[j][x - i - 1] = a[i][j];
			}
		}
		return b;
	}
	

}