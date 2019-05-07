package google;
/**
----H042
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6 
 **/
public class H042_TrappingRainWater {

	
	// 1ms, beat 99.93%
	public int trappingRainWater ( int[] trap ) {
		int lmax = trap[0], rmax = trap[ trap.length - 1 ];
		int i = 0, j = trap.length - 1;
		int ans = 0;
		
		while ( i <= j ) {
			if ( trap[i] < trap[j] ) { // the right bound is ok, check left bound
				if ( trap[i] < lmax )
					ans += lmax - trap[i];
				lmax = Math.max( lmax, trap[i] );
			} else {				// the left bound is ok, check right bound
				if ( trap[j] < rmax )
					ans += rmax - trap[j];
				rmax = Math.max( rmax, trap[j] );
			}
		}
		
		return ans;
		
	}
	
}
