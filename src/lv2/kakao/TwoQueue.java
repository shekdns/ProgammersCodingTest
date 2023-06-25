package lv2.kakao;

import java.util.LinkedList;
import java.util.Queue;

//2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기
public class TwoQueue {
  public static int[] check = {};

  public static class Solution {
    public int solution( int[] queue1, int[] queue2 ) {
      int answer = 0;
      long total = 0;
      Queue<Long> queueOne = new LinkedList<>();
      Queue<Long> queueTwo = new LinkedList<>();
      long qot = 0;
      long qtt = 0;
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      for( int i = 0; i < queue1.length; i++ ) {
        total += queue1[i];
        total += queue2[i];
        qot   += queue1[i];
        qtt   += queue2[i];
        queueOne.add( Long.valueOf( queue1[i] ) );
        queueTwo.add( Long.valueOf( queue2[i] ) );
        if( queue1[i] > max1 ) {
          max1 = queue1[i];
        }
        if( queue2[i] > max2 ) {
          max2 = queue2[i];
        }
      }
      if( total % 2 != 0 ) {
        return -1;
      }
      long half = total / 2;

      if( max1 > half || max2 > half ) {
        return -1;
      }
      if( qot == qtt ) {
        return 0;
      }
      // 14 / 16 차이는 11 / 19 -> 15 15 poll add
      while( !queueOne.isEmpty() || !queueTwo.isEmpty() ) {
        long temp = 0;
        if( qot == qtt ) {
          break;
        }
        if( answer > (queueOne.size() + queueTwo.size()) * 2 ) {
          answer = -1;
          break;
        }
        if( qot > qtt ) {
          temp = queueOne.poll();
          queueTwo.add( temp );
          qot -= temp;
          qtt += temp;
          answer++;
        } else {
          temp = queueTwo.poll();
          queueOne.add( temp );
          qot += temp;
          qtt -= temp;
          answer++;
        }
      }
      // 11 19 21 25 26 27 28 실패
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] queue1 = { 3, 2, 7, 2 };
    int[] queue2 = { 4, 6, 5, 1 };

    int[] queue3 = { 1, 2, 1, 2 };
    int[] queue4 = { 1, 10, 1, 2};

    int[] queue5 = { 101, 100 };
    int[] queue6 = { 102, 103 };

    System.out.println( solution.solution( queue5, queue6 ) );
  }
}
