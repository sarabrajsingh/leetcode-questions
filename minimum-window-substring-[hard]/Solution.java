import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        if (s.length() < t.length())
            return "";

        Set<Character> theSet = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        insertStringToStack(stack, t);

        for (int i = 0; i < t.length(); i++) {
            theSet.add(t.charAt(i));
        }

        List<String> list = new ArrayList<>();

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty()) {
                if (theSet.contains(s.charAt(i))) {
                    stack.pop();
                }
                i++;
                right++;
            }
            list.add(s.substring(left, right));
            s = s.substring(right, s.length());
            insertStringToStack(stack, t);
        }

        return new String("");
    }

    private static void insertStringToStack(Stack<Character> stack, String t) {
        for (int i = 0; i < t.length(); i++) {
            stack.push(t.charAt(i));
        }
    }
}