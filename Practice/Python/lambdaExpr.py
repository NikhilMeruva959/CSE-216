first_odd_digit = lambda n: next(int(d) for d in str(n) if (int(d) % 2) == 1)

print(first_odd_digit(135))
print(type(first_odd_digit(135)))