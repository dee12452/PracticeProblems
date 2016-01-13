"""
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
"""


class Times:

    times = 0

    def __init__(self, times):
        self.times = times
        return


def main():
    n = raw_input("Please enter the number of stairs: ")
    n = int(n)
    times = Times(0)
    climb_stairs(0, n, times)
    print times.times
    return times


def climb_stairs(n, stair, times):
    if n == stair:
        times.times += 1
        return
    climb_stairs(n + 1, stair, times)
    if n + 2 <= stair:
        climb_stairs(n + 2, stair, times)
    return

main()
