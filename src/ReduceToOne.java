import java.util.ArrayList;
import java.util.Arrays;

public class ReduceToOne {
    public static void main(String[] args) {
        int no=999;
       long s= System.currentTimeMillis();
        System.out.println(stepsToreducetoOneRecursive(no));
        long e=System.currentTimeMillis();
        System.out.println("time recursive is"+ (e-s));

        int [] memo= new int[no+1];
        Arrays.fill(memo,-1);
        System.out.println(stepsToreducetoOneMemoized(no,memo));
        long f= System.currentTimeMillis();
        System.out.println("time memo is "+ (f-e));
        System.out.println(dpsolution(no));
        long g= System.currentTimeMillis();
        System.out.println("time dp is "+ (g-f));
    }
    public static int stepsToreducetoOneRecursive( int no)
    {
        if(no<=1)
            return 0;
        else
        {
            int steps1=Integer.MAX_VALUE;
            if(no%3==0)
            steps1=stepsToreducetoOneRecursive( no/3);
            int steps2=Integer.MAX_VALUE;
            if(no%2==0)
                steps2=stepsToreducetoOneRecursive(no/2);
            int steps3=stepsToreducetoOneRecursive(no-1);
            return 1+Math.min( steps1,Math.min(steps2,steps3));
        }

    }
    public static int stepsToreducetoOneMemoized( int no,int[] memo)
    {
        if(no<=1)
            return 0;
        else
        {
            if( memo[no]!=-1)
                return memo[no];
            int steps1=Integer.MAX_VALUE;
            if(no%3==0)
                steps1=stepsToreducetoOneRecursive( no/3);
            int steps2=Integer.MAX_VALUE;
            if(no%2==0)
                steps2=stepsToreducetoOneRecursive(no/2);
            int steps3=stepsToreducetoOneRecursive(no-1);
            int ans= 1+Math.min( steps1,Math.min(steps2,steps3));
        memo[no]=ans;
        return ans;
        }

    }
    public static int dpsolution(int no)
    {
        int []dp= new int[no+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <=no ; i++) {
            int ans1=Integer.MAX_VALUE;
            int ans2=Integer.MAX_VALUE;
            int ans3=Integer.MAX_VALUE;
        if(i%3==0)
            ans1=dp[i/3];
        if(i%2==0)
            ans2=dp[i/2];
        ans3=dp[i-1];
        dp[i]=1+Math.min( ans1,Math.min(ans2,ans3));

        }
        return dp[no];
    }
}
/*999
8
time recursive is65
8
time memo is 67
8
time dp is 1*/