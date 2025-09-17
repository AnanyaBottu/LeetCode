class MyStack {
    public MyStack() {

    }

    Queue<Integer> Qu = new LinkedList<>();

    public void push(int x) {
        int s = Qu.size();
        Qu.add(x);
        for (int i = 0; i < s; i++) {
            Qu.add(Qu.peek());
            Qu.remove();
        }

    }

    public int pop() {
        int popped = 0;
        if (Qu.size() == 0) {
            System.out.println("Empty Stack");
            return 0;
        } else {
            popped = Qu.peek();
            Qu.remove();
            return popped;
        }

    }

    public int top() {
        if (Qu.size() == 0)
            System.out.println("Empty Stack");
        else
            return Qu.peek();
        return 0;

    }

    public boolean empty() {
        return Qu.size() == 0;
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