package lv2;

import java.util.LinkedHashMap;

//모음사전
public class VowelDictionary {
  public static class Solution {
    public int solution( String world ) {
      int answer = 0;
      String array[] = { "A", "E", "I", "O", "U" };
      LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
      map.put( "A", 1 );
      map.put( "E", 2 );
      map.put( "I", 3 );
      map.put( "O", 4 );
      map.put( "U", 5 );

      LinkedHashMap<Integer, Integer> disMap = new LinkedHashMap<>();
      disMap.put( 0, 781 );
      disMap.put( 1, 156 );
      disMap.put( 2, 31 );
      disMap.put( 3, 6 );
      disMap.put( 4, 1 );

      if( world.equals( "A" ) || world.equals( "AA") || world.equals( "AAA") || world.equals( "AAAA") || world.equals( "AAAAA") ) {
        return world.length();
      }

      for( int i = 0; i < world.length(); i++ ) {
        Character ch = world.charAt( i );
        int t = 1 + ( disMap.get( i ) * ( map.get( ch.toString() ) - 1 ) );
        answer += t;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String word = "AAAAA";
    int result  = solution.solution( word );
    System.out.println( "RESULT = " + result );
  }
}
