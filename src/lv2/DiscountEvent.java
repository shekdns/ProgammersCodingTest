package lv2;

import java.util.*;

//할인 행사
public class DiscountEvent {
//  문제를 읽어보면 10일동안 할인 적용시에 원하는 물품을 구입할 수 있는 날의 개수를 구하라고 했습니다.
//  최소 일자가 아니라, 가능한 날의 개수입니다!
  public static class Solution {
    public int solution( String[] want, int[] number, String[] discount ) {
      int answer = 0;

      HashMap<String, Integer> map = new HashMap<>();
      LinkedList<String> list = new LinkedList<>( Arrays.asList( discount ) );

      for( int i = 0; i < want.length; i++ ) {
        map.put( want[i], number[i] );
      }

      int size = list.size() - 9;

      for( int i = 0; i < size; i++ ) {
        HashMap<String,Integer> cloneMap = (HashMap<String, Integer>) map.clone();
        int temp = 10;
        int count = list.size() >= 10 ? 10 : list.size();

        for( int j = 0; j < count; j++ ) {
          if( cloneMap.containsKey( list.get( j ) ) ) {
            cloneMap.put( list.get( j ), cloneMap.getOrDefault( list.get( j ), 0 ) - 1 );
            temp = temp - 1;
          }
        }

        boolean flag = true;
        for(Map.Entry<String, Integer> entry : cloneMap.entrySet() ) {
          if( entry.getValue() != 0 ) {
            flag = false;
            break;
          }
        }
        System.out.println( cloneMap );
        if( flag == true ) {
          answer++;
        }

        list.remove( 0 );
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] want1 = { "banana", "apple", "rice", "pork", "pot" };
    int[] number1  = { 3, 2, 2, 2, 1 };
    String[] discount1 = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" };

    String[] want2 = { "apple" };
    int[] number2  = { 10 };
    String[] discount2 = { "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana" };

    int result = solution.solution( want1, number1, discount1 );

    System.out.println( "RESULT = " + result );
  }
}
