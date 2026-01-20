#include <iostream>
#include <string>

using namespace std;

class Vehicle {
    private:
        string brand;
        int year;
    public:
        Vehicle() : brand("Unknown"), year(0) {}
        Vehicle(string b, int y) : brand(b), year(y) {}

        string getBrand() const {return this->brand;}
        int getYear() const {return this->year;}

        void setBrand(string b) {brand = b;}
        void setYear(int y) {year = y;}

        virtual void displayInfo() {
            cout << "Brand: " << brand << ", " << "Year: " << year << endl;
        }
};

class Car : public Vehicle {
    private: 
        string model;
    public:
        Car() : Vehicle() {
            this->model = "Unknown";
        }

        Car(string b, int y, string m) : Vehicle(b, y) {
        this->model = m;
        }

        void displayInfo() override {
            cout << "Brand: " << getBrand() << ", " << "Model: " << model << ", " << "Year: " << getYear() << endl;
        }

};

class Bike : public Vehicle {
    private:
        int engineCapacity;

    public:
        Bike() : Vehicle() {
            this->engineCapacity = 0;
        }

        Bike(string b, int y, int e) : Vehicle(b, y) {
            this->engineCapacity = e;
        }

        void displayInfo() override {
            cout << "Brand: " << getBrand() << ", " << "Engine: " << engineCapacity << ", " << "Year: " << getYear() << endl;
        }  
};

int main() {
    // 1. Car Default
    cout << "--- Creating car1 (Default) ---" << endl;
    Car car1; 
    car1.displayInfo();

    // 2. Car Parameterized
    cout << "\n--- Creating car2 (Parameterized) ---" << endl;
    Car car2("Toyota", 2023, "Camry");
    car2.displayInfo();

    // 3. Bike Default
    cout << "--- Creating bike1 (Default) ---" << endl;
    Bike bike1;
    bike1.displayInfo();

    // 4. Bike Parameterized
    cout << "\n--- Creating bike2 (Parameterized) ---" << endl;
    Bike bike2("Yamaha", 2020, 150);
    bike2.displayInfo();

    return 0;
}

