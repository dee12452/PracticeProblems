package Sorts;

import java.util.Random;

public class Selection_Sort 
{
	public static void main(String[] args) 
	{
		int array[] = new int[randNum(1, 15)];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = randNum(0, 100);
		}
		printArray(array);
		selectionSort(array);
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
	
	private static void selectionSort(int array[])
	{
		for(int i = 0; i < array.length; i++)
		{
			int min = i;
			for(int j = i; j < array.length; j++)
			{
				if(array[min] > array[j])
				{
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

}
