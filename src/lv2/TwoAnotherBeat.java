package lv2;
//2개 이하의 다른 비트
public class TwoAnotherBeat {
  public static class Solution {
    //x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
    //비트가 1 또는 2 바로 나오면 Break
    public long[] solution( long[] numbers ) {
      long[] answer = new long[numbers.length];
      int idx=0;
      for(long num:numbers) {
        for(long i=1;;i*=2) {
          System.out.println( i );
          if((num&i)==0) { // (1)
            num = num + i; // (2)
            System.out.println( " 1 = " + num );
            num = num - (i/2); // (3)
            System.out.println( " 2 = " + num );
            break;
          }
        }
        answer[idx++]=num;
      }

      return answer;
    }

    static String bytesToBinaryString(Byte b) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < 8; i++) {
        builder.append(((0x80 >>> i) & b) == 0 ? '0' : '1');
      }

      return builder.toString();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    long[] param = { 2, 38 };
    long[] result = solution.solution( param );

    for( long l : result ) {
      System.out.print( l + " " );
    }
  }
}
/*
* long[] answer = new long[numbers.length];

      for( int i = 0; i < numbers.length; i++ ) {
        String byteString = bytesToBinaryString((byte) numbers[i]);
        long plus = 1;
        while( true ) {
          int count = 0;
          long temp = numbers[i] + plus;
          String checkBeatString = bytesToBinaryString((byte) temp );

          for( int j = 0; j < 8; j++ ) {
            Character c1 = byteString.charAt(j);
            Character c2 = checkBeatString.charAt(j);

            if( c1 != c2 ) {
              count++;
            }
          }

          if( count <= 2 ) {
            answer[i] = temp;
            break;
          }
          plus++;
        }
      }

      return answer;
*
*
*
*
*
* */