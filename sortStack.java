class Solution {
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        new Main().sortStack(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
