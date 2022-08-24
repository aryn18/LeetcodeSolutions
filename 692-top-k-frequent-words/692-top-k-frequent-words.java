class Solution {
    class wordsClass{
        int count=0;
        String word="";
        public wordsClass(String word,int count){
            this.count=count;
            this.word=word;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        
        PriorityQueue<wordsClass> pq = new PriorityQueue<wordsClass>((a,b)-> a.count==b.count ? a.word.compareTo(b.word) : b.count - a.count);
        for(String key : map.keySet()){
            pq.offer(new wordsClass(key,map.get(key)));
        }
        
        List<String> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(pq.poll().word);
        }
        return res;
    }
}