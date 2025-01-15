package lv1.pcc;

import java.util.*;

//작은 값 오름차순
public class DataAnalysis {
  public static class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
      int[][] answer = {};

      List<HashMap<String, Integer>> list      = new ArrayList<>();
      List<HashMap<String, Integer>> parseList = new ArrayList<>();
      for( int i = 0; i < data.length; i++ ) {
        HashMap<String, Integer> temp = new HashMap<>();

        temp.put( "code", data[i][0] );
        temp.put( "date", data[i][1] );
        temp.put( "maximum", data[i][2] );
        temp.put( "remain", data[i][3] );

        list.add( temp );
      }

      for( HashMap<String, Integer> map : list ) {
        int value = map.get( ext );

        if( value < val_ext ) {
          parseList.add( map );
        }
      }

      Collections.sort( parseList, new Comparator<HashMap<String, Integer>>() {
        @Override
        public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
          return o1.get(sort_by) - o2.get(sort_by);
        }
      });

      answer = new int[parseList.size()][4];
      int k = 0;
      for( HashMap<String, Integer> map : parseList ) {
        answer[k][0] = map.get( "code" );
        answer[k][1] = map.get( "date" );
        answer[k][2] = map.get( "maximum" ) ;
        answer[k][3] = map.get( "remain" );
        k++;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] data = { { 1, 20300104, 100, 80 }, { 2, 20300804, 847, 37 }, { 3, 20300401, 10, 8 } };
    String ext    = "date";
    int valExt    = 20300501;
    String sortBy = "remain";

    int[][] result = solution.solution( data, ext, valExt, sortBy );

    for( int i = 0; i < result.length; i++ ) {
      for( int j = 0; j < result[i].length; j++ ) {
        System.out.print( result[i][j] + " " );
      }
      System.out.println();
    }
  }
}
