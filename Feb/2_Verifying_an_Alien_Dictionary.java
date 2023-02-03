class Solution {
    public int[] char_map;
    public boolean isAlienSorted(String[] words, String order) {
        char_map=new int[26];
        for(int i=0;i<order.length();i++){
            char_map[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            if(compare(words[i-1],words[i])>0){
                return false;
            }
        }
        return true;
    }
    public int compare(String s1, String s2){
        int i=0,j=0,char_comp=0;
        while(i<s1.length() && j<s2.length() && char_comp==0){
            char_comp=char_map[s1.charAt(i)-'a']-char_map[s2.charAt(i)-'a'];
            i++;
            j++;
        }
        if(char_comp==0){
            return s1.length()-s2.length();
        }else{
            return char_comp;
        }
    }
}
