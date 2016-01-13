package Sorts;

import java.util.Random;

public class Insertion_Sort 
{

	public static void main(String[] args) 
	{
		int array[] = new int[randNum(1, 15)];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = randNum(0, 100);
		}
		printArray(array);
		insertionSort(array);
		printArray(array);
	}
	
	private static int randNum(int min, int max)
	{
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	
	private static void printArray(int a[])
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	private static void insertionSort(int array[])
	{
		for(int i = 0; i < array.length; i++)
		{
			if(i == 0)
			{
				continue;
			}
			int j = i;
			int temp = array[j];
			while(array[j - 1] > temp)
			{
				array[j] = array[j - 1];
				j--;
				if(j == 0)
				{
					array[j] = temp;
					break;
				}
			}
			array[j] = temp;
		}
	}
}
