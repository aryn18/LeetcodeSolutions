class Solution {
    private static final Map<Character, Integer> NODE_INT_MAP = new HashMap<>() {{
        put('A', 0);
        put('T', 1);
        put('G', 2);
        put('C', 3);
    }};
    
    private static final int STEP = 4;
    private static final int LENGTH = 10;
    private static final int MAX_BASE = (int)Math.pow(STEP, LENGTH-1);
    
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) {
            return Collections.EMPTY_LIST;
        }
        
        Set<Integer> sequences = new HashSet<>();
        Set<String> result = new HashSet<>();
        
        int sequence = 0;
        for(int i = 0; i < s.length(); i++) {           
            int toRemoveIndex = i - LENGTH;
            if(toRemoveIndex >= 0) {
                sequence = sequence - NODE_INT_MAP.get(s.charAt(toRemoveIndex)) * MAX_BASE;
            }
            
            int toAdd = NODE_INT_MAP.get(s.charAt(i));
            sequence = sequence*STEP + toAdd;
            
            
            if(i < LENGTH - 1) {
                continue;
            }
            
            if(!sequences.contains(sequence)) {
                sequences.add(sequence);
            } else {
                result.add(s.substring(i-LENGTH+1, i+1));
            }
        }
        
        return new ArrayList<>(result);
    }
}