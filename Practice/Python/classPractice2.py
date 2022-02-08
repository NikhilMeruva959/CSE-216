class fraction(object):
    def __init__(self, n, d):
        self.numerator, self.denominator = fraction.reduce(n, d)

    @staticmethod
    def gcd(a,b):
        while b != 0:
            print(a,b)
            print("HIII")
            a, b = b, a%b
            print("BYYWw")
            print(a,b)
            print()
        return a

    @classmethod
    def reduce(cls, n1, n2):
        g = cls.gcd(n1, n2)
        return (n1 // g, n2 // g)

    def __str__(self):
        return str(self.numerator)+'/'+str(self.denominator)

f = fraction(8,24)
print(f) # prints 1/3, not 8/24
# Note: // is for integer division in
# Python 3, and / is for floating-point
# division.