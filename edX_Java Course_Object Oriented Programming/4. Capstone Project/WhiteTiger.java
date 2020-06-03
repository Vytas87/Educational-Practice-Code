import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean hasInfected;

    public WhiteTiger(){
        hasInfected = false;
    }

    public Critter.Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            hasInfected = true;
            return Critter.Action.INFECT;
        } else if (info.getFront() == Critter.Neighbor.WALL || info.getRight() == Critter.Neighbor.WALL){
            return Critter.Action.LEFT;
        } else if (info.getFront() == Critter.Neighbor.SAME) {
            return Critter.Action.RIGHT;
        } else {
            return Critter.Action.HOP;
        }
    }

    public Color getColor() {
        return Color.WHITE;
    }

    public String toString() {
        if (hasInfected){
            return "TGR";
        } else {
            return "tgr";
        }
    }
}
