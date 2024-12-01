package homework2month.OOP3.transports;

import homework2month.OOP3.human;
import java.util.Arrays;
import java.util.List;

public class Bicycle extends Transport {
    private final int velocity;

    // Constructor
    public Bicycle() {
        super(); // Call parent default constructor
        this.velocity = 5;
        this.allowedTerrains = Arrays.asList(TerrainType.FORREST, TerrainType.PLAIN);
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (velocity <= 0) {
            System.out.println(this + " cannot move with zero or negative velocity.");
            return false;
        }

        if (!canMoveOn(terrain)) {
            System.out.println(this + " cannot move on terrain: " + terrain);
            return false;
        }

        System.out.println((owner != null ? owner : "Unknown rider") +
                " successfully traveled " + distance + " on " + this + " over " + terrain);
        return true;
    }

    @Override
    public String toSting() {
        return "Велосипед";
    }


    @Override
    public void changeOwner(human owner) {
        this.owner = owner;
    }
}
