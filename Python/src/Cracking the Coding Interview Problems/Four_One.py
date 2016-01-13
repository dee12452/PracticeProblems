"""4.1 Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the
two subtrees of any node never differ by more than one."""
import random


class Node:

    def __init__(self):
        return

    __data = 0

    def set_data(self, data):
        self.__data = data
        return

    def get_data(self):
        return self.__data

    left = None

    right = None

    def set_right(self, right):
        self.right = right
        return

    def set_left(self, left):
        self.left = left
        return

    def get_left(self):
        return self.left

    def get_right(self):
        return self.right


class BSTree:

    def get_root(self):
        return self.__root

    __root = None

    def __init__(self):
        return

    def add_node(self, node):
        if self.__root is None:
            self.__root = node
            return True
        else:
            return self.__add_node(node, self.__root)

    def __add_node(self, node, leaf):
        if node.get_data() == leaf.get_data():
            return False
        if node.get_data() > leaf.get_data():
            if leaf.right is None:
                leaf.right = node
                return True
            else:
                return self.__add_node(node, leaf.right)
        else:
            if leaf.left is None:
                leaf.left = node
                return True
            else:
                return self.__add_node(node, leaf.left)

    def print_tree(self):
        if self.__root is None:
            print "Tree is empty"
        else:
            return self.__print_tree(self.__root)

    def __print_tree(self, leaf):
        print leaf.get_data()
        if leaf.left is not None:
            self.__print_tree(leaf.left)
        if leaf.right is not None:
            self.__print_tree(leaf.right)
        return


class Tree:
    __root = None

    def __init__(self):
        return

    def add_node(self, node):
        if self.__root is None:
            self.__root = node
            return True
        else:
            return self.__add_node(node, self.__root)

    def __add_node(self, node, leaf):
        if node.get_data() == leaf.get_data():
            return False
        if leaf.left is None:
            leaf.left = node
            return True
        if leaf.right is None:
            leaf.right = node
            return True
        i = random.randint(0, 1)
        if i == 0:
            return self.__add_node(node, leaf.left)
        else:
            return self.__add_node(node, leaf.right)

    def print_tree(self):
        if self.__root is None:
            print "Tree is empty"
        else:
            return self.__print_tree(self.__root)

    def __print_tree(self, leaf):
        print leaf.get_data()
        if leaf.left is not None:
            self.__print_tree(leaf.left)
        if leaf.right is not None:
            self.__print_tree(leaf.right)
        return

    def get_root(self):
        return self.__root


def is_binary_search_tree(tree):
    aye_lmao = tree.get_root()
    if aye_lmao is None:
        return True
    else:
        return __is_binary_search_tree(aye_lmao)


def __is_binary_search_tree(leaf):
    if leaf.left is not None:
        if leaf.left.get_data() >= leaf.get_data():
            return False
        __is_binary_search_tree(leaf.left)
    if leaf.right is not None:
        if leaf.right.get_data() <= leaf.get_data():
            return False
        __is_binary_search_tree(leaf.right)
    return True


def main():
    bs_tree = BSTree()
    i = input("Please enter a number: ")
    while i is not -1:
        node = Node()
        node.set_data(i)
        print bs_tree.add_node(node)
        i = input("Please enter a number: ")
    bs_tree.print_tree()
    tree = Tree()
    i = input("Please enter a number: ")
    while i is not -1:
        node = Node()
        node.set_data(i)
        print tree.add_node(node)
        i = input("Please enter a number: ")
    tree.print_tree()
    print is_binary_search_tree(bs_tree)
    print is_binary_search_tree(tree)

main()

