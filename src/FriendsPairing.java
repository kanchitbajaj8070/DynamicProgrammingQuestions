import java.util.Arrays;

public class FriendsPairing {
 /*
 * Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.

Examples :

Input  : n = 3
Output : 4

Explanation
{1}, {2}, {3} : all single
{1}, {2, 3} : 2 and 3 paired but 1 is single.
{1, 2}, {3} : 1 and 2 are paired but 3 is single.
{1, 3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1, 2} and {2, 1} are considered same.
*/
    public static void main(String[] args) {
        int n=27;
        long e,f,g;
        e=System.currentTimeMillis();
        System.out.println(friendsPairing( n));
        f=System.currentTimeMillis();
        int[] memo= new int[n+1];
        Arrays.fill( memo,-1);
        memo[0]=0;
        System.out.println(friendsPairingMemo(n,memo));
        g=System.currentTimeMillis();
        System.out.println("recursion time "+(f-e)+" memoised time "+(g-f));
    }

    private static int friendsPairingMemo(int n, int[] memo) {

        if( n==1)
            return 1;
        if(n==0)
            return 0;
        if(n==2)
            return 2;
        if(memo[n]!=-1)
            return memo[n];
        int ans= friendsPairingMemo(n-1,memo)+((n-1)*friendsPairingMemo(n-2,memo));
        memo[n]=ans;
        return ans;

    }

    private static int friendsPairing(int n) {
        if( n==1)
            return 1;
        if(n==0)
            return 0;
        if(n==2)
            return 2;
        return friendsPairing(n-1)+((n-1)*friendsPairing(n-2));

    }
}
