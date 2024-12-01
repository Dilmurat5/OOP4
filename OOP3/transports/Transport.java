package homework2month.OOP3.transports;

import homework2month.OOP3.human;
import homework2month.OOP3.Moving;

import java.util.List;

public abstract class Transport implements Moving {
    protected float max_fuel;
    protected float fuel;
    protected float fuel_per_second;
    protected float velocity;
    protected human owner;
    protected List<TerrainType> allowedTerrains;

    public float getVelocity() {
        return velocity;
    }

    protected void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getMax_fuel() {
        return max_fuel;
    }

    protected void setMax_fuel(float max_fuel) {
        this.max_fuel = max_fuel;
    }

    public float getFuel_per_second() {
        return fuel_per_second;
    }

    protected void setFuel_per_second(float fuel_per_second) {
        this.fuel_per_second = fuel_per_second;
    }

    public void changeOwner(human owner) {
        this.owner = owner;
    }

    public human getOwner() {
        return owner;
    }

    public Transport(float velocity, float max_fuel, float fuel_per_second, List<TerrainType> terrain) {
        this.max_fuel = max_fuel;
        this.fuel = max_fuel;
        this.fuel_per_second = fuel_per_second;
        this.velocity = velocity;
        allowedTerrains = terrain;
    }

    public Transport() {
    }

    @Override
    public String toString() {
        return "Transport";
    }

    @Override
    public boolean canMoveOn(TerrainType terrain) {
        return allowedTerrains.contains(terrain);
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (velocity <= 0) {
            System.out.println(this + " не хватает скорости.");
            return false;
        }

        if (!canMoveOn(terrain)) {
            System.out.println(this + " Не может пройти ландшафт: " + terrain);
            return false;
        }

        float time = distance / velocity;
        if (time * fuel_per_second <= this.fuel) {
            this.fuel -= time * fuel_per_second;
            System.out.println(this.owner + " успешно прошел путь " + distance + " on " + this + " over " + terrain);
            return true;
        } else {
            System.out.println(this + " Не достаточно топлива для передвижения.");
            return false;
        }
    }

    @Override
    public double getFuel() {
        return fuel;
    }

    @Override
    public void consumeFuel(double delta) {
        if (delta > 0) {
            fuel = Math.max(0, fuel - (float) delta);
        }
    }

    public abstract String toSting();
}

