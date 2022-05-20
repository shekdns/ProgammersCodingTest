package lv2;

import java.util.Arrays;
import java.util.HashMap;

public class PhonNumberCategory {
  public static class Solution {
    public boolean solution( String[] phone_book ) {
      boolean answer = true;
      HashMap<String, Integer> map = new HashMap<>();

      for( int i = 0; i < phone_book.length; i++ ) {
        map.put( phone_book[i], i );
      }

      for( int i = 0; i < phone_book.length; i++ ) {
        for( int j = 1; j < phone_book[i].length(); j++ ) {
          if( map.containsKey( phone_book[i].substring( 0, j ) ) ) {
            System.out.println( "해석 " + phone_book[i].substring( 0, j ) + " | " + j );
            return false;
          }
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    //있는 경우 false 없는 경우 true
    Solution solution = new Solution();
    String[] phone_book1 = { "119", "97674223", "1195524421" };   //false
    String[] phone_book2 = { "123","456","789" };                 //true
    String[] phone_book3 = { "12","123","1235","567","88" };      //false

    boolean result = solution.solution( phone_book3 );

    System.out.println( "RESULT = " + result );
  }
}
