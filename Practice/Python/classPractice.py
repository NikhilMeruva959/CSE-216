class Person:
    def __init__(self, firstname, lastname=None):
        self.firstname = firstname
        self.lastname = lastname
    def __str__(self):
        return self.firstname + " " + self.lastname
    def __repr__(self):
        return "Person(\"" + self.firstname + "\", \"" + self.lastname + "\")"
    
p = Person("John", "Doe")
q = eval(repr(p))
print(p)
print(q)