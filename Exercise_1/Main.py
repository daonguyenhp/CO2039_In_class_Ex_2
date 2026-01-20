class Vehicle:
    def __init__(self, brand = "Unknown", year = 0):
        self.__brand = brand
        self.__year = year

    def getBrand(self): return self.__brand
    def getYear(self): return self.__year

    def setBrand(self, b): self.__brand = b
    def setYear(self, y): self.__year = y

    def displayInfo(self):
        print(f"Brand: {self.__brand}, Year: {self.__year}")

class Car(Vehicle):
    def __init__(self, brand="Unknown", year=0, model ="Unknown"):
        super().__init__(brand, year)
        self.__model = model

    def displayInfo(self):
        print(f"Brand: {self.getBrand()}, Model: {self.__model}, Year: {self.getYear()}")

class Bike(Vehicle):
    def __init__(self, brand="Unknown", year=0, engineCapacity=0):
        super().__init__(brand, year)
        self.__engineCapacity = engineCapacity

    def displayInfo(self):
        print(f"Brand: {self.getBrand()}, Engine: {self.__engineCapacity}cc, Year: {self.getYear()}")

# 4. Main Execution
if __name__ == "__main__":
    print("--- Creating car1 (Default) ---")
    car1 = Car() 
    car1.displayInfo()

    print("\n--- Creating car2 (Parameterized) ---")
    car2 = Car("Toyota", 2023, "Camry")
    car2.displayInfo()

    print("\n--- Creating bike1 (Default) ---")
    bike1 = Bike()
    bike1.displayInfo()

    print("\n--- Creating bike2 (Parameterized) ---")
    bike2 = Bike("Yamaha", 2020, 150)
    bike2.displayInfo()