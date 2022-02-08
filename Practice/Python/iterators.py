import itertools

lt_ten = lambda x: x <= 10
for x in itertools.takewhile(lt_ten, range(20)):
    print(x)
print()
for x in itertools.dropwhile(lt_ten, range(20)):
    print(x)