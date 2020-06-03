import java.awt.*;

public class Giant extends Critter {
    private int moveCount;

    public Giant(){
        moveCount = 0;
    }

    public Critter.Action getMove(CritterInfo info) {
        if (moveCount < 23){
            moveCount++;
        } else {
            moveCount = 0;
        }

        if (info.frontThreat()) {
            return Critter.Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        if (moveCount <6){
            return "fee";
        } else if (moveCount < 12){
            return "fie";
        } else if (moveCount < 18){
            return "foe";
        } else {
            return "fum";
        }
    }
}
