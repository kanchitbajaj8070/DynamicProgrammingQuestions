public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstringDp("abbaabbaabba"));
        System.out.println(LPSSpaceOptimisedSolution("geeksskeekclvfmfj"));
    //O(1) space
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

    public static int LPSSpaceOptimisedSolution( String str)
    {
        // with each element as center calculate the max even and odd length
        //palindromes possible;
        int s=0;
        int e=1;//start and ending of the max length substring
        int maxLength=1;
        int n=str.length();
        for (int i = 1; i <n ; i++) {

            //even length palindromes
            int low =i-1;
            int high =i;
            int ans=0;
            while(low>=0&& high<n)
            {
                if(str.charAt(low)== str.charAt(high))
                {
                    ans+=2;
                    if(ans> maxLength) {
                        maxLength = ans;
                        s=low;
                        e=high;
                    }low--;
                    high++;
                }
                else break;
            }
        }

        //odd length with i as center
        for (int i = 1; i <n-1 ; i++) {

            int low =i-1;
            int high=i+1;
            int ans=1;


            while( low>=0&& high< n)
            {
                if(str.charAt( low)==str.charAt( high))
                {
                    ans+=2;
                    if(ans>maxLength) {
                        maxLength = Math.max(ans, maxLength);
                        s=low;
                        e=high;
                    }low--;
                    high++;
                }
                else
                    break;
            }

        }
        System.out.println(str.substring(s,e+1));
        return maxLength;
    }
}
