"""Fibonacci Sequence

The Fibonacci Sequence is the series of numbers:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

The next number is found by adding up the two numbers before it.

The 2 is found by adding the two numbers before it (1+1)
Similarly, the 3 is found by adding the two numbers before it (1+2),
And the 5 is (2+3),
and so on!
Example: the next number in the sequence above is 21+34 = 55

It is that simple!

Here is a longer list:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, ...
Can you figure out the next few numbers?"""


def main():
    i = input("Please input the nth number of fibonacci you want to find: ")
    while i != -1:
        print fibonacci_finder(i)
        i = input("Please input the nth number of fibonacci you want to find: ")
    return


def fibonacci_finder(num):
    if num <= 0:
        return 0
    if num == 1:
        return 1
    return fibonacci_finder(num - 1) + fibonacci_finder(num - 2)


main()

