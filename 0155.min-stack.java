/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (35.34%)
 * Total Accepted:    263.1K
 * Total Submissions: 744.4K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
class MinStack {
    private int mini;
    private Stack<Integer> stack;
    private Stack<Integer> b;
    /** initialize your data structure here. */
    public MinStack() {
        mini = Integer.MAX_VALUE;
        stack = new Stack<>();
        b = new Stack<>();
    }
    
    public void push(int x) {
        mini = Math.min(mini, x);
        stack.push(x);
    }
    
    public void pop() {
        mini = Integer.MAX_VALUE;
        stack.pop();
        while(!stack.empty()) {
            b.push(stack.pop());
        }
        while(!b.empty()) {
            push(b.pop());
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */