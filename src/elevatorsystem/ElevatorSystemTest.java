package elevatorsystem;

import org.junit.Assert;
import org.junit.Test;

public class ElevatorSystemTest {

    @Test
    public void testCase1(){
        int[][] grid = {{0,1,0,1},{0,0,0,0}, {0,0,0,0},{1,0,1,0}};
        Assert.assertEquals(1, new ElevatorSystem().findMinimumDistance(2,grid));
    }

    @Test
    public void testCase2(){
        int[][] grid = {{1,1,1,1},{0,0,0,0}, {0,0,0,0},{0,0,0,0}};
        Assert.assertEquals(3, new ElevatorSystem().findMinimumDistance(3,grid));
        Assert.assertEquals(0, new ElevatorSystem().findMinimumDistance(0,grid));

    }

    @Test
    public void testCase3(){
        int[][] grid = {{1,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0},{0,0,0,1}};
        Assert.assertEquals(1, new ElevatorSystem().findMinimumDistance(3,grid));
        Assert.assertEquals(0, new ElevatorSystem().findMinimumDistance(2,grid));
    }

    @Test
    public void testCase4(){
        int[][] grid ={{1,1,0,1,1},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        Assert.assertEquals(3,new ElevatorSystem().findMinimumDistance(4,grid));
    }
}
