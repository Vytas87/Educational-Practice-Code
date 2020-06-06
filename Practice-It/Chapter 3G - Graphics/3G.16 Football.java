/**********************************************************************************************
Using the DrawingPanel class, write a Java class named Football that produces the following figure:

Though the figure looks to contain curves, it is made entirely of straight lines. The window is
250 x 250 pixels in size, and there is an outer rectangle from (10, 30) to (210, 230). A set of
black lines are drawn around the edges every 10 pixels. For example, along the top-left, there
is a line from (10, 220) to (20, 30), a line from (10, 210) to (30, 30), a line from (10, 200)
to (40, 30), ... and so on. Along the bottom-right, there is a line from (20, 230) to (210, 220),
a line from (30, 230) to (210, 210), and so on.
***********************************************************************************************/

public class Football {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(250, 250);
        Graphics g = panel.getGraphics();
        
        drawFootball(g, 200, 10, 30);
    }
    
    public static void drawFootball(Graphics g, int size, int x, int y) {
        for (int i = 0; i <= size/10; i++) {
            g.drawLine(x, y + size - 10 * i, x + 10 * i, y);
        }
        for (int i = 0; i <= size/10; i++) {
            g.drawLine(x + 10 * i, y + size, x + size, y + size - 10 * i);
        }
    }
}
