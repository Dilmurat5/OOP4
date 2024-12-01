package homework2month.OOP3.transports;

import homework2month.OOP3.Moving;

import java.util.Arrays;

public class track extends Transport {
    public track() {
        super(15, 350, 10f, Arrays.asList(TerrainType.SWAMP, TerrainType.PLAIN));
    }

    @Override
    public String toSting() {
        return "Вездеход";
    }


}
