#include "QuickSort.h"


QuickSort::QuickSort()
{
}


QuickSort::~QuickSort()
{
}

void QuickSort::run()
{
	int *arr;
	int capture, length = 0;
	std::cout << "Enter a negative number to discontinue the loop" << std::endl << std::endl;
	for (;;)
	{
		std::cout << "Please enter a number to input to the array: ";
		std::string s;
		std::cin >> s;
		std::cout << std::endl;
		capture = std::stoi(s);
		if (capture < 0)
		{
			break;
		}
		else
		{
			length++;
			if (length == 1)
			{
				arr = new int[length];
				arr[0] = capture;
			}
			else
			{
				int *arr2 = new int[length];
				for (int i = 0; i < (length - 1); i++)
				{
					arr2[i] = arr[i];
				}
				arr2[length - 1] = capture;
				delete[] arr;
				arr = arr2;
			}
		}
	}
	std::cout << "Before Quicksort: ";
	PrintArray(arr, length);
	Sort(arr, 0, length - 1);
	std::cout << "After Quicksort: ";
	PrintArray(arr, length);
	delete[] arr;
}

/* Actually does the quicksort :) */
void QuickSort::Sort(int *arr, int i, int j) //It seems to work?
{
	if (i + 1 == j)
	{
		if (arr[i] > arr[j])
		{
			std::swap(arr[i], arr[j]);
		}
		return;
	}
	int pivot = (i + j) / 2, tempJ = j;
	for (; i < pivot; i++)
	{
		if (arr[i] > arr[pivot])
		{
			if (j == pivot)
			{
				std::swap(arr[i], arr[pivot]);
				continue;
			}
			if (arr[j] < arr[pivot])
			{
				std::swap(arr[j], arr[i]);
				j--;
			}
			else
			{
				j--;
			}
		}
	}
	for (; j >= pivot; j--)
	{
		if (arr[j] < arr[pivot])
		{
			std::swap(arr[j], arr[pivot]);
		}
	}
	Sort(arr, 0, i);
	Sort(arr, j + 1, tempJ);
}

void QuickSort::PrintArray(int *arr, int lenght)
{
	for (int i = 0; i < lenght; i++)
	{
		std::cout << arr[i] << " ";
	}
	std::cout << std::endl;
}