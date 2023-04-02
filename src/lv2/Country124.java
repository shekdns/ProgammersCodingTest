package lv2;
//124 나라의 숫자
public class Country124 {
  public static class Solution {
    public String solution( int n ) {
      String answer = "";
      int t = n;
      int temp = 0;

      while( t != 0 ) {
        temp = t % 3;
        t    = t / 3;

        System.out.println( " N = " + n );
        System.out.println( " T = " + temp );
        if( temp == 0 ) {
          answer = "4" + answer;
          t--;
        } else if( temp == 1 ) {
          answer = "1" + answer;
        } else {
          answer = "2" + answer;
        }
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 10;

    String result = solution.solution( n );
    System.out.println( "RESULT = " + result );
  }
}
