package Figure;

public class Circle extends Figure {
    private double radius;

    public Circle (double r) {
        this.radius = r;
    }

    public double getRadius () {
        return this.radius;
    }

    public double area () {
        return Math.PI * this.radius * this.radius;
    }

    public double perimeter () {
        return 2 * Math.PI * this.radius;
    }
}
