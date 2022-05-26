package lv2;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Siritori {
  public static class Solution {
    public int[] solution( int n, String[] words ) {
      int[] answer;
      answer = new int[2];
      int count = 1;
      int turn  = 1;

      LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

      for( int i = 0; i < words.length; i++ ) {
        if( map.containsKey( words[i] ) == true ) {
          map.put( "answer", count );
          break;
        }

        if( i != 0 ) {
          String s1 = words[i - 1].substring(words[i - 1].length() - 1);
          String s2 = words[i].substring( 0, 1 );

          if ( !s1.equals(s2) ) {
            map.put( "answer", count );
            break;
          }
        }
        map.put( words[i], count );

        if( n - count == 0 ) {
          count = 0;
          turn++;
        }
        count++;

        if( i == words.length - 1 ) {
          map.put( "pass", 0 );
        }
      }

      System.out.println( map );

      if( map.containsKey( "pass" ) == true ) {
        answer[0] = 0;
        answer[1] = 0;
      } else {
        int number = map.get( "answer" );

        answer[0] = number;
        answer[1] = turn;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n1 = 3;
    int n2 = 2;

    String[] words1 = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
    String[] words2 = { "hello", "one", "even", "never", "now", "world", "draw" };

    int[] result = solution.solution( n2 , words2 );
    for( int v : result ) {
      System.out.print( v + " " );
    }
  }
}
