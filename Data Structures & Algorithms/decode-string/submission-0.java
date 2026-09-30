class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            // Case 1: Digit
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Case 2: Opening bracket
            else if (ch == '[') {

                countStack.push(num);
                stringStack.push(current.toString());

                num = 0;
                current.setLength(0);
            }

            // Case 3: Closing bracket
            else if (ch == ']') {

                int repeat = countStack.pop();
                String previous = stringStack.pop();

                StringBuilder temp = new StringBuilder(previous);

                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }

                current = temp;
            }

            // Case 4: Letter
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}