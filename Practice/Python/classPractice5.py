class Pets:
    name = "pet animals"

    @classmethod
    def about(cls):
        print("This class is about {}!".format(cls.name))

class Dogs(Pets):
    name = "my best friend!"

class Cats(Pets):
    name = "cats"

p = Pets()
d = Dogs()
c = Cats()
p.about() 
d.about() 
c.about() 