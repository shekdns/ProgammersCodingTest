import java.util.ArrayList;
import java.util.Collections;

//피로도
public class Pirodo {
  public static class Solution {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public void permutation( int minP[], int[] useP, int[] outputM, int[] outputU, boolean[] visited, int depth, int r, int k ) {
      if( depth == r ) {
        int tempK = k;
        int count = 0;
        for( int i = 0; i < r; i++ ) {
          if( tempK >= outputM[i] ) {
            tempK -= outputU[i];
            count++;
          }
        }
        arrayList.add( count );
        return;
      }
      for( int i = 0; i < minP.length; i++ ) {
        if( visited[i] == false ) {
          visited[i] = true;
          outputM[depth] = minP[i];
          outputU[depth] = useP[i];
          permutation( minP, useP, outputM, outputU,visited, depth + 1, 3, k );
          visited[i] = false;
        }
      }
    }

    public int solution( int k, int[][] dungeons ) {
      int answer = -1;

      int[] minP = new int[dungeons.length];
      int[] useP = new int[dungeons.length];
      int[] outputM = new int[dungeons.length];
      int[] outputU = new int[dungeons.length];
      boolean[] visited = new boolean[dungeons.length];
      for( int i = 0; i < dungeons.length; i++ ) {
        for( int j = 0; j < dungeons[i].length; j++ ) {
          if( j == 0 ) {
            minP[i] = dungeons[i][j];
          } else {
            useP[i] = dungeons[i][j];
          }
        }
      }

      permutation( minP, useP, outputM, outputU,visited, 0, 3, k );
      Collections.sort( arrayList, Collections.reverseOrder() );

      answer = arrayList.get(0);

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int k = 80;
    int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };

    System.out.println( "RESULT = " + solution.solution( k, dungeons ) );
  }
}
