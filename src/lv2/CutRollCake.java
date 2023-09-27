package lv2;

import java.util.HashSet;
//롤케이크 자르기
/*
* 철수행님이 먼저 토핑들을 전부 다 차지해버린다.

동생님이 뒤로 입장하여, 철수행님이 차지한 토핑들을 하나씩 뺏어버린다.

동생이 뺏을 때마다, 각자 가지고 있는 토핑의 종류가 같은지 확인한다.

같다면 답을 추가한다.

해시를 사용하면 시간이 아주 나이스하게 빨라진다.
*
* */
public class CutRollCake {
  public static class Solution {
    public int solution( int[] topping ) {
      int answer = 0;

      int position = 1;
      for( int i = 0; i < topping.length; i++ ) {
        HashSet<Integer> leftSet  = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();

        for( int j = 0; j < position; j++ ) {
          leftSet.add( topping[j] );
        }
        for( int j = position; j < topping.length; j++ ) {
          rightSet.add( topping[j] );
        }
        position++;
        if( leftSet.size() == rightSet.size() ) {
          answer++;
        }
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] topping_1 = { 1, 2, 1, 3, 1, 4, 1, 2 };
    int[] topping_2 = { 1, 2, 3, 1, 4 };

    System.out.println( "RESULT = " + solution.solution( topping_1 ) );
  }
}
