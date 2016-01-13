package Sorts;

import java.util.Random;

public class Bubble_Sort 
{
	public static void main(String[] args) 
	{
		int array[] = new int[randNum(1, 15)];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = randNum(0, 100);
		}
		printArray(array);
		bubbleSort(array);
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
	
	private static void bubbleSort(int array[])
	{
		for(int i = 0; i < array.length; i++)
		{
			boolean didSwap = false;
			for(int j = 0; j < (array.length - i - 1); j++)
			{
				if(array[j] > array[j + 1])
				{
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					didSwap = true;
				}
			}
			if(!didSwap)
			{
				break;
			}
		}
	}
}
