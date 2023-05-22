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

    public String changeMelodieToString( String m ) {
      ArrayList<String> arrayList = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      int temp = 0;
      for( int i = 0; i < m.length(); i++ ) {
        Character ch = m.charAt( i );
        if( String.valueOf( ch ).equals( "#" ) ) {
          temp++;
          arrayList.set( i - temp, arrayList.get( i - temp ).toLowerCase() );
        } else {
          arrayList.add(String.valueOf(ch));
        }
      }
      for( int i = 0; i < arrayList.size(); i++ ) {
        sb.append( arrayList.get( i ) );
      }

      return sb.toString();
    }

    public String solution( String m, String[] musicinfos ) {
      String answer = "";
      String remember = changeMelodieToString( m );
      int max = Integer.MIN_VALUE;

      for( int i = 0; i < musicinfos.length; i++ ) {
        String[] split = musicinfos[i].split( "," );
        String startTime = split[0].replace( ":", "" );
        String endTime   = split[1].replace( ":", "" );
        boolean flag = false;

        String title     = split[2];
        String melodie   = split[3];
        int inTime  = 0;
        int outTime = 0;
        if( Integer.parseInt( endTime ) > 2400 ) {
          endTime = "2400";
        }
        inTime  = startTime.length() > 3 ? ( Integer.parseInt( startTime.substring( 0, 2 ) ) * 60 ) + Integer.parseInt( startTime.substring( 2, 4 ) ) : ( Integer.parseInt( startTime.substring( 0, 1 ) ) * 60 ) + Integer.parseInt( startTime.substring( 1, 3 ) );
        outTime = endTime.length() > 3 ? (Integer.parseInt(endTime.substring(0, 2)) * 60) + Integer.parseInt(endTime.substring(2, 4)) : (Integer.parseInt(endTime.substring(0, 1)) * 60) + Integer.parseInt(endTime.substring(1, 3));

        System.out.println( inTime + " @@@ " + outTime );

        int time = outTime - inTime;

        System.out.println( time );

        ArrayList<String> arrayList = changeMelodie( melodie );
        String temp = "";
        int k = 0;
        int check = 0;
        while( true ) {
          if( check == time ) {
            break;
          }
          if( k == arrayList.size() ) {
            k = 0;
          }
          temp += arrayList.get( k );
          k++;
          check++;
        }
        System.out.println( temp + " || " + remember );
        for( int j = 0; j < temp.length(); j++ ) {
          if( ( remember.length() + j ) <= temp.length() ) {
            if( temp.substring( j, remember.length() + j ).equals( remember ) ) {
              flag = true;
              break;
            }
          }
        }
        if( flag == true ) {
          if( max < time ) {
            max    = time;
            answer = title;
          }
        }
      }

      return answer;
    }
  }

  //조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
//  각 음은 1분에 1개씩 재생된다. 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
//  음악이 00:00를 넘겨서까지 재생되는 일은 없다.

  public static void main(String[] args) {
    String test = "ABC";
    String[] testArray = { "22:00,22:05,APPLE,ABCABC", "03:00,03:10,BANANA,ABCABC" };

    String m  = "ABCDEFG";
    String m2 = "CC#BCC#BCC#BCC#B";
    String m3 = "ABC";
    String m4 = "DF";
    String m5 = "ABCDEFG";
    String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
    String[] musicinfos2 = { "03:00,03:30,FOO,CC#B", "04:00,04:05,BAR,CC#BCC#BCC#B" };
    String[] musicinfos3 = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
    String[] musicinfos4 = { "6:20,6:50,TEST,DDF" };
    String[] musicinfos5 = { "11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB" };
    Solution solution = new Solution();

    System.out.println( "RESULT = " + solution.solution( test, testArray ) );
  }
}
