package lv2.kakao;

import java.util.*;

public class CarParkingCal {
  public static class Solution {
    public int[] solution( int[] fees, String[] records ) {
      int[] answer;

      int baseTime    = fees[0];
      int baseMoney   = fees[1];
      int danYee      = fees[2];
      int danYeeMoney = fees[3];

      HashMap<String, String> map = new HashMap<>();

      for( int i = 0; i < records.length; i++ ) {
        String[] split = records[i].split( " " );
        String time      = split[0];
        String carNumber = split[1];

        time = time.replace( ":", "" );

        if( i == 0 ) {
          map.put( carNumber, time + " " );
        } else {
          map.put( carNumber, map.getOrDefault( carNumber, "" ) + time + " " );
        }
      }

      String[] temp = new String[map.size()];
      answer = new int[map.size()];
      int count = 0;
      for( Map.Entry<String, String> entry : map.entrySet() ) {
        temp[count++] = entry.getKey();
      }

      Arrays.sort( temp );

      HashMap<String, Integer> newMap = new HashMap<>();

      for( Map.Entry<String, String> entry : map.entrySet() ) {
        String key     = entry.getKey();
        String[] split = entry.getValue().split( " " );
        int length = split.length;
        int total  = 0;
        int value = 0;

        if( split.length % 2 != 0 ) {
          split = Arrays.copyOf( split, length + 1 );
          split[length] = "2359";
        }

        for( int i = 0; i < split.length; i++ ) {
          if( i % 2 != 0 ) {
            int inTime  = ( Integer.parseInt( split[i - 1].substring( 0, 2 ) ) * 60 ) + Integer.parseInt( split[i - 1].substring( 2, 4 ) );
            int outTime = ( Integer.parseInt( split[i].substring( 0, 2 ) ) * 60 ) + Integer.parseInt( split[i].substring( 2, 4 ) );

            total += outTime - inTime;
          }
        }

        if( total > baseTime ) {
          double round = (double) total - baseTime;
          value = baseMoney + ( (int)Math.ceil( round / danYee ) ) * danYeeMoney;
        } else {
          value = baseMoney;
        }
        newMap.put( key, value );
      }

      for( int i = 0; i < temp.length; i++ ) {
        answer[i] = newMap.get( temp[i] );
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    //기본 180 기본 요금 5000 단위 10 단위 요금 600
    //차량 번호가 적은 수 부터
    int[] fees  = { 180, 5000, 10, 600 };
    int[] fees2 = { 1, 461, 1, 10 };
    int[] fees3 = { 120, 0, 60, 591 };
    String[] records = { "05:34 5961 IN",
                         "06:00 0000 IN",
                         "06:34 0000 OUT",
                         "07:59 5961 OUT",
                         "07:59 0148 IN",
                         "18:59 0000 IN",
                         "19:09 0148 OUT",
                         "22:59 5961 IN",
                         "23:00 5961 OUT" };


    String[] records2 = { "00:00 1234 IN" };

    String[] records3 = { "16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN" };
    Solution solution = new Solution();

    int[] result = solution.solution( fees, records );

    for( int money : result ) {
      System.out.println( money );
    }

  }
}
