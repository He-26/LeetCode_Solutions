class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0;
        for(int w:weights){
            right+=w;
            left=Math.max(left,w);
        }
        while(left<right){
            int mid=(left+right)/2;
            int d=1,curr=0;
            for(int w:weights){
                if(curr+w>mid){
                    d+=1;
                    curr=0;
                }
                curr+=w;
            }
            if(d>days)  left=mid+1;
            else right=mid;
        }
        return left;
    }
}
