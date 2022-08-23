class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> st = new Stack<>();
		
        for (int i=0; i < s.length(); i++){
            if(arr[i] == '(' ){
                st.push(i);
            } else if (arr[i] == ')' ){
                if(st.size() == 0){
                    arr[i] = '.';
                } else {
                    st.pop();
                }
            }
        }
        
        while(st.size() > 0){
            arr[st.pop()] = '.';
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(char ch: arr){
            if(ch != '.'){
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}