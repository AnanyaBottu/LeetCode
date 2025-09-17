class MyQueue {
    public MyQueue() {

    }

    Stack<Integer> St = new Stack<>();
    Stack<Integer> S2 = new Stack<>();

    public void push(int x) {
        int s = St.size();
        for (int i = 0; i < s; i++) {
            S2.add(St.peek());
            St.pop();
        }
        St.add(x);
        int s2 = S2.size();
        for (int j = 0; j < s2; j++) {
            St.add(S2.peek());
            S2.pop();
        }

    }

    public int pop() {
        if (St.size() == 0) {
            System.out.println("Empty Queue");
            return 0;
        } else {
            int popped = St.peek();
            St.pop();
            return popped;
        }

    }

    public int peek() {
        if (St.size() == 0) {
            System.out.println("Empty Queue");
        } else {
            return St.peek();
        }
        return 0;

    }

    public boolean empty() {
        return St.size() == 0;
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