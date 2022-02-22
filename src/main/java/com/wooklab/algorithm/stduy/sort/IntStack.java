package com.wooklab.algorithm.stduy.sort;

public class IntStack {

    private int max;
    private int pointer;
    private int[] stack;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public IntStack(int capacity) {
        pointer = 0;
        max = capacity;
        try {
            this.stack = new int[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }

    public int push(int x ) throws OverflowIntStackException {
        if (pointer >= max) {
            throw new OverflowIntStackException();
        }
        return stack[pointer++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[--pointer];
    }

    public int peek() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[pointer - 1];
    }

    public int indexOf(int max) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stack[i] == max) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        pointer = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= max;
    }

    public void dump() {
        if (pointer <= 0) {
            System.out.println("Stack is Empty.");
        } else {
            for (int i = 0; i < pointer; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
