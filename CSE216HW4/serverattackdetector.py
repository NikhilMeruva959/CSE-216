import csv

class ServerAttackDetector:
    
    def __init__(self, path):
        self._d = path

    def display(self):
        print(self._d)

    def detect(self):
        reader = csv.reader(open(self._d),delimiter=',')
        filtered = filter(lambda p: 'UDP' == p[2] and 'suspicious' == p[12] and p[1] < .001, reader)
        print(filtered)
        #csv.writer(open(self._d,'r'),delimiter=' ').writerows(filtered)

        #strippedLine = (line.strip() for line in open(self._d).readline() if line != " ")

        

obj = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/hw4testfile.csv")
obj.display()
print("--------------")
obj.detect()
