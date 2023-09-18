package lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//호텔 대실
public class HotelReservation {
  public static class Solution {
    public int solution( String[][] book_time ) throws ParseException {
      int answer = 0;

      List<HashMap<String,Integer>> list = new ArrayList<>();
      SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm" );
      Date date = new Date();
      Calendar cal = Calendar.getInstance();

      for( int i = 0; i < book_time.length; i++ ) {
        HashMap<String, Integer> map = new HashMap<>();
        String st = book_time[i][0];
        String et = book_time[i][1];

        date = sdf.parse( et );
        cal.setTime( date );
        cal.add( Calendar.MINUTE, 10 );
        String parseEt = sdf.format( cal.getTime() );

        map.put( "start", Integer.parseInt( st.replace( ":", "" ) ) );
        map.put( "end", Integer.parseInt( parseEt.replace( ":", "" ) ) );

        list.add( map );
      }
      list.sort( Comparator.comparing( ( Map<String, Integer> map ) -> map.get( "start" ) )  );
      System.out.println( "LIST = " + list );
      int count = 1;
      Map<Integer, Integer> room = new HashMap<>();
      for( Map<String, Integer> map : list ) {
        if( room.isEmpty() == true ) {
          room.put( count, map.get( "end" ) );
        } else {
          boolean flag = false;
          for( Map.Entry<Integer, Integer> entry : room.entrySet() ) {
            int roomNum = entry.getKey();
            int endTime = entry.getValue();
            if( map.get( "start" ) >= endTime ) {
              room.put( roomNum, map.get( "end" ) );
              flag = true;
              break;
            }
          }
          if( flag == false ) {
            count++;
            room.put( count, map.get( "end" ) );
          }
        }
      }

      answer = room.size();
      return answer;
    }
  }

  public static void main(String[] args) throws ParseException {
    Solution solution = new Solution();
    String[][] book_time1 = { {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"} };
    String[][] book_time2 = { {"09:10", "10:10"}, {"10:20", "12:50"} };
    String[][] book_time3 = { {"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"} };

    System.out.println( solution.solution( book_time3 ) );
  }
}
