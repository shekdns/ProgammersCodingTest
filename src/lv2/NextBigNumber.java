package lv2;

public class NextBigNumber {
  public static class Solution {
    public int solution( int n ) {
      int answer = 0;
      int tCount = 0;
      int oCount = 0;
      String temp = "";
      String ori  = "";

      ori = Integer.toBinaryString( n );
      oCount = ori.replace( "0", "" ).length();

      while( true ) {
        n = n + 1;
        temp = Integer.toBinaryString( n );
        tCount = temp.replace( "0", "" ).length();

        if( oCount == tCount ) {
          answer = n;
          break;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n  = 78;
    int nn = 15;

    int result = solution.solution( nn );
    System.out.println( "RESULT = " + result );
  }
}
