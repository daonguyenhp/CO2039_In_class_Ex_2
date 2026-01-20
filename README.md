# CO2039 - Advanced Programming: In-class Exercises (Session 2)

![C++](https://img.shields.io/badge/C++-00599C?style=for-the-badge&logo=c%2B%2B&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)

## Author Information
* **Student:** Nguyễn Đăng Gia Đạo
* **Course:** CO2039 - Advanced Programming
* **Institution:** Ho Chi Minh City University of Technology (HCMUT)

---

## Overview
This repository hosts the source code solutions for the Session 2 In-class Exercises. The primary objective is to demonstrate understanding of core Object-Oriented Programming (OOP) principles, specifically:
* Inheritance and Code Reusability.
* Polymorphism and Dynamic Binding.
* Encapsulation and Data Hiding.
* Memory Management in C++.

Implementations are provided in C++, Java, and Python to illustrate how these concepts vary across different programming languages.

---

## Exercise Summaries

### Exercise 1: Inheritance in Vehicle Classes
**Objective:** Create a base class `Vehicle` and derived classes `Car` and `Bike` to demonstrate hierarchical relationships.

**Key Features:**
* **Base Class:** `Vehicle` manages common attributes like `brand` and `year`.
* **Derived Classes:** `Car` and `Bike` extend the base functionality.
* **OOP Concepts:**
    * Constructor chaining (using `super` or member initializer lists).
    * Encapsulation via private attributes and public getters/setters.
    * Method overriding for `displayInfo()`.

### Exercise 2: Enhanced Library System
**Objective:** Implement a Library Management System capable of handling multiple types of books using polymorphism.

**Key Features:**
* **Class Structure:** A `Library` class manages a collection of `Book` objects (including subclasses `EBook` and `PrintedBook`).
* **Functionality:** Supports adding books, searching by title/author, borrowing logic, and displaying the catalog.
* **OOP Concepts:**
    * **Polymorphism:** Uses `vector<Book*>` to store mixed object types.
    * **Dynamic Binding:** Calls the correct `display()` method at runtime based on the object type.
    * **Memory Management:** Proper handling of dynamically allocated objects.

### Exercise 3: Point2D and Point3D
**Objective:** Implement spatial coordinate classes based on a specific UML class diagram.

**Key Features:**
* **Structure:** A `Point3D` class inherits from `Point2D` to extend a 2D coordinate system into 3D space.
* **Implementation:** Focuses on strict adherence to the provided class design and constructor logic.

---

## Repository Structure
* `Exercise_1/`: Source code for the Vehicle inheritance problem.
* `Exercise_2/`: Source code for the Library System.
* `Exercise_3/`: Source code for Point2D/Point3D.

## How to Run

### ☕ Java
```bash
# Compile
javac InClassExercise2/Main.java

# Run
java InClassExercise2.Main
```

### 🚀 C++
```bash
# Compile
g++ main.cpp -o main

# Run
./main
```

### 🐍 Python
```bash
python main.py
```
