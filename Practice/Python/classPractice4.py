class Pets:
    name = "pet animals"
    
    @staticmethod
    def about():
        print("This class is about {}!".format(Pets.name))

class Dogs(Pets):
    name = "my best friend!"
    
    @staticmethod
    def about():
        print("This class is about {}!".format(Dogs.name))

class Cats(Pets):
    name = "cats"

    @staticmethod
    def about():
        print("This class is about {}!".format(Cats.name))

p = Pets()
d = Dogs()
c = Cats()
p.about() 
d.about() 
c.about() 