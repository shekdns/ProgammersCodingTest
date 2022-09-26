package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class StackTruck {
  public static class Solution {
    public int solution( int bridge_length, int weight, int[] truck_weights ) {
      int count = 0;

      Queue<Integer> queue = new LinkedList<>();

      int i = 0;
      int qCount = 0;
      while( i < truck_weights.length ) {
        if (i == 0) {
          queue.add(truck_weights[i]);
          qCount++;
          count++;
          i++;
          continue;
        } else {
          if( qCount == bridge_length ) {
            queue.poll();
            qCount = 1;
            count++;
            queue.add( truck_weights[i] );
            i++;
            continue;
          }
          int qp = queue.peek() == null ? 0 : queue.peek();
          System.out.println( "QP = " + qp );
          int w = weight - qp;
          if( truck_weights[i] > w ) {
            qCount++;
            count++;
            continue;
          } else {
            queue.add( truck_weights[i] );
            qCount++;
            count++;
            continue;
          }
        }
      }
      return count;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int bridge_length = 2;
    int weight = 10;
    int[] truck_weights = { 7, 4, 5, 6 };

    int a = 100;
    int b = 100;
    int[] c = { 10 };

    //int result = solution.solution( bridge_length, weight, truck_weights );
    int result = solution.solution( a, b, c );
    System.out.println( "RESULT = " + result );
  }
}
