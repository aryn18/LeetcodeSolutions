class Solution {
    public static Stack<Character> ans;
    public String decodeString(String st) {
        if(st.length()<=3)
            return st;
        ans=new Stack<>();
		answer(0, 0, st);
        st="";
        for (int i = 0; i < ans.size(); i++) {
			st+=ans.get(i);
		}
        return st;
    }
    public static void answer(int num,int ind,String input){
		if(ind>=input.length()) return;
		if(input.charAt(ind)!=']')ans.push(input.charAt(ind));	
		else if(input.charAt(ind)==']'){
			String temp="",nu="";
			while(ans.peek()!='['){
				temp+=ans.peek();
				ans.pop();
			}
			ans.pop();
			while(!ans.empty() && ans.peek()>='0' && ans.peek()<='9'){
				nu=ans.peek()+nu;
			    ans.pop();
			}
			num=Integer.parseInt(nu);
			for (int i = 0; i < num; i++) {
				for (int j = temp.length()-1; j>=0; j--) {
					ans.push(temp.charAt(j));
				}
			}
		}
		answer(num, ind+1, input);
	}
}