class Solution {
    public String multiply(String a, String b) {
        int n = a.length();
        int m = b.length();
        
        if(a.equals("1")) return b;
        if(b.equals("1")) return a;
        
        if(a.equals("0") || b.equals("0")) return "0";
        
        a = reverse(a);
        b = reverse(b);
        
        String ans = "0";
        for(int i=0; i<n; i++){
            char x = a.charAt(i);
            String temp = "";
            int carry = 0;
            for(int j=0; j<m; j++){
                char y = b.charAt(j);
                int prod = (x-'0')*(y-'0');
                prod += carry;
                temp+=String.valueOf(prod%10);
                carry = prod/10;
            }
            if(carry>0){
                temp+=String.valueOf(carry);
            }
            
            ans = sum(ans, temp, i);
            // System.out.println(temp+" "+ans);
        }
        
        return reverse(ans);
    }
    String sum(String a, String b, int x){
		// adds string b to string a, after skipping x places of a
        String ans = "";
        if(x>0){
            ans = a.substring(0, x);
        }
        
        int carry = 0;
        int i=x;
        int j=0;
        int n=a.length();
        int m=b.length();
        while(i<n && j<m){
            int sum = (a.charAt(i)-'0')+(b.charAt(j)-'0')+carry;
            ans+=String.valueOf(sum%10);
            carry=sum/10;
            i++;
            j++;
        }
        while(i<n){
            int sum = (a.charAt(i)-'0')+carry;
            ans+=String.valueOf(sum%10);
            carry=sum/10;
            i++;
        }
        while(j<m){
            int sum = (b.charAt(j)-'0')+carry;
            ans+=String.valueOf(sum%10);
            carry=sum/10;
            j++;
        }
        if(carry>0){
            ans+=String.valueOf(carry);
        }
        return ans;
    }
    String reverse(String s){
        char[] ch = s.toCharArray();
        int i=0;
        int j=ch.length-1;
        while(i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(ch);
    }
}