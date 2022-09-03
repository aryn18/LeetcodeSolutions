class Solution {
char[][] map = {{'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'},{'w','x','y','z'}};
public List letterCombinations(String digits) {
List result = new ArrayList<>();
if (!digits.isEmpty()) {
generateCombinations(0, digits, new StringBuilder(), result);
}
return result;
}

private void generateCombinations(int i, String digits, StringBuilder sb, List<String> result) {
    if (sb.length() == digits.length()) {
        result.add(sb.toString());
        return;
    }
    
    int index = digits.charAt(i) - '2';
    for (char c : map[index]) {
        sb.append(c);
        generateCombinations(i + 1, digits, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        
    }
}
}