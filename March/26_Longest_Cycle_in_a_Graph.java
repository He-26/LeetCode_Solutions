class Solution {
    public int longestCycle(int[] edges) {
        int ans=-1;
        int n=edges.length;
        Map<Integer, Pair<Integer, Integer>> distance=new HashMap<>();
        for(int i=0;i<n;i++){
            distance.put(i,new Pair(-1,-1));
        }
        for(int i=0;i<edges.length;++i){
            for(int j=i, dist=0;j!=-1;j=edges[j]){
                Pair<Integer, Integer> curr=distance.get(j);
                int currDistance=curr.getKey();
                int currParent=curr.getValue();
                if(currDistance==-1)
                    distance.put(j,new Pair(dist++,i));
                else{
                    if(currParent==i)
                        ans=Math.max(ans,dist-currDistance);
                    break;
                }
            }
        }
        return ans;
    }
}
