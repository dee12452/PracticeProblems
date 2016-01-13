#include "UniqueBST.h"


UniqueBST::UniqueBST()
{
}


UniqueBST::~UniqueBST()
{
	for (int i = 0; i < trees.size(); i++)
	{
		deleteTree(trees[i]);
	}
}

void UniqueBST::deleteTree(Node *&leaf)
{
	if (leaf == NULL)
	{
		return;
	}
	deleteTree(leaf->left);
	deleteTree(leaf->right);
	delete leaf;
	leaf = NULL;
}

void UniqueBST::run()
{
	std::cout << "Please enter the number to test this program. If you enter a number less than 1, the program will close: ";
	std::string s;
	std::cin >> s;
	std::cout << std::endl;
	int n = std::stoi(s);
	if (n < 1)
	{
		std::cout << "You have entered a number too low for this program... Returning" << std::endl;
		return;
	}
	std::vector<int> arr;
	//arr.push_back(0);
	for (int i = 1; i <= n; i++)
	{
		arr.push_back(i);
	}
	std::vector<std::vector<int>> arr2;
	std::vector<int> insert;
	decipherTrees(arr, arr2, n, insert);
	createTree(arr2);
	printTrees();
}

void UniqueBST::decipherTrees(std::vector<int> arr, std::vector<std::vector<int>> &arr2, int n, std::vector<int> insert)
{
	if (n == 0)
	{
		//insert.push_back(arr[n]);
		arr2.push_back(insert);
		return;
	}
	for (int i = 0; i < n; i++)
	{
		std::vector<int> del;
		for (int j = 0; j < n; j++)
		{
			if (i != j)
			{
				del.push_back(arr[j]);
			}
		}
		insert.push_back(arr[i]);
		decipherTrees(del, arr2, n - 1, insert);
		insert.pop_back();
	}
}

void UniqueBST::createTree(std::vector<std::vector<int>> arr2)
{
	for (int i = 0; i < arr2.size(); i++)
	{
		bool firstTime = true;
		for (int j = 0; j < arr2[i].size(); j++)
		{
			insertNode(arr2[i][j], i, firstTime);
		}
	}
}

void UniqueBST::insertNode(int num, int index, bool &firstTime)
{
	if (firstTime)
	{
		Node *leaf = new Node;
		leaf->data = num;
		leaf->left = NULL;
		leaf->right = NULL;
		trees.push_back(leaf);
		firstTime = false;
	}
	else
	{
		insertNode(num, trees[index]);
	}
}

void UniqueBST::insertNode(int num, Node *&leaf)
{
	if (leaf == NULL)
	{
		leaf = new Node;
		leaf->data = num;
		leaf->left = NULL;
		leaf->right = NULL;
		return;
	}
	if (num > leaf->data)
	{
		insertNode(num, leaf->right);
	}
	else
	{
		insertNode(num, leaf->left);
	}
}

void UniqueBST::printTrees()
{
	for (int i = 0; i < trees.size(); i++)
	{
		printTrees(trees[i]);
		std::cout << std::endl;
	}
}

void UniqueBST::printTrees(Node *leaf)
{
	if (leaf == NULL)
	{
		return;
	}
	printTrees(leaf->left);
	printTrees(leaf->right);
	std::cout << leaf->data << " ";
}

