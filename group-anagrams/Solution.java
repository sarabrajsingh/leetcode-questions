import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        // key = sorted char array String
        // value = original String
        for(int i = 0; i < strs.length; i++){

            char[] c = strs[i].toCharArray();
            Arrays.sort(c);

            String sorted = new String(c);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}