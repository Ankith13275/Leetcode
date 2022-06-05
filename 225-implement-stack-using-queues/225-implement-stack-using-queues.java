class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    int size;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
    }
    
    public void push(int x) {
        q1.add(x);
        size++;
    }
    
    public int pop() {
        
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        
        int removed = q1.remove();
        size--;
        
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        
        return removed;
        
    }
    
    public int top() {
        
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        
        int top = q1.remove();
        q2.add(top);
    
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        
        return top;
        
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */