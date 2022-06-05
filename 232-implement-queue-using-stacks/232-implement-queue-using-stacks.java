class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        size = 0;
    }
    
    public void push(int x) {
        s1.push(x);
        size++;
    }
    
    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }

        int removed = s2.peek();
        s2.pop();
        size--;

        while(!s2.isEmpty()){
            s1.push(s2.peek());
            s2.pop();
        }

        return removed;
    }
    
    public int peek() {
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }

        int removed = s2.peek();

        while(!s2.isEmpty()){
            s1.push(s2.peek());
            s2.pop();
        }

        return removed;
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */