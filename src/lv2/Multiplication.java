package lv2;
//행렬의 곱셈
public class Multiplication {
  public static class Solution {
    public int[][] solution( int arr1[][], int[][] arr2 ) {
      int[][] answer = new int[arr1.length][arr2[0].length];

      for( int i = 0; i < arr2[0].length; i++ ) {
        int z = 0;
        for( int j = 0; j < arr2.length; j++ ) {
          for( int k = 0; k < arr1.length; k++ ) {
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
    int[][] arr4 = { {5,4} };
    int[][] arr5 = { {1,2,3,4}, {1,2,3,4} };
    int[][] arr6 = { {1,2}, {1,2}, {1,2}, {1,2} };

    int[][] result = solution.solution( arr5, arr6 );

    for( int i = 0; i < result.length; i++ ) {
      for( int j = 0; j < result[i].length; j++ ) {
        System.out.print( result[i][j] + " " );
      }
      System.out.println();
    }
  }
}
