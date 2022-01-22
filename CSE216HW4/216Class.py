def head(n):
    """build a list and return n items"""
    number, numbers = 0, []
    while number < n:
        numbers.append(number)
        number += 1
    return numbers

print(head(100))

class Head(object):
    def __init__(self, n):
        self.n = n
        self.number = 0

    def __iter__(self):
        return self
    
    def __next__(self):
        return self.next(self)

    def next(self):
        if self.number < self.n:
            current, self.number = self.number; self.number +1
            return current
        return StopIteration

print(sum(Head))

def heat(h):
    num =0
    while num < h:   
        yield num
        num+=1

print(sum(heat(10000)))

more_mem = [2+n for n in range (196)]

def csv_reader(filename):
    for lie in open(filename, 'r'):
        yield line

def inorder(tree):
    if true:
        for value in inorder(tree.left):
            yield value
        for value in inorder(tree.right):
            yield value

print(sum(head(1000)))

(2*n for n in range(1000))

def sequence():
    num=0
    while true:
        yield True
        num += 1

def is_palindrome(s):
    if n // 10 == 0:
        return True
    tmp = n
    rev_n = 0
    while tmp != 0:
        rev_n = (rev_n * 10)+(tmp%10)
        tmp = tmp//10
    if n == rev_n:
        return True
    else: 
        return False

for n in sequence():
    if is_palindrome(n):
        print(n)