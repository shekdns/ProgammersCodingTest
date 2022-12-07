package lv2.kakao;
//2022 KAKAO BLIND RECRUITMENT k진수에서 소수 개수 구하기
public class FindK {
  public static class Solution {
    public int solution( int n, int k ) {
      int answer = 0;

      StringBuilder sb = new StringBuilder();
      while( true ) {
        int t = n % k;
        sb.append( String.valueOf(t) );

        if( n < k ) {
          break;
        }

        n = n / k;
      }

      String temp = sb.reverse().toString().replaceAll( "0", " " );
      // 소수가 되는 조건
      // 1. 0P0 처럼 소수 양쪽에 0이 있는 경우
      // 2. P0 처럼 소수 오른쪽에만 0이 있고 왼쪽에는 없는 경우
      // 3. 0P 처럼 소수 왼쪽에만 0이 있고 오른쪽에는 없는 경우
      // 4. P처럼 소수 양쪽에 아무것도 없는 경우
      // 예외 : 101은 소수가 아님 0을 다날려라?
      System.out.println( "temp = " + temp );
      String[] split = temp.split( " " );

      for( int i = 0; i < split.length; i++ ) {
        System.out.println( "S = " + split[i] );
        if( split[i].equals( "1" ) || split[i].equals( "" ) ) {
          continue;
        }
        if( split[i].equals( "2" ) || split[i].equals( "3" ) ) {
          answer++;
          continue;
        }
        boolean flag = true;
        System.out.println( "MATH1 = " + (long)Math.sqrt( Long.parseLong( split[i] ) ) );
        System.out.println( "MATH2 = " + (long)Math.sqrt( Long.parseLong( split[i] ) ) + 1 );
        for( int j = 3; j < (long)Math.sqrt( Long.parseLong( split[i] ) ) + 1; j++  ) {
          if( Long.parseLong( split[i] ) % j == 0 ) {
            flag = false;
            break;
          }
        }

        if( flag == true ) {
          answer++;
        }
//        if( Long.parseLong( split[i] ) % 2 == 0 ) {
//          continue;
//        } else {
//          answer++;
//        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n1 = 437674;
    int k1 = 3;
    int n2 = 110011;
    int k2 = 10;

    int result = solution.solution( n2, k2 );
    System.out.println( "RESULT = " + result );
  }
}
