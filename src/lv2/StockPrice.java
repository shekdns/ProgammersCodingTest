package lv2;

//주식가격
public class StockPrice {
  public static class Solution {
    public int[] solution( int[] prices ) {
      int[] answer = new int[prices.length];

      //solution 1
//      for( int i = 0; i < prices.length; i++ ) {
//        for( int j = i + 1; j < prices.length; j++ ) {
//          answer[i] += 1;
//          System.out.println( "I = " + prices[i] + "  J = " + prices[j] );
//          if( prices[j] < prices[i] ) {
//            break;
//          }
//        }
//      }

      //solution 2 stack

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] prices = { 1, 2, 3, 2, 3 };  // 4 3 1 1 0
    int[] result = solution.solution( prices );

    for( int r : result ) {
      System.out.print( r + " " );
    }
  }
}
