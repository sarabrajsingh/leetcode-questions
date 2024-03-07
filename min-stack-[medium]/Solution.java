import java.util.Stack;

public class Solution {
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> min;
    
        public MinStack() {
            this.stack = new Stack<>();
            this.min = new Stack<>();
        }
        
        public void push(int val) {
            this.stack.push(val);
            if(this.min.size() != 0){
                val = Math.min(val, this.min.peek());
            }
            this.min.push(val);
        }
        
        public void pop() {
            this.stack.pop();
            this.min.pop();
        }
        
        public int top() {
            return this.stack.peek();
        }
        
        public int getMin() {
            return this.min.peek();
        }
    }

    public static void main(String[] args) {
        
    }
}
