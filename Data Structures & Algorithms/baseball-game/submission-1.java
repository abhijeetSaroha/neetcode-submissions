class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String s : operations){
            char ch = s.charAt(0);
            if(ch == 'D'){
                st.push(2*st.peek());
            }
            else if(ch == 'C'){
                st.pop();
            }
            else if(ch == '+'){
                int first = st.pop();
                int second = st.peek();
                st.push(first);
                st.push(first+second);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        while(!st.isEmpty()){
            sum = sum + st.pop();
        }

        return sum;
    }
}