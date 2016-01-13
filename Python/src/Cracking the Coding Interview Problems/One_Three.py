"""1.3 Given two strings, write a method to decide if one is a permutation of the other."""


def main():
    s1 = raw_input("Please Enter A String: ")
    s2 = raw_input("Enter another to see if it is permutation of the first string: ")
    print is_permutation(s1, s2)
    return


def is_permutation(s1, s2):
    # do this by hash tables? AW YEAH BABY
    hash_table1 = [0 for j in range(500)]
    hash_table2 = [0 for j in range(500)]
    for a in range(0, s1.__len__()):
        hash_table1[ord(s1[a])] += 1
    for b in range(0, s2.__len__()):
        hash_table2[ord(s2[b])] += 1
    for c in range(0, 500):
        if hash_table1[c] != hash_table2[c]:
            return False
    return True

main()
