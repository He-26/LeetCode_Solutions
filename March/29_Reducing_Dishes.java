class Solution {
    public int maxSatisfaction(int[] s) {
        int total=0,res=0;
        Arrays.sort(s);
        for(int i=s.length-1;i>=0 && total>-s[i];i--){
            total+=s[i];
            res+=total;
        }
        return res;
    }
}
