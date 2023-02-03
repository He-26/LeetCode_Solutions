class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i]=new StringBuilder();
        }
        char[] arr=s.toCharArray();
        int n=arr.length;
        int index=0;
        while(index<n){
            for(int j=0;j<numRows && index<n;j++){
                sb[j].append(arr[index++]);
                System.out.print(sb[j].toString()+" ");
            }
            System.out.println();
            for(int j=numRows-2;j>0&&index<n;j--){
                sb[j].append(arr[index++]);
                System.out.print(sb[j].toString()+" ");
            }
        }
        System.out.println();
        StringBuilder res=sb[0];
        for(int i=1;i<numRows;i++){
            res.append(sb[i].toString());
            System.out.print(res.toString());
        }
        return res.toString();
    }
}
