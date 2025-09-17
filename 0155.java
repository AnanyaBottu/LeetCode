class MinStack {
    Stack<Integer> S;
    int min;

    public MinStack() {
        this.S = new Stack<>();
        min = 10000000;

    }

    public void push(int val) {
        if (S.isEmpty()) {
            S.push(val);
            min = val;
        } else {
            if ((min <= val)) {
                S.push(val);
            } else {
                S.push(2 * val - min);
                min = val;
            }
        }
    }

    public void pop() {
        if (S.peek() < min) {
            min = 2 * min - S.peek();
            S.pop();
        } else {
            S.pop();
        }
    }

    public int top() {
        if (S.peek() < min)
            return min;
        else
            return S.peek();
    }

    public int getMin() {
        return min;

    }
}