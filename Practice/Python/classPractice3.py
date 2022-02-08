class Pets:
    name = "pet animals"
    
    @staticmethod
    def about():
        print("Class of {}!".format(Pets.name))

# Dogs is a child class of Pets
class Dogs(Pets):
    name = "my best friends!"

# Cats is a child class of Pets
class Cats(Pets):
    name = "cats."

p = Pets()
d = Dogs()
c = Cats()
p.about() # prints "Class of pet animals!"
d.about() # prints "Class of pet animals!"
c.about() # prints "Class of pet animals!”