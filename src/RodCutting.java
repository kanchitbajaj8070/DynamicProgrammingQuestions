public class RodCutting {
    public static void main(String[] args) {
        int [] price={2,3,2,5};
        int length=4;
       // System.out.println(maximizeProfitRodCutting(price,4));
        System.out.println(dpSolution(price,length));
    }
    public static int maximizeProfitRodCutting( int [] price , int length)
    {
        if( length==0)
            return 0;
        if(length<0)
            return -1;
        int maxAns=Integer.MIN_VALUE;
        for (int i = 0; i <price.length ; i++) {
           int ans=maximizeProfitRodCutting(price,length-(i+1));
           if(ans==-1)
               break;
        maxAns=Math.max(maxAns,price[i]+ans);
        }
        return maxAns;
    }
    public static int dpSolution(int [] price,int len)
    {
        int []dp=new int[len+1];
        dp[0]=0;
        for (int i = 1; i <= len; i++) {
            int ans=0;
            for (int j = 1; j <=i ; j++) {
            ans=Math.max(ans,price[j-1]+dp[i-j]);
            }
            dp[i]=ans;
        }
        return dp[len];
    }
}


