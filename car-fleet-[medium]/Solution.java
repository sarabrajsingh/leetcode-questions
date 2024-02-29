import java.util.ArrayList;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        // add elements to the list
        list.add("element1");
        list.add("element2");
        list.add("element3");

        // dynamically resize the list
        list.ensureCapacity(100); // ensures list has capacity for at least 100 elements

        // randomly access elements
        int randomIndex = new Random().nextInt(list.size()); // get a random index between 0 and list.size() - 1
        String randomElement = list.get(randomIndex); // get the element at the random index

        System.out.println("Random element: " + randomElement);
    }
}