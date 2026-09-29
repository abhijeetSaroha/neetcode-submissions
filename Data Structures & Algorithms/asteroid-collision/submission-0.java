class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!st.isEmpty() &&
                   asteroid < 0 &&
                   st.peek() > 0) {

                if (st.peek() < -asteroid) {
                    // Stack asteroid explodes
                    st.pop();
                }
                else if (st.peek() == -asteroid) {
                    // Both explode
                    st.pop();
                    destroyed = true;
                    break;
                }
                else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}