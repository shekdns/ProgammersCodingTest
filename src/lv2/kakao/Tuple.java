package lv2.kakao;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tuple {
  public static class Solution {
    public int[] solution( String s ) {
      int[] answer;

      String str = s.substring( 1, s.length() - 1 );
      Pattern pattern = Pattern.compile( "\\{(.*?)\\}" );
      Matcher matcher = pattern.matcher( str );

      HashMap<Integer, String> map = new HashMap<>();
      while( matcher.find() ) {
        int temp = matcher.group(1).length();
        map.put( temp, matcher.group(1) );
      }

      Object[] mapKey = map.keySet().toArray();
      Arrays.sort( mapKey );
      System.out.println( map );
      answer = new int[map.size()];

      int i = 0;
      for( Map.Entry<Integer,String> entry : map.entrySet() ) {
        String vv  = entry.getValue();

        if( i == 0 ) {
          answer[i] = Integer.valueOf( vv );
        } else {
          String[] split = vv.split("," );
          for( int k = 0; k < split.length; k++ ) {
            boolean flag = true;
            for( int j = 0; j < answer.length; j++ ) {
              if( split[k].equals( String.valueOf( answer[j] ) ) ) {
                flag = false;
                continue;
              }
            }
            if( flag == true ) {
              answer[i] = Integer.valueOf( split[k] );
            }
          }
        }
        i++;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
    String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
    String s3 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
    String s4 = "{{123}}";

    int[] result = solution.solution( s4 );

    for( int r : result ) {
      System.out.print( r + " " );
    }
  }
}
