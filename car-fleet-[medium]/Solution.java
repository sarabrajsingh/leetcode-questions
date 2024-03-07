import java.util.Arrays;
import java.util.Stack;
public class Solution {
    public static void main(String[] args) {
        int target = 12;
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};

        System.out.println(carFleet(target, position, speed));
    }

    static class Car {
        int speed;
        int position;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;            
        }
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        
        if (position.length == 1) return 1;

        Stack<Double> stack = new Stack<>();

        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            Car c = new Car(position[i], speed[i]);
            cars[i] = c;
        }

        Arrays.sort(cars, java.util.Comparator.comparingInt(car -> car.position));

        for (int i = cars.length - 1; i >= 0; i--) {
            double timeToTarget = (double) (target - cars[i].position) / cars[i].speed;

            if (!stack.isEmpty() && timeToTarget <= stack.peek()) {
                continue;
            } else {
                stack.push(timeToTarget);
            }
        }

        return stack.size();
    }
}