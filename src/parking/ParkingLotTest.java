package parking;

import org.junit.Test;
import parkinglot.solution.Car;
import parkinglot.solution.Level;
import parkinglot.solution.ParkingLot;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void test1(){
        List<parkinglot.solution.Level> levels = List.of(new parkinglot.solution.Level(2,0), new Level(2,1));

        parkinglot.solution.ParkingLot parkingLot = new ParkingLot(levels);

        assertTrue(parkingLot.park(new parkinglot.solution.Car("L123")));
        assertTrue(parkingLot.park(new parkinglot.solution.Car("L124")));
        assertTrue(parkingLot.park(new parkinglot.solution.Car("L125")));
        assertTrue(parkingLot.park(new parkinglot.solution.Car("L126")));

        parkingLot.display();

        assertTrue(parkingLot.park(new parkinglot.solution.Car("L123")));
        assertTrue(parkingLot.park(new parkinglot.solution.Car("L124")));
        assertTrue(parkingLot.park(new parkinglot.solution.Car("L125")));
        assertTrue(parkingLot.park(new parkinglot.solution.Car("L126")));

        parkingLot.display();

        assertFalse(parkingLot.park(new Car("L126")));

    }
}
