import java.util.Arrays;
import java.util.Random;

public class Wine2dDpProblem {

    public static void main(String[] args) {
        int[] a={1,4,2,3};
        int i=0;
        int years=1;
       long t1=System.currentTimeMillis();
        System.out.println(maxCostSellingWineRecursive(a,0,a.length-1,years));
        long t2=System.currentTimeMillis();
        System.out.println("time 1"+(t2-t1));
        int[][]dp= new int[a.length][a.length];
        for(int[]d:dp)
            Arrays.fill(d,-1);
        System.out.println(maxCostSellingWinrMemoized(a,0,a.length-1,years,dp));
        long t3=System.currentTimeMillis();
        System.out.println("time is"+ (t3-t2));
        System.out.println(maxCostDpSolution(a));
        long t4=System.currentTimeMillis();
        System.out.println("dp time "+(t4-t3));
    }
    public static int maxCostSellingWineRecursive(  int []a,int s, int e,int years)
    {
    if( s>e|| years> a.length)
        return 0;
    int pickFirst = a[s]*years+maxCostSellingWineRecursive(a,s+1,e,years+1);
    int pickLast=a[e]*years+maxCostSellingWineRecursive(a,s,e-1,years+1);
    return Math.max(pickFirst,pickLast);
    }
    public static int maxCostSellingWinrMemoized( int [] a, int s, int e, int years,int[][]dp)
    {
        if( s>e|| years> a.length)
            return 0;
        if(dp[s][e]!=-1)
            return dp[s][e];
        int pickFirst = a[s]*years+maxCostSellingWineRecursive(a,s+1,e,years+1);
        int pickLast=a[e]*years+maxCostSellingWineRecursive(a,s,e-1,years+1);
       int ans=Math.max(pickFirst,pickLast);
       dp[s][e]=ans;
       return ans;
    }
    public static int maxCostDpSolution( int [] wines) {
        int[][] dp = new int[wines.length + 1][wines.length + 1];
        int years = wines.length;
        int start = 1;
        while (years>0) {
            int i = 1;
            int j = start;
            while (i < wines.length && j <= wines.length) {//i< condition imp to remember
                int a1=0;
                int a2=0;
                a1=dp[i][j - 1] + wines[j - 1] * years;
                a2=dp[i + 1][j] + wines[i - 1] * years;
                dp[i][j] =Math.max(a1,a2);
                i++;
                j++;
            }
            start++;
            years--;
        }
        for (int i = 0; i <= wines.length; i++) {
            for (int j = 0; j <=wines.length ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    return dp[1][wines.length];
    }

    }


