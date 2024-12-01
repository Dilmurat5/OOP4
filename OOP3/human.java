package homework2month.OOP3;

import homework2month.OOP3.transports.Transport;
import java.util.Arrays;
import java.util.List;

public class human implements Moving {
    private final float max_fuel = 700;
    private float stamina;
    private final float stamina_per_second = 2.5f;
    private final int velocity;
    private final String name;
    private Transport currentTransport;
    private final List<TerrainType> allowedTerrains;

    public human(String name) {
        this.name = name;
        this.stamina = max_fuel;
        this.velocity = 1;
        this.allowedTerrains = Arrays.asList(TerrainType.FORREST, TerrainType.SWAMP, TerrainType.PLAIN);
    }

    @Override
    public String toString() {
        return name;
    }

    public void takeTransport(Transport transport) {
        if (currentTransport != null) {
            currentTransport.changeOwner(null);
            System.out.println(name + " пересел на " + transport);
        } else {
            System.out.println(name + " сел за " + transport);
        }
        currentTransport = transport;
        currentTransport.changeOwner(this);
    }

    public void leaveTransport() {
        if (currentTransport != null) {
            currentTransport.changeOwner(null);
            System.out.println(name + " покинул свой транспорт " + currentTransport);
            currentTransport = null;
        } else {
            System.out.println(name + " не на транспорте.");
        }
    }

    @Override
    public boolean canMoveOn(TerrainType terrain) {
        return allowedTerrains.contains(terrain);
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        boolean result = false;

        if (currentTransport != null) {
            result = currentTransport.move(distance, terrain);
        } else {
            if (canMoveOn(terrain)) {
                float time = (float) distance / velocity;
                result = time * stamina_per_second <= stamina;

                if (result) {
                    this.stamina -= time * stamina_per_second;
                    System.out.println(this + " прошел пешком расстояние " + distance + " по " + terrain);
                } else {
                    this.stamina = 0;
                    System.out.println(this + " не смог пройти пешком расстояние " + distance + " и устал.");
                }
            } else {
                System.out.println("Люди не могут передвигаться по " + terrain + " без транспорта.");
            }
        }
        return result;
    }

    @Override
    public double getFuel() {
        return stamina;
    }

    @Override
    public void consumeFuel(double delta) {
        if (stamina - delta >= 0) {
            stamina -= delta;
        } else {
            stamina = 0;
            System.out.println(this + " полностью истощен.");
        }
    }
}
