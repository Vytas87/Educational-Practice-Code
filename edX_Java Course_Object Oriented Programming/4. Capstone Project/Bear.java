import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int moveCount = 0;

    public Bear(boolean b){
        if (b){
            polar = true;
        } else {
            polar = false;
        }
    }

    public Action getMove(CritterInfo info) {
        moveCount++;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        if (polar == true)
            return Color.WHITE;
        else {
            return Color.BLACK;
        }
    }

    public String toString() {
        if (moveCount%2 == 0){
            return "/";
        } else{
            return "\\";
        }
    }
}
