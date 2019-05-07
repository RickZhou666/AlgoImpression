package google;

import java.util.Arrays;

public class H354_RussianDollEnvelopes {
	
	public static void main ( String args[] ) {
		int[][] envelopes = { {5, 4}, {6, 4}, {6, 7}, {2, 3} };
		H354_RussianDollEnvelopes ob = new H354_RussianDollEnvelopes();
		System.out.println( ob.maxEnevelopes(envelopes) );
	}
	
	public int maxEnevelopes ( int[][] envelopes ) {
		Arrays.sort( envelopes, (a, b) -> ( a[0] == b[0] ? b[1] - a[1] : a[0] - b[0] ) );
		
		int[] dp = new int[ envelopes.length ];
		int max = 0;
		for ( int[] en : envelopes ) {
		/**	int idx = Arrays.binarySearch(a, fromIndex, toIndex, key);
			
			index of the search key, if it is contained in the array; 
			otherwise, (-(insertion point) - 1). 
			
		**/
			int idx = Arrays.binarySearch(dp, 0, max, en[1]);
			if ( idx < 0 )
				idx = -( idx + 1 );
			
			dp[idx] = en[1];
			if ( idx == max )
				max++;
		}
		
		return max; // the length
	}
}
