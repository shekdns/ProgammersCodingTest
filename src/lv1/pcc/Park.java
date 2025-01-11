package lv1.pcc;

public class Park {
  public static class Solution {
    public int solution(int[] mats, String[][] park) {
      int answer = 0;

      int startRow = 0;
      int startCol = 0;
      int count = 0;

      int maxCol = park.length;
      int maxRow = park[0].length;
      int tempCol = 0;

      for( int i : mats ) {  //i = 5
        for( int j = startCol; j < park.length; j++ ) {
          j = startCol;
          for( int k = startRow; k < park[j].length; k++ ) {
            int a = maxRow - startRow;
            if( a < i ) {
              startCol++;
              tempCol = startCol;
              startRow = 0;
              break;
            }
            if( park[j][k].equals( "-1" ) ) {
              count++;

              if( count % i == 0 ) {
                startCol++;
                tempCol = startCol;
                break;
              }
            } else {
              startRow++;
              count = 0;
              startCol = tempCol;
              break;
            }
          }
          int c = maxCol - startCol;
          if( c < i ) {
            break;
          }
          if( count > 0 ) {
            if( count % i == 0 ) {
              answer = i;
            }
          }
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] mats   = { 5, 3, 2 };
    String[][] park = { { "A", "A", "-1", "B", "C", "F", "G", "-1" },
                        { "A", "A", "-1", "B", "C", "F", "G", "-1" },
                        { "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" },
                        { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" },
                        {  "D", "D", "-1", "-1", "-1", "-1", "-1", "F" },
                        { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" } };

    System.out.println( "RESULT = " + solution.solution( mats, park ) );
  }
}
