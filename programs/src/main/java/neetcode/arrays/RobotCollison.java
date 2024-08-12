package neetcode.arrays;

import java.util.*;

public class RobotCollison {
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        Integer[] healthArr = Arrays.stream(healths).boxed().toArray(Integer[]::new);
        Arrays.sort(healthArr,Collections.reverseOrder());
        Arrays.stream(healthArr).forEach(System.out::println);
        String directions = "RLRL";
        char[] directionsArr = directions.toCharArray();
        List<Robot> robotList = new ArrayList<>();
        int index = 1;
        for(int pos:positions){
            robotList.add(new Robot(index,pos,directionsArr[index-1],healths[index-1]));
            index++;
        }
        Collections.sort(robotList);
        robotList.stream().forEach(System.out::println);
    }
}

class Robot implements Comparable<Robot>{
    int id;
    int position;
    char direction;
    int health;

    public Robot(int id, int position, char direction, int health) {
        this.id = id;
        this.position = position;
        this.direction = direction;
        this.health = health;
    }

    @Override
    public int compareTo(Robot that) {
        return this.position-that.position;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", position=" + position +
                ", direction=" + direction +
                ", health=" + health +
                '}';
    }
}