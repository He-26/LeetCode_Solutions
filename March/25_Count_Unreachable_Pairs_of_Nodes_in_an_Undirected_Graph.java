class Solution {
    long ans=0;
    Map<Integer, List<Integer>> map=new HashMap();
    Set<Integer> visited=new HashSet<>();
    public void dfs(int curr){
        visited.add(curr);
        ans++;
        List<Integer> neig=map.get(curr);
        for(int i=0;i<neig.size();i++){
            if(visited.contains(neig.get(i))){
                continue;
            }
            dfs(neig.get(i));
        }
    }
    public void construct(int n,int[][] edges){
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int s1=edge[0];
            int s2=edge[1];
            List<Integer> l=map.get(s1);
            l.add(s2);
            map.put(s1,l);
            l=map.get(s2);
            l.add(s1);
            map.put(s2,l);
        }
    }
    public long countPairs(int n, int[][] edges) {
        construct(n,edges);
        long res=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                ans=0;
                dfs(i);
                res+=ans*(n-ans);
            }
        }
        return res/2;
    }
}
