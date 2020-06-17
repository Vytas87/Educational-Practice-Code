/**********************************************************************************************
Add the following constructor to your Line class from the preceding exercises:

                    public Line(int x1, int y1, int x2, int y2)

Constructs a new line that contains the given two points.

(You don't need to write the class header or declare the fields; assume that this is already
done for you. Just write your constructor's complete code in the box provided.) See the previous
exercises for a description of the Line class and its public members.
***********************************************************************************************/

public Line(int x1, int y1, int x2, int y2) {
    this.p1 = new Point(x1, y1);
    this.p2 = new Point(x2, y2);
}
