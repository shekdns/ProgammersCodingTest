package lv2.kakao;

import java.util.LinkedList;
import java.util.Queue;

//2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기
public class TwoQueue {
  public static int[] check = {};

  public static class Solution {
    public int solution( int[] queue1, int[] queue2 ) {
      int answer = 0;
      int total = 0;
      Queue<Integer> queueOne = new LinkedList<>();
      Queue<Integer> queueTwo = new LinkedList<>();
      int qot = 0;
      int qtt = 0;
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      for( int i = 0; i < queue1.length; i++ ) {
        total += queue1[i];
        total += queue2[i];
        qot   += queue1[i];
        qtt   += queue2[i];
        queueOne.add( queue1[i] );
        queueTwo.add( queue2[i] );
        if( queue1[i] > max1 ) {
          max1 = queue1[i];
        }
        if( queue2[i] > max2 ) {
          max2 = queue2[i];
        }
      }
      int half = total / 2;

      if( max1 > half || max2 > half ) {
        return -1;
      }
      if( qot == qtt ) {
        return 0;
      }
      // 14 / 16 차이는 11 / 19 -> 15 15 poll add
      while( true ) {
        int temp = 0;
        if( qot == qtt ) {
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

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] queue1 = { 3, 2, 7, 2 };
    int[] queue2 = { 4, 6, 5, 1 };

    int[] queue3 = { 1, 2, 1, 2 };
    int[] queue4 = { 1, 10, 1, 2};

    int[] queue5 = { 1, 1 };
    int[] queue6 = { 1, 5 };

    System.out.println( solution.solution( queue5, queue6 ) );
  }
}
