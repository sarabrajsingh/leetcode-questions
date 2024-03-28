import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        StringBuilder response = new StringBuilder();

        Map<Integer, Integer> piece_table = new HashMap<>();

        for(int i = 0; i < indices.length; i++) {
            if(s.startsWith(sources[i], indices[i])) {
                piece_table.put(indices[i], i);
            }
        }

        int counter = 0;

        while(counter < s.length() -1) {
            if(piece_table.containsKey(counter)) {
                response.append(targets[piece_table.get(counter)]);
                String move = sources[piece_table.get(counter)];
                counter += move.length();
            } else {
                response.append(s.charAt(counter));
                counter++;
            }
        }

        return response.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findReplaceString("abcd", new int[]{0,2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
    }
}