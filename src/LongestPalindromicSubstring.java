public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstringDp("abbaabbaabba"));
    }
    public static int longestPalindromicSubstringDp(String str)
    {       int ans=1;
        int n=str.length();
        boolean[][] dp = new boolean [n][n];
        for (int i = 0; i <n ; i++) {
            dp[i][i]=true;
        }
        for( int i=0;i<n-1;i++)
        {
            if( str.charAt(i)==str.charAt(i+1))
            {
                dp[i][i+1]=true;
                ans=2;
            }
        }
        for( int k=3;k<=n;k++)
        {
            for (int i = 0; i <=n-k ; i++)
            {
                int j=i+k-1;
                if( str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true)
                {
                    dp[i][j]=true;
                    ans=k;
                }

            }
        }
        return ans;
    }
}
