class Solution {
    Map<Integer, List<Integer>> graph=new HashMap();
    Map<Integer, Integer> minimum=new HashMap();
    Set<Integer> visited=new HashSet();
    
    public void construct(int[][] roads, int n){
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
            minimum.put(i,Integer.MAX_VALUE);
        }
        for(int[] road:roads){
            int r1=road[0];
            int r2=road[1];
            int d=road[2];
            graph.get(r1).add(r2);
            graph.get(r2).add(r1);
            minimum.put(r1,Math.min(d,minimum.get(r1)));
            minimum.put(r2,Math.min(d,minimum.get(r2)));
        }
    }

    int res=Integer.MAX_VALUE;

    public void dfs(int curr){
        visited.add(curr);
        List<Integer> nei=graph.get(curr);
        for(int i=0;i<nei.size();i++){
            int road=nei.get(i);
            if(!visited.contains(road)){
                res=Math.min(res,minimum.get(road));
                dfs(road);        
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        construct(roads,n);
        dfs(1);
        return res;
    }

}
