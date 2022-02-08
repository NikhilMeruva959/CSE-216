def f():
    x = 42
    def g():
        nonlocal x 
#TRY -> nonlocal x
        x=43
    #printing 42
    print("Before calling g: " + str(x))
    print("Calling g now: ")
    g()
    #printing 42 because 42 is local scope
    print("After calling g: " + str(x))

f()
global x
x=55
#printing 43 because 43 is global scope
print("x in main: " + str(x))

'''IMPORTANT: a variable
defined inside of a function is local
unless it is explicitly marked as
global.'''