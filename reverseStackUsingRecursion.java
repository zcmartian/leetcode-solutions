class Solution {
    public void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int i = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(i);
    }
    private int getAndRemoveLast(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        }
        int last = getAndRemoveLast(stack);
        stack.push(result);
        return last;
    }
    public static void main(String... args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
