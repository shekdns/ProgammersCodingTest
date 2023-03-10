package lv2;
//행렬의 곱셈
public class Multiplication {
  public static class Solution {
    public int[][] solution( int arr1[][], int[][] arr2 ) {
      int[][] answer = new int[arr1.length][arr1[0].length];

      int a1_row = arr1.length;
      int a2_row = arr2.length;
      int a2_col = arr2[0].length;

      for( int i = 0; i < arr2[i].length; i++ ) {
        int z = 0;
        for( int j = 0; j < a2_row; j++ ) {
          for( int k = 0; k < a1_row; k++ ) {
            answer[k][i] += ( arr1[k][z] * arr2[j][i] );
          }
          z++;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] arr1 = { {1,4}, {3,2}, {4,1} };
    int[][] arr2 = { {3,3}, {3,3} };
    int[][] arr3 = { {2,3,2}, {4,2,4}, {3,1,4} };
    int[][] arr4 = { {5,4,3}, {2,4,1}, {3,1,1} };

    int[][] result = solution.solution( arr3, arr4 );

    for( int i = 0; i < result.length; i++ ) {
      for( int j = 0; j < result[i].length; j++ ) {
        System.out.print( result[i][j] + " " );
      }
      System.out.println();
    }
  }
}
