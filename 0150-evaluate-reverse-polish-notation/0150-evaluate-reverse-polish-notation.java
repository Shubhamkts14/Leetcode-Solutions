class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                int x = st.pop();
                int y = st.pop();
                st.push(y+x);
            }
            else if(s.equals("*")){
                int x = st.pop();
                int y = st.pop();
                st.push(y*x);
            }
            else if(s.equals("-")){
                int x = st.pop();
                int y = st.pop();
                st.push(y-x);
            }
            else if(s.equals("/")){
                int x = st.pop();
                int y = st.pop();
                st.push(y/x);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}