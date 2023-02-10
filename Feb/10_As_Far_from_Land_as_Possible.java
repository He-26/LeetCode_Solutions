class Solution {
    public int maxDistance(int[][] grid) {
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        Set<String> visited=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int[] arr=new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    q.offer(arr);
                    visited.add(i+"|"+j);
                }
            }
        }
        int steps=-1;
        while(!q.isEmpty()){
            steps++;
            int queuesize=q.size();
            for(int k=0;k<queuesize;k++){
                int[] index=q.poll();
                int x=index[0];
                int y=index[1];
                for(int i=0;i<4;i++){
                    int newx=x+directions[i][0];
                    int newy=y+directions[i][1];
                    if(!isValid(newx,newy,grid)){
                        continue;
                    }
                    if(visited.contains(newx+"|"+newy)){
                        continue;
                    }
                    int[] new_arr=new int[2];
                    new_arr[0]=newx;
                    new_arr[1]=newy;
                    q.offer(new_arr);
                    visited.add(newx+"|"+newy);
                }
            }
        }
        return steps==0?-1:steps;
    }
    private boolean isValid(int i, int j, int[][] grid){
        if(i<0||i>=grid.length){
            return false;
        }
        if(j<0 || j>=grid[0].length){
            return false;
        }
        return grid[i][j]==0;
    }
}
