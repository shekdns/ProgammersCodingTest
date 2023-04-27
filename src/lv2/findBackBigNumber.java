package lv2;

import java.util.ArrayList;
import java.util.Arrays;

//뒤에 있는 큰 수 찾기
public class findBackBigNumber {
  public static class Solution {
    public int[] solution( int[] numbers ) {
      int[] answer = new int[numbers.length];
      //ArrayList<Integer> list = new ArrayList<>();
      int max = Arrays.stream( numbers ).max().getAsInt();
      for( int i = 0; i < numbers.length; i++ ) {
        if( i == numbers.length - 1 || numbers[i] >= max ) {
          answer[i] = -1;
        } else {
          int temp = numbers[i];
          boolean flag = false;
          for( int j = i + 1; j < numbers.length; j++ ) {
            if( temp < numbers[j] ) {
              answer[i] = numbers[j];
              flag = true;
              break;
            }
          }
          if( flag == false ) {
            answer[i] = -1;
          }
        }
      }
      //answer = list.stream().mapToInt( Integer::intValue ).toArray();
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] numbers1 = { 2, 3, 3, 5 };
    int[] numbers2 = { 9, 1, 5, 3, 6, 2 };

    int[] result = solution.solution( numbers2 );
    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}
