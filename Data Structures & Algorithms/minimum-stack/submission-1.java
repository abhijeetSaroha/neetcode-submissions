class MinStack {

    class Node {
        int value;
        int min;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            int currentMin = Math.min(val, stack.peek().min);
            stack.push(new Node(val, currentMin));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}