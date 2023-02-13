class Solution {
    public int countOdds(int low, int high) {
       /* int res=0;
        for(int i=low;i<=high;i++){
            if(i%2!=0){
                res++;
            }
        }
        return res;*/
        int diff=high-low;
			  int count=diff/2;

				if(low%2!=0 || high%2!=0)
					count++;

				return count;
    }
}
