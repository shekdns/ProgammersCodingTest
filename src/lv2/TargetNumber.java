package lv2;

//깊이,너비 우선탐색 DFS,BFS 타겟넘버
public class TargetNumber {
  public static class Solution {
    static int answer;
    public int solution( int[] numbers, int target ) {
      answer = 0;
      dfs( 0, 0, numbers, target );

      return answer;
    }
    public void dfs( int n, int sum, int[] numbers, int target ) {
      if( n == numbers.length ) {
        if( sum == target ) {
          answer++;
        }
        return;
      }

      dfs( n + 1, sum + numbers[n], numbers, target );
      dfs( n + 1, sum - numbers[n], numbers, target );
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] numbers = { 1, 1, 1, 1, 1 };
    int target = 3;

    int result = solution.solution( numbers, target );
    System.out.println( "RESULT = " + result );
  }
}
