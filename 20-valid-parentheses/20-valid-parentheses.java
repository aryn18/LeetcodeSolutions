class Solution {
    public boolean isValid(String s) {
       Stack<Character> st=new Stack();
        HashMap<Character,Character> pairs=new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty())
                {
                    char c=s.charAt(i);
                    if( st.peek()==pairs.get(c))
                    {
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}