class Solution {
    public static int uniqueMorseRepresentations(String[] words) {
    String [] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    Set<String> s = new HashSet<>();
    for(String word : words){
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<word.length(); i++){
        sb.append( codes[((int) word.charAt(i))-97]);
      }
      s.add(sb.toString());
    }

    return s.size();
    }
}