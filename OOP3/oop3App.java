package homework2month.OOP3;

import homework2month.OOP3.transports.*;
import homework2month.OOP3.transports.Car;
import homework2month.OOP3.Moving.TerrainType.*;

public class oop3App {
    public static void main(String[] args) {
        // Create a Human instance
        human human = new human("Andry");

        // Create Transport instances
        Transport car = new Car();
        Transport bike = new Bicycle();
        Transport horse = new Horse("Jean");
        Transport coolcar = new track();

        // Print the human's name
        System.out.println(human);

        // Movement tests
        human.move(20, Moving.TerrainType.FORREST);
        human.takeTransport(car);
        human.move(20, Moving.TerrainType.FORREST);
        human.move(25, Moving.TerrainType.PLAIN);

        human.takeTransport(bike);
        human.move(25, Moving.TerrainType.FORREST);

        human.leaveTransport();
        human.move(500, Moving.TerrainType.SWAMP);

        human.takeTransport(coolcar);
        human.move(500, Moving.TerrainType.SWAMP);

        human.takeTransport(horse);
        human.move(25, Moving.TerrainType.FORREST);
        human.move(25, Moving.TerrainType.FORREST);
        human.move(25, Moving.TerrainType.FORREST);
        human.move(25, Moving.TerrainType.FORREST);
    }
}
