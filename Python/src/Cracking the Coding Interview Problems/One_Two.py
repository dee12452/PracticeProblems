"""1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated
string. (Just reverse the damn string :^>)"""


def main():
    i = raw_input("Enter a string to be reversed: ")
    print i
    j = reverse_string(i)
    print j
    return


def reverse_string(string):
    j = [' ' for i in range(string.__len__())]
    for i in range(0, string.__len__()):
        j[i] = string[string.__len__() - 1 - i]
    string = ""
    string = string.join(j)
    return string

main()
