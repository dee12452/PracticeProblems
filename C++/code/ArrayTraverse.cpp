#include "ArrayTraverse.h"



ArrayTraverse::ArrayTraverse()
{
	length = randomNumber(1, 19);
	width = randomNumber(1, 19);
	arr = new int*[length];
	for (int i = 0; i < length; i++)
	{
		arr[i] = new int[width];
	}
	for (int i = 0; i < length; i++)
	{
		for (int j = 0; j < width; j++)
		{
			if (i == 0 && j == 0)
			{
				arr[i][j] = 1;
				continue;
			}
			int random = randomNumber(0, 6);
			if (random < 5)
			{
				int random2 = randomNumber(0, 2);
				arr[i][j] = random2;
			}
			else
			{
				arr[i][j] = 9;
			}
		}
	}
	boolArr = new bool*[length];
	for (int j = 0; j < length; j++)
	{
		boolArr[j] = new bool[width];
	}
	for (int i = 0; i < length; i++)
	{
		for (int j = 0; j < width; j++)
		{
			boolArr[i][j] = false;
		}
	}
}

ArrayTraverse::~ArrayTraverse()
{
	for (int i = 0; i < length; i++)
	{
		delete[] arr[i];
		delete[] boolArr[i];
	}
	delete[] arr;
	delete[] boolArr;
}


void ArrayTraverse::run()
{
	printArray();
	findPath();
}


int ArrayTraverse::randomNumber(int min, int max)
{
	return min + (rand() % (int)(max - min));
}

void ArrayTraverse::printArray()
{
	for (int i = 0; i < length; i++)
	{
		for (int j = 0; j < width; j++)
		{
			std::cout << arr[i][j] << " ";
		}
		std::cout << std::endl;
	}
	std::cout << std::endl;
}

void ArrayTraverse::findPath()
{
	bool found = false;
	findPath(0, 0, found);
	printPath();
}

void ArrayTraverse::findPath(int x, int y, bool &found)
{
	pathNode insert;
	insert.xPoint = x;
	insert.yPoint = y;
	path.push(insert);

	boolArr[x][y] = true;

	if (arr[x][y] == 0)
	{
		path.pop();
		return;
	}

	if (arr[x][y] == 9)
	{
		std::cout << "Found the 9!" << std::endl;
		found = true;
		return;
	}

	if (found != true && x + 1 < length)
	{
		if(!boolArr[x + 1][y])
		findPath(x + 1, y, found);
	}
	if (found != true && y + 1 < width)
	{
		if (!boolArr[x][y + 1])
		findPath(x, y + 1, found);
	}
	if (found != true && x - 1 >= 0)
	{
		if (!boolArr[x - 1][y])
		findPath(x - 1, y, found);
	}
	if (found != true && y - 1 >= 0)
	{
		if (!boolArr[x][y - 1])
		findPath(x, y - 1, found);
	}
}

void ArrayTraverse::printPath()
{
	while (path.size() > 0)
	{
		pathNode node = path.front();
		
		if(path.size() != 1)
		std::cout << "arr[" << node.xPoint << "][" <<
			node.yPoint << "] -> ";

		else
		std::cout << "arr[" << node.xPoint << "][" <<
			node.yPoint << "]";

		path.pop();
	}
	std::cout << std::endl;
}