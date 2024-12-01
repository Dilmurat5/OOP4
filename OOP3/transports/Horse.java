package homework2month.OOP3.transports;

import java.util.Arrays;
import java.util.List;

public class Horse extends Transport {
    private final float max_stamina = 2500;
    private float stamina;
    private final float stamina_per_second = 2.5f;
    private final int velocity;
    private final String name;

    // Constructor
    public Horse(String name) {
        super(10, 2500, 2.5f, Arrays.asList(TerrainType.FORREST, TerrainType.SWAMP, TerrainType.PLAIN)); // Call parent constructor
        this.name = name;
        this.velocity = 10;
        this.stamina = max_stamina;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (velocity <= 0) {
            System.out.println(this + " не хватает скорости.");
            return false;
        }

        if (!canMoveOn(terrain)) {
            System.out.println(this + " не может передвигаться по ландшафту: " + terrain);
            return false;
        }

        float time = (float) distance / velocity;
        boolean result = time * stamina_per_second <= stamina;

        if (result) {
            stamina -= time * stamina_per_second;
            System.out.println((owner != null ? owner : "незнакомый водитель") +
                    " успешно прошел путь " + distance + " на " + this + " через " + terrain);
        } else {
            stamina = 0;
            System.out.println((owner != null ? owner : "незнакомый водитель") +
                    " не может закончить путь " + this + ": " + name + " устала.");
        }
        return result;
    }

    @Override
    public String toSting() {
        return name;
    }
}
