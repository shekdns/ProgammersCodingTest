package lv4;

public class WordPuzzle {
  public static class Solution {
    public int solution( String[] strs, String t ) {
      int answer = 0 ;
      answer = Integer.MAX_VALUE;
      int[] array = new int[t.length()];

      for( int i = 1; i < t.length() + 1; i++ ) {
        for( int j = 0; j < strs.length; j++ ) {
          String temp = strs[j];
          if( i - temp.length() < 0 ) {
            continue;
          }
          if( temp.equals( t.substring( i - temp.length(), i ) ) ) {
            if( i - temp.length() == 0 ) {
              array[i - 1] = 1;
              continue;
            }
            if( array[i-temp.length() - 1] > 0 ) {
              array[i - 1] = array[i - 1] == 0 ? array[i - temp.length() - 1] + 1 : Math.min( array[i - 1], array[i - temp.length() - 1] + 1 );
            }
          }
        }
      }

      if( array[array.length - 1] == 0 ) {
        answer = -1;
      } else {
        answer = array[array.length - 1];
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strs = { "ba", "na", "n", "a" };
    String t = "banana";

    int result = solution.solution( strs, t );

    System.out.println( "RESULT = " + result );

  }
}
