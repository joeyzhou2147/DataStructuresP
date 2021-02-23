class Solution {
   public String alienOrder(String[] words){
       int[] count= new int[26];
       Map<Character, List<Character>> map = new HashMap();
       Set<Character> set = new HashSet();
       for(String word: words)
           for(char c : word.toCharArray()){
               set.add(c);
               map.put(c, new ArrayList<>());
           }
       for(int i = 0; i < words.length - 1; i++){
           String cur = words[i], next = words[i+1];
            if (cur.length() > next.length() && cur.startsWith(next)) {
                return "";
            }
           for(int j = 0; j < Math.min(cur.length(), next.length()); j++){
               char cc = cur.charAt(j), nc = next.charAt(j);
               if(cc != nc){
                   map.get(cc).add(nc);
                   count[nc-'a']++;
                   break; //stop it here, don't process next character
               }
           }
       }
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList();
		//get all 0 in-count nodes
        for(char c:set)
            if(count[c-'a']==0) queue.offer(c);
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for (char nc : map.get(c)) {
                count[nc-'a']--;
                if(count[nc-'a'] == 0) queue.add(nc);
            }
        }
        if(sb.toString().length() != set.size())
            return "";
        return sb.toString();
    }
}
