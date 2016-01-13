"""Problem Statement

Kevin and Stuart want to play the 'The Minion Game'.
Bob is the match referee. Bob's task is to declare the winner and ensure that no rules are broken.
Stuart is Player 1 and Kevin is Player 2.

About Game

Rules
The game is a two player game. Players are given a string S.
Both the players have to make words using the letters of string S.
Player 1 has to make words starting with consonants.
Player 2 has to make words starting with vowels.
Game ends when both players have made all possible substrings.

Scoring
A player gets +1 Point for each occurence of the word in the string S.
Example:
If string S = BANANA
Word made by Player 2 = ANA
'ANA' is occuring twice in 'BANANA'. Hence, Player 2 will get 2 Points. """

# Has problems!??? Sometimes doesn't work, too lazy to fix


class Node:

    word = ""

    points = 1

    left = None

    right = None

    def __init__(self, a):
        self.word = a

    def set_left(self, node):
        self.left = node

    def set_right(self, node):
        self.right = node


class Tree:

    root = None

    def __init__(self):
        return

    def add_node(self, node):
        if self.root is None:
            self.root = node
            return
        return self.add_node_helper(self.root, node)

    def add_node_helper(self, leaf, node):
        if leaf.word == node.word:
            leaf.points += 1
            return
        if node.word > leaf.word:
            if leaf.right is None:
                leaf.right = node
                return
            else:
                self.add_node_helper(leaf.right, node)
        else:
            if leaf.left is None:
                leaf.left = node
                return
            else:
                self.add_node_helper(leaf.left, node)

    def add_points(self, player1, player2):
        if self.root is None:
            return
        else:
            return self.add_points_helper(player1, player2, self.root)

    def add_points_helper(self, player1, player2, leaf):
        if leaf is None:
            return
        else:
            if is_vowels(leaf.word[0]):
                player1.add_points(leaf.points)
            else:
                player2.add_points(leaf.points)
            self.add_points_helper(player1, player2, leaf.left)
            self.add_points_helper(player1, player2, leaf.right)


class Player:

    __name = ""

    __points = 0

    def __init__(self, name):
        self.__name = name
        return

    def get_name(self):
        return self.__name

    def get_points(self):
        return self.__points

    def add_points(self, points):
        self.__points += points


def is_vowels(word):
    if word == "A":
        return True
    if word == "E":
        return True
    if word == "I":
        return True
    if word == "O":
        return True
    if word == "U":
        return True
    return False


def main():
    player1 = Player("Stuart")
    player2 = Player("Kevin")
    word = raw_input()
    tree = Tree()
    play_game(player1, player2, word, tree)
    print player1.get_points()
    print player2.get_points()
    if player1.get_points() > player2.get_points():
        print "{} {}".format(player1.get_name(), player1.get_points())
        return
    if player2.get_points() > player1.get_points():
        print "{} {}".format(player2.get_name(), player2.get_points())
        return
    else:
        print "Draw"


def play_game(player1, player2, word, tree):
    for i in range(0, word.__len__()):  # iterates through each character in word
        for j in range(i, word.__len__()):  # iterates through each word per character
            words = ['' for k in range(word.__len__())]
            iterator = 0
            for l in range(j, word.__len__()):
                words[iterator] = word[l]
                iterator += 1
            s = ""
            string = s.join(words)
            node = Node(string)
            tree.add_node(node)
    tree.add_points(player1, player2)

main()
