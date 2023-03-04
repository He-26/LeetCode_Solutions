class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res=0;
        int n=nums.length;
        int mini=-1,maxi=-1,start=0;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK){
                mini=maxi=-1;
                start=i+1;
            }
            if(nums[i]==minK){
                mini=i;
            }
            if(nums[i]==maxK){
                maxi=i;
            }
            res=res+Math.max(0L,Math.min(mini,maxi)-start+1);
        }
        return res;
    }
}
