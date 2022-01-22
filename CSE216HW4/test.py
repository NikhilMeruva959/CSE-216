from serverattackdetector import ServerAttackDetector

d = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/kaggle-serverlogs/CIDDS-001-external-week1.csv")
#d = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/hw4testfile.csv")

a, b = d.detect()
print(a)  # to verify whether your code is, indeed, performing lazy evaluation
print(b)  # to verify whether your code is, indeed, able to detect the first
          # instance of a potential attack

