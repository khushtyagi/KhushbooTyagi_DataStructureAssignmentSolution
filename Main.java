package khusub.another.problem1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Floor> floorList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);
    PrintValues printValues = new PrintValues();

    public void insertValue() {
        int numberOfFloors;
        // Get the total no of floors
        do {
            System.out.println("enter the total no of floors in the building");
            numberOfFloors = scanner.nextInt();
            // Get the value of each floor in the loop
            if (numberOfFloors > 0) {
                for (int i = 0; i < numberOfFloors; i++) {
                    Floor floor = new Floor();
                    System.out.println("enter the floor size given on day :  " + (i + 1));
                    int floorNumber = scanner.nextInt();
                    if (floorNumber != 0) {
                        // check if inserted value is not 0
                        floor.setDay(i + 1);
                        floor.setSize(floorNumber);
                        floorList.add(floor);
                    } else {
                        System.out.println("Invalid value. Enter Again");
                        i--;
                    }
                }
            } else {
                System.out.println("Please entry valid no of floor.");
            }
        } while (numberOfFloors == 0);

        // Sorting list in reverse order
        Collections.sort(floorList, new FloorNumberComparator());
        // printing output
        printValues.printConstructionOrder(floorList);
    }


    public static void main(String[] args) {
        Main building = new Main();
        building.insertValue();
    }
}