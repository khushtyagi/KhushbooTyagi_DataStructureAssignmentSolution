package khusub.another.problem1;

import java.util.ArrayList;
import java.util.List;

public class PrintValues {
    public void printValues(int currentDay, List<Integer> result) {
        if (result.size() > 0) {
            System.out.println("Day : " + currentDay);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void printEmptyDays(int objDay, int currentDay) {
        for (int i = currentDay + 1; i < objDay; i++) {
            System.out.println("Day :" + " " + i + "\n");
        }
    }

    public void printConstructionOrder(List<Floor> floorList) {
        if (floorList.size() > 0)
            System.out.println("The order of construction is as follows: ");

        buildingConstructionOrder(floorList);
        floorList.clear();
    }

    public void buildingConstructionOrder(List<Floor> floorList) {
        int currentDay = 0;
        List<Integer> result = new ArrayList<>();

        for (Floor floor : floorList) {

            if (floor.day > currentDay) {
                if (currentDay + 1 > 0) {
                    printValues(currentDay, result);
                    printEmptyDays(floor.day, currentDay);
                }
                currentDay = floor.getDay();
                result.clear();
            }

            result.add(floor.getSize());
        }

        printValues(currentDay, result);
    }
}