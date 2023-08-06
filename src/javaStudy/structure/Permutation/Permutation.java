package javaStudy.structure.Permutation;

public class Permutation {
  //arr[] 는 원본 배열, output[] 은 출력하고자 하는 배열, visited[] 는 방문여부 체크, depth는 탐색하고 있는 인덱스, r 는 뽑고자하는 개수
  private static void permutation( int arr[], int output[], boolean visited[], int depth, int r ) {
    if( depth == r ) {
      for( int i = 0; i < r; i++ ) {
        System.out.print( output[i] + " " );
      }
      System.out.println();
      return;
    }
    for( int i = 0; i < arr.length; i++ ) {
      if( visited[i] == false ) {
        visited[i] = true;
        output[depth] = arr[i];
        permutation( arr, output, visited, depth + 1, r );
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr  = { 80, 50, 30 };
    int[] output = new int[arr.length];
    boolean[] visited = new boolean[arr.length];

    permutation( arr, output, visited, 0, 3 );
  }
}
