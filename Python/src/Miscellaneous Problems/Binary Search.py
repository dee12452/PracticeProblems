def main():
    find = int(raw_input())
    array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 19, 20, 100, 199, 2001, 19992]
    i = binary_search(array, find)
    print i
    return


def binary_search(array, find):
    index = (array.__len__() / 2)
    front = array.__len__()
    while array[index] != find:
        if array[index] > find:
            front = index
            index /= 2
        else:
            index = (front + index)/2
    return index

main()
