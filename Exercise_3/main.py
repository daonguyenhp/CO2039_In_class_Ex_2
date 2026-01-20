# --- CLASS: Point2D ---
class Point2D:
    def __init__(self, x=0.0, y=0.0):
        self.__x = x  
        self.__y = y

    # Getters
    def get_x(self): return self.__x
    def get_y(self): return self.__y

    # Setters
    def set_x(self, x): self.__x = x
    def set_y(self, y): self.__y = y

    def set_xy(self, x, y):
        self.__x = x
        self.__y = y

    def get_xy(self):
        return [self.__x, self.__y] 

    def __str__(self):
        return f"({self.__x},{self.__y})"

# --- CLASS: Point3D ---
class Point3D(Point2D):
    def __init__(self, x=0.0, y=0.0, z=0.0):
        super().__init__(x, y)
        self.__z = z

    def get_z(self): return self.__z
    def set_z(self, z): self.__z = z

    def set_xyz(self, x, y, z):
        self.set_xy(x, y) 
        self.set_z(z)     

    def get_xyz(self):
        return [self.get_x(), self.get_y(), self.__z]

    def __str__(self):
        return f"({self.get_x()},{self.get_y()},{self.__z})"