package lv1;

import java.util.*;

public class StringMyMind {
  public static class Solution {
    public String[] solution( String[] strings, int n ) {
      String[] answer = new String[strings.length];
      String[] temp   = new String[strings.length];
      LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

      for( int i = 0; i < strings.length; i++ ) {
        Character ch = strings[i].charAt( n );
        temp[i] = String.valueOf( ch );
      }

      Arrays.sort( temp );

      for( int i = 0; i < temp.length; i++ ) {
        ArrayList<String> list = new ArrayList<>();
        for( int j = 0; j < strings.length; j++ ) {
          Character ch = strings[j].charAt( n );
          if( temp[i].equals( String.valueOf( ch ) ) ) {
            list.add( strings[j] );
          }
        }
        map.put( temp[i], list );
      }

      LinkedList<String> newList = new LinkedList<>();
      for( ArrayList<String> al : map.values() ) {
        Collections.sort( al );
        newList.addAll( al );
      }

      int index = 0;
      for( String s : newList ) {
        answer[index++] = s;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strings1 = { "sun", "bed", "car" };
    String[] strings2 = { "abce", "abcd", "cdx" };
    int n = 1;

    String[] result = solution.solution( strings1, n );

    for( String s : result ) {
      System.out.print( s + " " );
    }
  }
}
