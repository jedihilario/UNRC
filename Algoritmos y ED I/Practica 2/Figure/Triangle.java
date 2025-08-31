package Figure;

public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle (double s, double t, double u) {
        this.a = s;
        this.b = t;
        this.c = u;
    }

    /**
     * Implementation of Heron's formula to calculate the area with 3 sides
     * @return double Area
     */
    public double area () {
        double s = this.perimeter() / 2;
        double z = s * (s - a) * (s - b) * (s - c);

        return Math.sqrt(z);
    }

    public double perimeter () {
        return this.a + this.b + this.c;
    }
}
