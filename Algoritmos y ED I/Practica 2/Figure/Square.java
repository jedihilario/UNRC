package Figure;

public class Square extends Figure {
    private double base;
    private double height;

    public Square (double w, double h) {
        this.base = w;
        this.height = h;
    }

    // Getters

    public double getBase () {
        return this.base;
    }

    public double getHeight () {
        return this.height;
    }


    public double area () {
        return this.base * this.height;
    }

    public double perimeter () {
        return 2 * this.base + 2 * this.height;
    }
}
