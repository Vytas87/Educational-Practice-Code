import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int moveCount;
    private Color color;

    public Tiger(){
        moveCount = 0;
        color = null;
    }

    public Action getMove(CritterInfo info) {
        moveCount++;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        Random r = new Random();
        if (moveCount%3 == 0) {
            int n = r.nextInt(3);
            switch (n) {
                case 0:
                    color = Color.RED;
                    break;
                case 1:
                    color = Color.GREEN;
                    break;
                case 2:
                    color = Color.BLUE;
                    break;
            }
        }
        return color;
    }

    public String toString() {
        return "TGR";
    }
}
