class Solution {
    public long distinctNames(String[] ideas) {
        Set<String> set=new HashSet<>();
        for(String idea:ideas){
            set.add(idea);
        }
        int[][] freq=new int[26][26];
        for(int i=0;i<ideas.length;i++){
            int firstChar=ideas[i].charAt(0)-'a';
            for(char j='a';j<='z';j++){
                String newString=j+ideas[i].substring(1);
                if(!set.contains(newString)){
                    freq[firstChar][j-'a']++;
                    //System.out.print(newString+" ");
                }
            }
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                System.out.print(freq[i][j]+" ");
            }
        }
        long ans=0;
        for(char i='a';i<='z';i++){
            for(char j='a';j<='z';j++){
                ans+=(long)freq[i-'a'][j-'a']*(long)freq[j-'a'][i-'a'];
            }
        }
        return ans;
    }
}
