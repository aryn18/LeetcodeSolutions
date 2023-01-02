public class DetectCapital520 {
    class Solution {
        public boolean detectCapitalUse(String word) {
            return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
        }
    }
}
