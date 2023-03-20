class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        int count=0;
        for(int i=0;i<f.length;i++){
            if(f[i]==0){
                int prev=i==0?0:f[i-1];
                int next=i==f.length-1?0:f[i+1];
                if(prev==0 && next==0){
                    f[i]=1;
                    count++;
                }
            }
        }
        return count>=n;
    }
}
