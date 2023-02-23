class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));
        for(int i=0;i<n;i++)
            pq.add(new int[]{capital[i],profits[i]});
        PriorityQueue<int[]> maxpq=new PriorityQueue<int[]>((a,b)->(b[1]-a[1]));
        for(int i=0;i<k;i++){
            while(!pq.isEmpty()&&pq.peek()[0]<=w) {
                maxpq.add(pq.poll());
            }
            
            if (maxpq.isEmpty()) break;
            
            w+=maxpq.poll()[1];
        }
        return w;
    }
}
