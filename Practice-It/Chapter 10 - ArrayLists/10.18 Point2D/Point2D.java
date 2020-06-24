public class Point2D implements Comparable<Point2D> {
    private double x;
    private double y;
    
    public Point2D() {
        this(0.0, 0.0);
    }
    
    public Point2D(double x, double y) {
        setLocation(x, y);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distance(Point2D other) {
        double xDiff = x - other.x;
        double yDiff = y - other.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

// YOUR CODE GOES HERE    
}
