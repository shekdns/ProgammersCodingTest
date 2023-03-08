package lv2;

//N개의 최소공배수
public class NLeastCommonMultiple {

  public static class Solution {
    public int solution( int[] arr ) {
      int answer = 0;

      int max = arr[arr.length - 1];

      int i = 1;
      while( true ) {
        int temp = max * i;
        boolean flag = true;

        for( int j = 0; j < arr.length - 1; j++ ) {
          if( temp % arr[j] != 0 ) {
            flag = false;
          }
        }

        if( flag == true ) {
          answer = temp;
          break;
        }
        i++;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = { 2, 6, 8, 14 };
    int result = solution.solution( arr );

    System.out.println( "RESULT = " + result );
  }
}
