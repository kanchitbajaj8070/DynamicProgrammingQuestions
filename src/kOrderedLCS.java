public class kOrderedLCS {
    /*A k-ordered LCS is defined to be the LCS of two sequences if you are allowed to
    change at most k elements in the first sequence to any value you wish to
    SAMPLE INPUT
    5 5 1
    1 2 3 4 5
    5 3 1 4 2
    SAMPLE OUTPUT
    3
    Explanation
    You can change the first element of the first
 sequence to 5 to get the LCS comprising of the sequence (5, 3, 4).*/

    public static void main(String[] args) {
        String a="1234565655";
        String b="531463254";
        int maxchanges=1;
        int[][][] dp=new int[a.length()][b.length()][maxchanges+1];
        for (int i = 0; i <a.length() ; i++) {
            for (int j = 0; j < b.length(); j++) {
                for (int k = 0; k <= maxchanges; k++) {
                    dp[i][j][k]=-1;
                }
            }
        }
        long e=0,f=0,g=0;
        e=System.currentTimeMillis();
        System.out.println(korderedLCSRecursive(a,b,0,0,1));
        f=System.currentTimeMillis();
        System.out.println("recursive  time "+(f-e));
        System.out.println(korderedLCSMemo(a,b,0,0,1,dp));
        g=System.currentTimeMillis();
        System.out.println("memoised time "+(g-f));
    }
    public static int korderedLCSRecursive( String a, String b , int i , int j , int k)
    {
        if( i==a.length()||j==b.length())
            return 0;
        if(a.charAt(i)==b.charAt( j))
        {
         return 1+korderedLCSRecursive(a,b,i+1,j+1,k);
        }
        else
        {// 3 options
            //1. replace(k-1)
            //2. and  3.normal LCS problem
            int replacingTheCurrenttCharacter=Integer.MIN_VALUE;
            if(k>0)
          replacingTheCurrenttCharacter=korderedLCSRecursive(a,b,i+1,j+1,k-1)+1;
            int matchingCurrentCharacterWithSomeOTherStringOfB=korderedLCSRecursive(a,b,i,j+1,k);
            int mathcingSomeOtherStrignOfaWithb=korderedLCSRecursive(a,b,i+1,j,k);
            return Math.max(matchingCurrentCharacterWithSomeOTherStringOfB,Math.max(replacingTheCurrenttCharacter,mathcingSomeOtherStrignOfaWithb));

        }


    }
    public static int kOrderedLCS3Ddp(String a, String b , int k)
    {
        int [][][]dp= new int[a.length()+1][b.length()+1][k];

return 0;
    }

    public static int korderedLCSMemo( String a, String b , int i , int j , int k,int[][][]dp)
    {
        if( i>=a.length()||j>=b.length())
            return 0;
        if(dp[i][j][k]!=-1)
            return dp[i][j][k];
        int res=Integer.MIN_VALUE;
        if(a.charAt(i)==b.charAt( j))
        {
          res=1+korderedLCSMemo(a,b,i+1,j+1,k,dp);

        }
        else
        {// 3 options
            //1. replace(k-1)
            //2. and  3.normal LCS problem
            int replacingTheCurrenttCharacter=Integer.MIN_VALUE;
            if(k>0)
            replacingTheCurrenttCharacter=korderedLCSMemo(a,b,i+1,j+1,k-1,dp)+1;
            int matchingCurrentCharacterWithSomeOTherStringOfB=korderedLCSMemo(a,b,i,j+1,k,dp);
            int mathcingSomeOtherStrignOfaWithb=korderedLCSMemo(a,b,i+1,j,k,dp);
          res= Math.max(matchingCurrentCharacterWithSomeOTherStringOfB,Math.max(replacingTheCurrenttCharacter,mathcingSomeOtherStrignOfaWithb));

        }
        dp[i][j][k]=res;
        return res;

    }

}
