/**********************************************************************************************
Modify your ShowDesign class from the previous exercise into a new class ShowDesign2 that has a
method named showDesign that accepts parameters for the window width and height and displays the
rectangles at the appropriate sizes.

(You don't need to include any import statements at the top of your program.)
***********************************************************************************************/

public class ShowDesign2 {
    public static void main(String[] args) {
        showDesign(300, 100);
    }
    
    public static void showDesign(int w, int h) {
        DrawingPanel panel = new DrawingPanel(w, h);
        Graphics g = panel.getGraphics();
        
        for (int i = 1; i <= 4; i++) {
            drawRectangles(g, w, h, w / 10 * i, h / 10 * i);
        }
    }
    
    public static void drawRectangles(Graphics g, int w, int h, int x, int y) {
        g.drawRect(w / 2 - x, h / 2 - y, 2 * x, 2 * y);
    }
}
