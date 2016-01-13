"""1.5 Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string."""


def main():
    s = raw_input("Please input a string to be compressed: ")
    s = compress_string(s)
    print s
    return


def compress_string(s):
    s_array = ['' for a in range(0, s.__len__())]
    hash_table = [0 for b in range(0, s.__len__())]
    count = 1
    index = 0
    temp = s[0]
    # write logic to get number of chars each
    for j in range(0, s.__len__()):
        if temp == s[j]:
            hash_table[index] += 1
            count += 1
            continue
        else:
            hash_table[index] = count
            index += 1
            count = 1
            temp = s[j]
    count = 0
    index = 0
    while count < s.__len__():
        s_array[index] = s[count]
        index += 1
        s_array[index] = str(hash_table[index - 1])
        index += 1
        count += hash_table[index - 2]
        print hash_table[index - 2]
    j = ""
    j = j.join(s_array)
    if j.__len__() >= s.__len__():
        return s
    else:
        return j


main()
