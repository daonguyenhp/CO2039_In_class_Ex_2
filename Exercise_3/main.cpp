#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;


class Point2D {
    private:
        float x;
        float y;

    public:
        Point2D() : x(0.0f), y(0.0f) {}
        Point2D(float x, float y) : x(x), y(y) {}

        float getX() {return x;}
        float getY() {return y;}
        void setX(float x) {this->x = x;}
        void setY(float y) {this->y = y;}
        void setXY(float x, float y) {this->x = x; this->y = y;}
        vector<float> getXY() {return {x, y};}

        virtual string toString() {
            stringstream ss;
            ss << "(" << x << "," << y << ")";
            return ss.str();
        }
};

class Point3D : public Point2D {
    private:
        float z;
    public: 
        Point3D() : Point2D(0.0f, 0.0f), z(0.0f) {}
        Point3D(float x, float y, float z) : Point2D(x, y), z(z) {}
        float getZ() {return z;}
        void setZ(float z) {this->z= z;}
        void setXYZ(float x, float y, float z) {
            setXY(x, y);
            setZ(z);
        } 

        vector<float> getXYZ() {return {getX(), getY(), z};}
        string toString() override {
            stringstream ss;
            ss <<  "(" <<  getX() << ","  << getY() << "," << z << ")";
            return ss.str();
        }
};