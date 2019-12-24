import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a= {33,22,11,6,44,9,14,15,17,1,20};//6 ans
        System.out.println(lisDp(a));
        System.out.println(lisRecursive(a));
    }
    public static int lisDp( int []arr)
    {
        int n=arr.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            int ans=1;
            for (int j = 0; j < i; j++) {

                if( arr[j]<=arr[i])
                    ans=Math.max(ans,dp[j]+1);

            }
            dp[i]=ans;
        }
        int max=1;
        for( int a:dp)
        {
            max=Math.max(max,a);
        }
        if(max==1)
        return -1;
        else return max;
    }
    public static int lisRecursive( int []arr)
    {
        int best=0;
        for (int j = 0; j <arr.length-1; j++) {
            best=Math.max(best,maxLis( arr,j,j+1));
        }
        return best;

    }

    private static int maxLis(int[] arr, int i,int j) {
        if( j>=arr.length)
            return 0;
        if(arr[j]>=arr[i])
            return 1+maxLis(arr,i,j+1);
        else return maxLis(arr,i,j+1);


    }
}
