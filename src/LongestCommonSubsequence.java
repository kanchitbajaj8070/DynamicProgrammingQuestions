public class LongestCommonSubsequence {
    public static void main(String[] args) {

        System.out.println(LCSdp("saturday","sunday"));
    }

    public static int  LCSRecursive(String a, String b, int i, int j) {
 if(i==a.length()||j==b.length())
     return 0;
 if(a.charAt(i)==b.charAt(j))
     return 1+LCSRecursive(a,b,i+1,j+1);
 else
 {
     int leavingOfA= LCSRecursive(a,b,i+1,j);
     int leavingOfB= LCSRecursive(a,b,i,j+1);
     return Math.max(leavingOfA,leavingOfB);
 }

    }
    public static int LCSdp( String a, String b)
    {
        int n=a.length();
        int m=b.length();
        int [][]dp= new int[n+1][m+1];
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i <=m ; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
               if(a.charAt(i-1)==b.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
               else
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    return dp[n][m];}

}