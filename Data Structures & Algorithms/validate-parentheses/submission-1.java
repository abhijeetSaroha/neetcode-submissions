class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch == ']'){
                if(!st.isEmpty() && st.peek() == '['){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch == '}'){
                if(!st.isEmpty() && st.peek() == '{'){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}
