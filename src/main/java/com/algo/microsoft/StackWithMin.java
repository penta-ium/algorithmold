package com.algo.microsoft;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 带min方法的stack
 * 要求min的时间复杂度为O(1)
 * 采用空间换时间的方法，使用多余的小顶堆
 */
public class StackWithMin {

    Stack<Integer> stack = new Stack();
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public void push(Integer value) {
        //stack.push(value);
        queue.add(stack.push(value));
    }

    public void pop() {
        //Integer value = stack.pop();
        queue.remove(stack.pop());
    }

    public Integer min(){
        return queue.isEmpty() ? null : queue.peek();
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(2);
        stack.push(2);
        stack.push(4);
        stack.pop();
        System.out.println(stack.min());
        //stack.pop();
        //System.out.println(stack.min());
    }
}
