package lv2;

public class N2Array {
  public static class Solution {
    public int[] solution( int n, long left, long right ) {
      int[] answer = new int[ (int)right - (int)left + 1 ];

//      3x3 행렬일 때
//      (1,1) = 1 (1,2) = 2 (1,3) = 3
//      (2,1) = 2 (2,2) = 2 (2,3) = 3
//      (3,1) = 3 (3,2) = 3 (3,3) = 3
//
//      간단하게 각 좌표 x, y 값중 큰 값이 해당 값이 됩니다.
//      이제 주어지는 left ~ right 1차원 index 값을, 2차원 인덱스(x, y) 값으로 변환만

      int ltY = (int) ( left / n );
      int ltX = (int) ( left %  n );
      int rtY = (int) ( right / n );
      int rtX = (int) ( right % n );

      System.out.println( "ltY = " + ltY );
      System.out.println( "ltX = " + ltX );
      System.out.println( "rtY = " + rtY );
      System.out.println( "rtX = " + rtX );

      int k = 0;
//      for( int i = ltY; i <= rtY; i++ ) {
//        if( i == ltY ) {
//          int t = ( ltX >= rtX ) ? ltX : rtX;
//          t = ( t >= n - 1 ) ? t : n - 1;
//          for( int j = ltX; j <= t; j++ ) {
//            answer[k++] = ( i >= j ) ? i + 1 : j + 1;
//          }
//        } else if( i == rtY ) {
//          for( int j = 0; j <= rtX; j++ ) {
//            answer[k++] = ( i >= j ) ? i + 1 : j + 1;
//          }
//        } else {
//          for( int j = 0; j < n; j++ ) {
//            answer[k++] = ( i >= j ) ? i + 1 : j + 1;
//          }
//        }
//      }
      for( int i = 0; i < answer.length; i++ ) {
        int x = (int) ( left / n + 1 );
        int y = (int) ( left % n + 1 );
        answer[i] = ( x >= y ) ? x : y;
        left++;
      }

//      int num = 0;
//      int k = 0;
//      for( int i = 1; i <= (int)left; i++ ) {
//        for( int j = 1; j <= (int)right; j++ ) {
//          if( num >= left && num <= right ) {
//            answer[k++] = ( i >= j ) ? i : j;
//          }
//          num++;
//        }
//      }

//(left - n) ~ (right + n)
//      for( int i = 0; i < n; i++ ) {
//        int num = i + 1;
//        for( int j = 0; j < n; j++ ) {
//          if( i == 0 ) {
//            num = j + 1;
//          } else if( i == ( n - 1 ) ) {
//            num = n;
//          } else {
//            if( j > i ) {
//              num++;
//            }


//          }
//          arrayList.add( num );
//        }
//      }
//
//      int j = 0;
//      for( int i = (int)left; i <= (int)right; i++ ) {
//        answer[j++] = arrayList.get(i);
//      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 4;
    long left = 7;
    long right = 14;

    int[] result = solution.solution( n, left, right );

    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}
