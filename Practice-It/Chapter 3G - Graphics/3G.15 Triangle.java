/**********************************************************************************************
Using the DrawingPanel class, write a Java class named Triangle that produces the following figure:

                    size: 600x200
                    background color: yellow
                    line color: blue
                    vertical spacing between lines: 10 px

The diagonal lines connect at the bottom in the middle.
***********************************************************************************************/

public class Triangle {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel (600, 200);
        panel.setBackground(Color.YELLOW);
        Graphics g = panel.getGraphics();
        
        drawTriangle(g, 20);
    }
    
    public static void drawTriangle(Graphics g, int steps) {
        g.setColor(Color.BLUE);
        for (int i = 1; i <= steps; i++) {
            g.drawLine(15 * steps, 10 * steps, 15 * (steps - i), 10 * (steps - i));
            g.drawLine(15 * steps, 10 * steps,  15 * (steps + i), 10 * (steps - i));
            if (i < 20) {
                g.drawLine(15 * (steps - i), 10 * (steps - i),  15 * (steps + i), 10 * (steps - i));
            }
        }
    }
}
