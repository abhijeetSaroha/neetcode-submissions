class FreqStack {

    // Frequency of each value
    HashMap<Integer, Integer> freq;

    // Stack of values for each frequency
    HashMap<Integer, Stack<Integer>> group;

    // Maximum frequency currently present
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {

        // Increase frequency
        int newFreq = freq.getOrDefault(val, 0) + 1;
        freq.put(val, newFreq);

        // Create stack for this frequency if needed
        if (!group.containsKey(newFreq)) {
            group.put(newFreq, new Stack<>());
        }

        // Add value to its frequency stack
        group.get(newFreq).push(val);

        // Update maximum frequency
        maxFreq = Math.max(maxFreq, newFreq);
    }

    public int pop() {

        // Get most recently added element
        // among elements with maximum frequency
        int val = group.get(maxFreq).pop();

        // Decrease its frequency
        freq.put(val, freq.get(val) - 1);

        // If no element remains at maxFreq
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */