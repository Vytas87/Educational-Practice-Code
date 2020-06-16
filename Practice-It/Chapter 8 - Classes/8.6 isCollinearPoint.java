/**********************************************************************************************
Add the following method to the Point class:

                    public boolean isCollinear(Point p1, Point p2)
                    
Returns whether this Point is collinear with the given two other points. Points are collinear if
a straight line can be drawn that connects them. Two basic examples are three points that have
the same x- or y-coordinate. The more general case can be determined by calculating the slope of
the line between each pair of points and checking whether this slope is the same for all pairs
of points. Use the formula (y2 - y1) / (x2 - x1) to determine the slope between two points
(x1, y1) and (x2, y2). (Note that this formula fails for points with identical x-coordinates so
this will have to be special-cased in your code.)

Since Java's double type is imprecise, round all slope values to a reasonable accuracy such as
four digits past the decimal point before you compare them.

                    public class Point {
                        private int x;
                        private int y;

                        // // your code goes here

                    }

***********************************************************************************************/

public boolean isCollinear(Point p1, Point p2) {
    if (this.x == p1.x && this.x == p2.x) {
        return true;
    } else {
        double slope1 = Math.round(10000.0 * (p1.y - this.y) / (p1.x - this.x)) / 10000;
        double slope2 = Math.round(10000.0 * (p2.y - this.y) / (p2.x - this.x)) / 10000;
        return slope1 == slope2;
    }
}
