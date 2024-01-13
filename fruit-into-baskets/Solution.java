import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();

        int left = 0, maxPicked = 0;
        
        for(int right = 0; right < fruits.length; right++) {
            // here we're saying that if we use the integer encountered as the key in the map,
            // if the value doesn't exist, add it and default the value to zero
            // if it does then increase it's value by one
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            while(basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if(basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            maxPicked = Math.max(maxPicked, right - left + 1);
        }


        return maxPicked;
    }
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(String.format("totalFruit=%d", totalFruit(fruits)));
    }
}