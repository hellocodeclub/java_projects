package elevatorsystem;

import java.util.Arrays;

public class ElevatorSystem {
    // An elevator system should allow a person to press on the elevator button,
    // and get an elevator to their floor
    // in a short time. The elevator system will create an building elevator area,
    // representing the elevator doors
    // per floor. This area is abstracted as a grid. When a person press an elevator button,
    // the system has to determine
    // the minimum distance require for one of the elevators to reach the request floor.

    // Returning an integer representing the total distance to get to the requested floor.

    /*

           Input: num_floor: 4 num_elevator: 4
           [[0,1,0,1],
            [0,0,0,0],
            [0,0,0,0],
            [1,0,1,0]]

            button_floor = 2
            output = 1
     */


    public int findMinimumDistance(int floor, int[][] area){
        if(isElevatorOnFloor(area[floor])){
            return 0;
        }
        int i = 1;
        int rowAbove = floor+i;
        int rowBelow = floor-i;
        while(isRowWithinGridLimit(area.length, rowAbove) || isRowWithinGridLimit(area.length, rowBelow)){
            if(isRowWithinGridLimit(area.length, rowAbove)){
                if (isElevatorOnFloor(area[rowAbove])){
                    return i;
                }
            }
            if(isRowWithinGridLimit(area.length, rowBelow)){
                if(isElevatorOnFloor(area[rowBelow])){
                    return i;
                }
            }
            i++;
            rowAbove = floor+i;
            rowBelow = floor-i;
        }
        return -1;
    }

    public boolean isRowWithinGridLimit(int numRows, int row){
        return row>-1 && row<numRows;
    }

    public boolean isElevatorOnFloor(int[] elevatorRow){
        return Arrays.binarySearch(elevatorRow,1)>-1;
    }

    public static void main(String[] args){
        int[][] grid = {{0,1,0,1},{0,0,0,0}, {0,0,0,0},{1,0,1,0}};
        System.out.println(new ElevatorSystem().findMinimumDistance(2,grid)); // output:1

        int[][] grid2 = {{1,1,1,1},{0,0,0,0}, {0,0,0,0},{0,0,0,0}};
        System.out.println(new ElevatorSystem().findMinimumDistance(3,grid2)); // output: 3
        System.out.println(new ElevatorSystem().findMinimumDistance(0,grid2)); // output: 0

        int[][] grid3 = {{1,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0},{0,0,0,1}};

        System.out.println(new ElevatorSystem().findMinimumDistance(3,grid3)); // output: 1
        System.out.println(new ElevatorSystem().findMinimumDistance(2,grid3)); // output: 0

    }
}
