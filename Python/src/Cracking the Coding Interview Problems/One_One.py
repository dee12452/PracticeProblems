"""1.1 Implement an algorithm to determine if a string has all unique characters. What
if you cannot use additional data structures?"""


def all_unique_characters(string):
    hash_tab = [0 for j in range(0, 500)]
    for i in range(0, string.__len__() - 1):
        if hash_tab[ord(string[i])] == 0:
            hash_tab[ord(string[i])] = 1
        else:
            return False
    return True


def main():
    i = raw_input("Enter a string to be tested: ")
    print all_unique_characters(i)
    return


main()
