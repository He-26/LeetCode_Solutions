class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[nums.length];
        int j=0;
        for(int i=0;i<n;i++){
            res[j]=nums[i];
            j++;
            res[j]=nums[i+n];
            j++;
        }
        return res;
    }
}
