import java.util.Arrays;

public class OptimalGameStrategy {
    /*
    * Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even.
     * We play a game against an opponent by alternating turns. In each turn, a player
      * selects either the first or last coin from the row, removes it from the row permanently,
      * and receives the value of the coin. Determine the maximum possible amount of money we
       * can definitely win if we move first.

Note: The opponent is as clever as the user.

Let us understand the problem with few examples:





1. 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)

2. 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)

Does choosing the best at each move give an optimal solution?

No. In the second example, this is how the game can finish:

1.
…….User chooses 8.
…….Opponent chooses 15.
…….User chooses 7.
…….Opponent chooses 3.
Total value collected by user is 15(8 + 7)
2.
…….User chooses 7.
…….Opponent chooses 8.
…….User chooses 15.
…….Opponent chooses 3.
Total value collected by user is 22(7 + 15)
So if the user follows the second game state, maximum value can be collected although
 the first move is not the best.*/
    public static void main(String[] args) {
        long e,f,g;
       int[]a={ 8, 15, 3, 7};
        //MMAX MARGIN IS += 125
        //125
        //timing is
        // recursive - 34
        // memo is = 1
       int sum=0;
       for(int g1:a)
           sum+=g1;
       e=System.currentTimeMillis();
        int ans=optimalGamestrategy(0,a.length-1,a);
        f=System.currentTimeMillis();
        System.out.println("MMAX MARGIN IS += "+ (sum-ans));
        int[][]memo= new int [a.length][a.length];
        for(int[]a1:memo)
            Arrays.fill(a1,-1);
        System.out.println((sum-optimalGamestrategyMemoised(0,a.length-1,a,memo)));
        g=System.currentTimeMillis();

        System.out.println("timing is\n"+" recursive - "+(f-e)+" \n memo is = "+(g-f));
    }
    public static int optimalGamestrategy( int s,int e, int []a)
    {
        if(s>e)
            return 0;
        int firstcoin=a[s]+ Math.min(optimalGamestrategy(s+2,e,a),optimalGamestrategy(s+1,e-1,a));
        int lastcoin=a[e]+Math.min(optimalGamestrategy(s,e-2,a),optimalGamestrategy(s+1,e-1,a));
        return Math.max(firstcoin,lastcoin);


    }

    public static int optimalGamestrategyMemoised( int s,int e, int []a,int[][]dp)
    {
        if(s>e)
            return 0;
        if(dp[s][e]!=-1)
            return dp[s][e];
        int firstcoin=a[s]+ Math.min(optimalGamestrategyMemoised(s+2,e,a,dp),optimalGamestrategyMemoised(s+1,e-1,a,dp));
        int lastcoin=a[e]+Math.min(optimalGamestrategyMemoised(s,e-2,a,dp),optimalGamestrategyMemoised(s+1,e-1,a,dp));
        dp[s][e]= Math.max(firstcoin,lastcoin);
return dp[s][e];

    }
}
