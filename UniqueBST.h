/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3


	Bugs:
		- Some duplicates
		- EXTREMELY inefficient and slow :> AND its space complexity probably isn't pretty either
*/


#include <iostream>
#include <string>
#include <vector>

struct Node
{
	int data;
	Node *left;
	Node *right;
};

class UniqueBST
{
public:
	UniqueBST();
	~UniqueBST();
	void run();

private:
	void decipherTrees(std::vector<int>, std::vector<std::vector<int>> &, int, std::vector<int>);
	
	void insertNode(int, int, bool &);
	void insertNode(int, Node *&);
	
	void createTree(std::vector<std::vector<int>>);
	
	void printTrees();
	void printTrees(Node *);

	void deleteTree(Node *&);

	std::vector<Node *> trees;
};

