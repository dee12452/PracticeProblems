"""2.4 Write code to partition a linked list around a value x, such that all nodes less than
x come before all nodes greater than or equal to x."""
"""seems inefficient but leaving as is because it works!"""


class Node:

    node_next = None

    __data = 0

    def __init__(self, num):
        self.__data = num
        return

    def add_node(self, node):
        traverse = self
        while traverse.get_next() is not None:
            traverse = traverse.get_next()
        traverse.set_next(node)
        return

    def print_node(self):
        print self.__data

    def get_next(self):
        return self.node_next

    def set_next(self, node):
        self.node_next = node

    def get_data(self):
        return self.__data

    def set_data(self, data):
        self.__data = data
        return

    def set_self(self, node):
        self.__data = node.get_data()
        self.set_next(node.get_next())
        return


def print_list(node):
    while node is not None:
        node.print_node()
        node = node.get_next()
    return


def partition_list(head, x):
    nodes_less = Node(0)
    nodes_more = Node(0)
    traverse = head
    while traverse is not None:
        node = Node(traverse.get_data())
        if node.get_data() >= x:
            nodes_more.add_node(node)
        else:
            nodes_less.add_node(node)
        traverse = traverse.get_next()
    nodes_less.set_self(nodes_less.get_next())
    traverse2 = nodes_less
    temp = traverse2
    while traverse2 is not None:
        temp = traverse2
        traverse2 = traverse2.get_next()
    temp.set_next(nodes_more.get_next())
    traverse = head
    while traverse is not None:
        traverse.set_data(nodes_less.get_data())
        traverse = traverse.get_next()
        nodes_less = nodes_less.get_next()


def main():
    node = Node(5)
    node2 = Node(3)
    node3 = Node(10)
    node4 = Node(15)
    node5 = Node(2)
    node6 = Node(6)
    node.add_node(node2)
    node.add_node(node3)
    node.add_node(node4)
    node.add_node(node5)
    node.add_node(node6)
    partition_list(node, 6)
    print_list(node)
    return


main()
