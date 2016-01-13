class Wiggle:

    list = None

    def __init__(self, new_list):
        self.list = new_list
        return

    def wiggle_sort(self, size):
        switch = False
        """ We'll do GT as True and LT as False """
        for x in range(0, size - 1):
            if switch is True:
                if self.list[x] < self.list[x + 1]:
                    temp = self.list[x]
                    self.list[x] = self.list[x + 1]
                    self.list[x + 1] = temp
                switch = False
                continue
            if switch is False:
                if self.list[x] > self.list[x + 1]:
                    temp = self.list[x]
                    self.list[x] = self.list[x + 1]
                    self.list[x + 1] = temp
                switch = True
                continue
        print self.list
        return


def main():
    size = 0
    my_list = [0 for x in range(1)]
    while True:
        num = raw_input("Please enter numbers for Wiggle Sort. Type a negative to stop: ")
        num = int(num)
        if num < 0:
            break
        if size == 0:
            my_list[size] = num
            size += 1
            continue
        size += 1
        new_list = [0 for y in range(size)]
        for y in range(0, size - 1):
            new_list[y] = my_list[y]
        new_list[size - 1] = num
        my_list = new_list
    if size == 0:
        print "You did not enter anything to the list, closing program..."
    else:
        print my_list
        wiggle = Wiggle(my_list)
        wiggle.wiggle_sort(size)
    return


main()
