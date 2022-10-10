package lv2.kakao;

import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
public class Tuple {
  public static class Solution {
    public int[] solution( String s ) {
      String[] groups = Pattern.compile("\\{(.*?)}")
              .matcher(s.substring(1, s.length() - 1))
              .results()
              .map(MatchResult::group)
              .toArray(String[]::new);
      Arrays.sort(groups, Comparator.comparingInt(String::length));


      List<Integer> answer = new ArrayList<>();
      for(String sub : groups){
        System.out.println( "SS = " + sub );
        sub = sub.substring(1, sub.length() - 1);
        System.out.println( "SUB = " + sub );
        String[] numbers = sub.split(",");

        for(String number : numbers){
          int num = Integer.parseInt(number);
          System.out.println( "NUM = " + num );
          if(!answer.contains(num))
            answer.add(num);
        }
      }


//      String str = s.substring( 1, s.length() - 1 );
//      Pattern pattern = Pattern.compile( "\\{(.*?)\\}" );
//      Matcher matcher = pattern.matcher( str );
//
//      HashMap<Integer, String> map = new HashMap<>();
//      while( matcher.find() ) {
//        if( matcher.group(1).equals( "" ) ) {
//          continue;
//        }
//        int temp = matcher.group(1).length();
//        map.put( temp, matcher.group(1) );
//      }
//
//      Object[] mapKey = map.keySet().toArray();
//      Arrays.sort( mapKey );
//
//      List<Integer> answer = new ArrayList<>();
//
//      for( Map.Entry<Integer, String> entry : map.entrySet() ) {
//        String vv = entry.getValue();
//        System.out.println( vv );
//        String[] split = vv.split( "," );
//
//        for( String ss : split ) {
//          int num = Integer.parseInt( ss );
//          System.out.println( "NUM = " + num );
//          if( !answer.contains( num ) ) {
//            answer.add( num );
//          }
//        }
//      }

//      LinkedHashSet<String> hashSet = new LinkedHashSet<>();
//      for( Map.Entry<Integer,String> entry : map.entrySet() ) {
//        String vv  = entry.getValue();
//        String[] split = vv.split( "," );
//        for( int k = 0; k < split.length; k++ ) {
//          hashSet.add( split[k] );
//        }
//        if( i == 0 ) {
//          answer[i] = Integer.valueOf( vv );
//        } else {
//          String[] split = vv.split("," );
//          for( int k = 0; k < split.length; k++ ) {
//            boolean flag = true;
//            for( int j = 0; j < answer.length; j++ ) {
//              if( split[k].equals( String.valueOf( answer[j] ) ) ) {
//                flag = false;
//                continue;
//              }
//            }
//            if( flag == true ) {
//              answer[i] = Integer.valueOf( split[k] );
//            }
//          }
//        }
//        i++;
//      }

//      answer = new int[map.size()];
//      int i = 0;
//      for( String sss : hashSet ) {
//        answer[i++] = Integer.valueOf( sss );
//      }
      //return answer;
      return answer.stream().mapToInt(Integer::intValue).toArray();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
    String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
    String s3 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
    String s4 = "{{123}}";

    int[] result = solution.solution( s3 );

    for( int r : result ) {
      System.out.print( r + " " );
    }
  }
}
