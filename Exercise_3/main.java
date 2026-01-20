package Exercise_3;

class Point2D {
    private float x;
    private float y;

    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Getters & Setters
    public float getX() { return x; }
    public float getY() { return y; }

    public void setX(float x) { this.x = x; } 
    public void setY(float y) { this.y = y; }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{x, y};
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

// --- CLASS: Point3D ---
class Point3D extends Point2D {
    private float z;

    public Point3D() {
        super(0.0f, 0.0f); // Gọi constructor cha
        this.z = 0.0f;
    }

    public Point3D(float x, float y, float z) {
        super(x, y); 
        this.z = z;
    }

    // Getters & Setters
    public float getZ() { return z; }
    public void setZ(float z) { this.z = z; }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y); 
        setZ(z);    
    }

    public float[] getXYZ() {
        return new float[]{getX(), getY(), z};
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}

public class main {
    
}
