/**********************************************************************************************
Suppose that a class Point2D has been defined for storing a 2-dimensional point with x and y
coordinates (both as doubles). The class includes the following members:

    Name                                            Description
    private double x                                the x coordinate
    private double y                                the y coordinate
    public Point2D()                                constructs the point (0, 0)
    public Point2D(double x, double y)              constructs a point with the given coordinates
    public void setLocation(double x, double y)     sets the coordinates to the given values
    public double getX()                            returns the x coordinate
    public double getY()                            returns the y coordinate
    public String toString()                        returns a String in standard "(x, y)" notation
    public double distance(Point2D other)           returns the distance from another point

Your task is to modify the class to be Comparable by adding an appropriate compareTo method.
Points should be compared relative to their distance from the origin, with points closer to the
origin considered "less" than points farther from it. The distance between two points is defined
as the square root of the sum of the squares of the differences between the x and y coordinates.
***********************************************************************************************/

public int compareTo(Point2D other) {
    Point2D origin = new Point2D();
    
    double distToThis = this.distance(origin);
    double distToOther = other.distance(origin);
    
    if (distToThis - distToOther < 0) {
        return -1;
    } else if (distToThis == distToOther) {
        return 0;
    } else {
        return 1;
    }
}
