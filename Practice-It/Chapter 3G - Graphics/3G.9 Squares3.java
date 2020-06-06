/**********************************************************************************************
Modify your Squares2 program from the previous exercise into a new class Squares3 that draws
the following figures. (Go back to that problem and copy/paste your code here as a starting
point.) Parameterize your program so that the figures have the sizes shown below. The top-right
figure has size 50, and the bottom-right figure has size 180.
***********************************************************************************************/

public class Squares3 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 300);
        panel.setBackground(Color.CYAN);
        Graphics g = panel.getGraphics();
        
        drawSquares(g,100, 50, 50);
        drawSquares(g, 50, 250, 10);
        drawSquares(g, 180, 180, 115);
    }
    
    public static void drawSquares(Graphics g,int size, int x, int y) {        
        for (int i = 1; i <= 5; i++) {
            g.setColor(Color.RED);
            g.drawRect(x, y, size / 5 * i, size / 5 * i);
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + size / 5 * i, y + size / 5 * i);
        }
    }    
}
