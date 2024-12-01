package homework2month.OOP3;

public interface Moving {
    float max_fuel = 0;
    float fuel = 0;
    float fuel_per_second = 0;
    int velocity = 0;

    enum TerrainType {
        FORREST,
        SWAMP,
        PLAIN,
        SPACE
    }

    boolean canMoveOn(TerrainType terrain);
    boolean move(int distance, TerrainType terrain);

    double getFuel();
    void consumeFuel(double delta);
}
