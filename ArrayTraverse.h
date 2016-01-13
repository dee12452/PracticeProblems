/*
 * 2D array traversal
 * Use a greedy algorithm to go through the array through 1's and get to the 9
 * You cannot step on 0's

 0 1 0
 1 1 0  EX: arr[0][1] -> arr[1][1] -> arr[0][0] -> arr[2][0]
 9 0 0                would be the correct path here



 BUGS!
	- Random array generation is... very buggy and makes paths too easy to calculate
	- Not printing paths properly. I got lazy and just decided a queue would work
*/

#include <string>
#include <iostream>
#include <random>
#include <queue>

class ArrayTraverse
{
public:
	ArrayTraverse();
	~ArrayTraverse();

	void run();

private:

	int randomNumber(int min, int max);
	void printArray();
	void findPath();
	void findPath(int, int, bool&);
	void printPath();
	bool hasBeen(int, int);

	int **arr;
	int length;
	int width;
	bool **boolArr;

	struct pathNode
	{
		int xPoint;
		int yPoint;
	};
	std::queue<pathNode> path;
};

