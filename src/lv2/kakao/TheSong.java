package lv2.kakao;

import java.util.ArrayList;
//방금그곡
public class TheSong {
  public static class Solution{
    public ArrayList<String> changeMelodie( String m  ) {
      ArrayList<String> arrayList = new ArrayList<>();

      int temp = 0;
      for( int i = 0; i < m.length(); i++ ) {
        Character ch = m.charAt( i );
        if( String.valueOf( ch ).equals( "#" ) ) {
          temp++;
          arrayList.set( i - temp, arrayList.get( i - temp ).toLowerCase() );
        } else {
          arrayList.add( String.valueOf( ch ) );
        }
      }

      return arrayList;
    }

    public String solution( String m, String[] musicinfos ) {
      String answer = "";
      /*
      1. 시작 시간 부터 종료 시간 까지 1분당 멜로디가 1개식 추가
      2. 시작 멜로디는 melodie 멜로디 부터 시작
      3. C, C# -> c , D, D# -> d , E, F, F# -> f , G, G# -> g , A, A#  -> a
      */
      //CC#BCC#BCC#BCC#B  list.stream().toArray(String[]::new);

      ArrayList<String> arrayList = changeMelodie( m );

      boolean flag = false;
      for( int i = 0; i < musicinfos.length; i++ ) {
        String[] split = musicinfos[i].split( "," );
        String startTime = split[0].replace( ":", "" );
        String endTime   = split[1].replace( ":", "" );
        String title     = split[2];
        String melodie   = split[3];
        int time = Integer.parseInt( endTime ) - Integer.parseInt( startTime );
        ArrayList<String> list = new ArrayList<String>();
        list = changeMelodie( melodie );

        int count = 0;
        int check = 0;
        int listCount = 0;
        while( true ) {
          if( check == time - 1 ) {
            break;
          }
          if( count == arrayList.size() ) {
            flag = true;
            break;
          }
          if( listCount == list.size() ) {
            listCount = 0;
          }
          if( list.get( listCount ).equals( arrayList.get( count ) ) ) {
            count++;
          } else {
            count = 0;
          }
          listCount++;
          check++;
        }

        if( flag == true ) {
          answer = title;
          break;
        }
      }

      if( flag == false ) {
        answer = "None";
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    String m  = "ABCDEFG";
    String m2 = "CC#BCC#BCC#BCC#B";
    String m3 = "ABC";
    String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
    String[] musicinfos2 = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" };
    String[] musicinfos3 = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
    Solution solution = new Solution();

    /*

     */
    System.out.println( "RESULT = " + solution.solution( m3, musicinfos3 ) );
  }
}
