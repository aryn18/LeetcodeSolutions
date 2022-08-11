class Solution {
    List<String> list=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        perm("",s.toLowerCase());
        return list;
    }
    private void perm(String p,String up){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch>='0' && ch<='9') {
             perm(p+ch,up.substring(1));
        }else{
            perm(p+Character.toUpperCase(ch),up.substring(1));                                          
            perm(p+ch,up.substring(1));
        }
    }
}