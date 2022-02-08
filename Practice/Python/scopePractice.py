def scope_test():
    def do_local():
        spam = "local spam"
    def do_nonlocal():
        nonlocal spam
        spam = "nonlocal spam"
    def do_global():
        global spam
        spam = "global spam"
    
    spam = "test spam"
    do_local()
    # test spam because test spam in local scope
    print("After local assignment:", spam) 
    do_nonlocal()
    # nonlocal spam because fucntion is not calling local anymore, its stil calling enclosing function which is not gloabl and not local
    print("After nonlocal assignment:", spam)
    do_global()
    # nonlocal spam because fucntion is not calling local anymore, its calling enclosing function which is not gloabl and not local
    print("After global assignment:", spam)

scope_test()
# global spam because fucntion is calling global, which we set in do_global()
print("In global scope:", spam)

'''IMPORTANT: a variable
defined inside of a function is local
unless it is explicitly marked as
global.'''