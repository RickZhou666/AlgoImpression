package google;
import java.util.*;
public class H269_AlienDictionary {
	
	public static void main ( String args[] ) {
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		H269_AlienDictionary ob = new H269_AlienDictionary();
		System.out.println( ob.alienOrder(words) );
	}
	
	public String alienOrder( String[] words ) {
		Map<Character, HashSet<Character>> map = new HashMap<>();
		Map<Character, Integer> degree = new HashMap<>();
		for ( String s : words ) {
			for ( char c : s.toCharArray() ) {
				map.put( c, new HashSet<>() );
				degree.put(c, 0);
			}
				
		}
		
		for ( int k = 0; k < words.length - 1; k++ ) {
			String s1 = words[k], s2 = words[k + 1];
			int len = Math.min( s1.length(), s2.length() );
			for ( int i = 0; i < len; i++ ) {
				char c1 = s1.charAt(i), c2 = s2.charAt(i);
				if ( c1 == c2 ) continue;
				if ( !map.get(c1).contains(c2) ) {
					map.get(c1).add( c2 );
					degree.put(c2,  degree.get(c2) + 1);
				}
				break;
			}
		}
		
		Queue<Character> q = new LinkedList<>();
		for ( char c : degree.keySet() ) {
			if ( degree.get(c) == 0 ) {
				q.add( c );
			}
		}
		
		// each char's hashSet is single char
		String ans = "";
		while ( !q.isEmpty() ) {
			char c = q.poll();
			ans += c;
			if ( map.containsKey(c) ) {
				for ( char tmp : map.get( c ) ) {
					degree.put(tmp, degree.get(tmp) - 1);
					if ( degree.get(tmp) == 0 ) q.add( tmp);
				}
			}
		}
		
		return ans.length() == degree.size() ? ans : "";
	}
}
