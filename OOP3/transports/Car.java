package homework2month.OOP3.transports;


import java.util.List;

public class Car extends Transport {
    public Car(){
        super(20, 500, 7.5f, List.of(TerrainType.PLAIN));
    }

    @Override
    public String toSting(){
        return "Машина";
    }

}
